# (D)ependency Inversion 

#### Goal
 Decouple software modules.

#### Principle states
- _**High-level**_ modules should not depend on _**low-level**_ modules. Both should depend on _**abstractions**_ 
- _**Abstractions**_ should not depend on _**concrete implementations**_. _**Concrete implementations**_ should depend on _**abstractions**_.

---

#### Example

```java
    class StdLogger {
        
        public void log(String msg){
            System.out.println("[LOG] " + msg);
        }   
    }

    class MyClass {
    
        private final StdLogger logger = new StdLogger();
    
        public void run(){
           //[...]
           logger.log("THIS IS A LOG.");
           //[...]
        }       
    } 
```
In this case our class(High-level module) depends directly on `StdLogger` implementation(Low-level module) and if we want log on a file for instance we must 
change the code inside `MyClass`.

---

Solution:
- Introduce `Logger` interface 
- Create a constructor in `MyClass` and lets the decision of which logger use to who use `MyClass` 
```java
    interface Logger{
        void log(String msg);
    }
    
    class StdLogger implements Logger {
        
        @Override
        public void log(String msg){
            System.out.println("[LOG] " + msg);
        }   
    }
  
    class FileLogger implements Logger {
        
        @Override
        public void log(String msg){
            //Append log on file
        }   
    }  

    class MyClass {
    
        private final Logger logger;

        public MyClass(Logger logger){
            this.logger = logger;
        }
    
        public void run(){
           //[...]
           logger.log("THIS IS A LOG.");
           //[...]
        }       
    } 
```

This approach is called **Dependency Injection**, in particular **Constructor Injection**
