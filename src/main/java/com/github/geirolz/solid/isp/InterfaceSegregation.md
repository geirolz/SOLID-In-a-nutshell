# (I)nterface Segregation

If you have a **class that has several clients**, rather than loading the class with all the methods that the clients need, 
**create specific interfaces for each client**.

<p class="notebox">
"Make fine grained interfaces that are client specific."
</p>
<p class="notebox">
    “Many client specific interfaces are better than one general purpose interface.”
</p>
<p class="notebox">
    “Clients should not be forced to depend upon interfaces that they do not use.”
</p>

## Advantages
- **Compilation** - clients depends on interfaces, in case implementation has changes you don't need to recompile all clients also.
- **High cohesion** - better understandability and robustness
- **Low coupling** - better maintainability and scalability

---
## Problem #1
- `Client A`, `Client B` and `Client C` have a dependency with `Service`.
- `Service` implements all methods for all clients, therefore all clients can see also the methods that they don't should use.
- Changes on `Service` class can impact all clients  
- Changes on `Service` force all clients recompilation 

<img style="width: 70%" class="centered" src="src/main/resources/imgs/InterfaceSegregation_problem_1.svg"/>

---
## Problem #1 - Solution
- Create a **fine-grained interfaces**, one for each client.
- Replace clients implementation dependencies with interfaces/abstractions dependencies.

In this way clients:
- Can see only the methods they should use.
- Are decoupled by the Service, so if service implementation changes behavior clients doesn't require recompilation.
 
<img style="width: 45%" class="centered" src="src/main/resources/imgs/InterfaceSegregation_problem_1_solution.svg"/>

---
## Problem #1 - Example

```java
class Calculator{
    public Double sum(Double v1, Double v2){...}
    public Double multiply(Double v1, Double times){...}
}

class SumInteger{
    private final Serializer service;
    public Document sumInt(){
        return service.toXml(this.value);
    }   
}

```

---
## Problem #2
Fat interface defines a lot of methods **BUT** some implementations of this interface don't need some method.

In a lot of cases this problem is evident where instead of method implementation we see throwing an exception. 

<img style="width: 90%" class="centered" src="src/main/resources/imgs/InterfaceSegregation_problem_2.svg"/>

---
## Problem #2 - Solution
- Split fat interface into fine-grained interface. Therefore subtypes only implements the required interfaces.
- Clients should depends on abstraction.

<img style="width: 90%" class="centered" src="src/main/resources/imgs/InterfaceSegregation_problem_2_solution.svg"/>

---
## Problem #2 - Example
- `Person` can both **work** and **eat**.
- `Robot` can **work** but it can't **eat**. 

```java
    interface Worker{
        int workHours();
        void eat();    
    }   

    class Person implements Worker{
        public int workHours(){ return 0; }
        public void eat(){ 
            System.out.println("I'm eating."); 
        }
    }
 
    class Robot implements Worker{
        public int workHours(){ return 0; }
        public void eat(){ 
            throw new RuntimeException("I'm a robot!"); 
        }
    }  
```
---
## Problem #2 - Example Solution
- `Person` both implements `Worker` and `Eater`.
- `Robot` implements just `Worker` losing `eat()` method.

```java
    interface Worker {
        int workHours();   
    } 
  
    interface Eater {
        void eat();    
    } 

    class LazyPerson implements Worker, Eater {
        public int workHours(){ return 0; }
        public void eat(){ 
            System.out.println("I'm eating.");
        }
    }
 
    class Robot implements Worker{
        public int workHours(){ return 0; }
    }
```


---
## Exercise
Look at `com.github.geirolz.solid.isp.exercise` package and then:
- **Refactor** `PaymentService` in order to respect the ISP.

#### Hints
- _Fine-grained interfaces_
- _No exceptions_

 