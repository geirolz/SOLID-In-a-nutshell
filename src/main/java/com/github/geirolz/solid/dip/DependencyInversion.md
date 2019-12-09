# (D)ependency Inversion 

## Advantages
- Flexible and reusable code
- Decoupled modules 
- Easy testing

##Rules
- Don’t refer to volatile concrete classes. Refer to abstract interfaces instead.
- Don’t derive from volatile concrete classes.

----

**Volatile** = code that frequently changes.

**Stable** = code that almost never changes.

---
## How can i write a SW without concretions?
Obviusly we need concretions but:
- Refer to **concrete implementation** only if it is **stable**.
- Refer to **abstraction** where you have a **volatile** code.    

<div class="notebox">EASY IS BETTER<br>DO NOT CREATE ABSTRACTION WHERE IS NOT NEEDED</div>


#### Example 
- **String** class is **Stable**
- **DatabaseConnector** class is **Volatile**


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
