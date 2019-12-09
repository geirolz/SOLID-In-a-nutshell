# (I)nterface Segregation

If you have a **class that has several clients**, rather than loading the class with all the methods that the clients need, 
**create specific interfaces for each client**.

<div class="notebox">
    “Many client specific interfaces are better than one general purpose interface.”
</div>
<br/>
<div class="notebox">
    “Clients should not be forced to depend upon interfaces that they do not use.”
</div>

----

<table>
    <tr>
        <th>Problem</th>
        <th>Solution</th>
    </tr>
    <tr>
        <td>
            <img style="width: 90%" class="centered" src="src/main/resources/imgs/InterfaceSegregation_problem.svg"/>
        </td>
        <td>
            <img style="width: 90%" class="centered" src="src/main/resources/imgs/InterfaceSegregation_solution.svg"/>
        </td>
    </tr>
</table>


---
## Advantages
- **Compilation** - clients depends on interfaces, in case implementation has changes you don't need to recompile all clients also.
- **High cohesion** - better understandability and robustness
- **Low coupling** - better maintainability and scalability

---
## Example

#### Problem
A **person** can both **work** and **eat**.

A **robot** can **work** but it can't **eat**. 

```java
    interface Worker{
        int workHours();
        void eat();    
    }   

    class Person implements Worker{
        public int workHours(){ return 0; }
        public void eat(){ System.out.println("I'm eating."); }
    }
 
    class Robot implements Worker{
        public int workHours(){ return 0; }
        public void eat(){ throw new RuntimeException("I'm a robot!"); }
    }  
```
---
#### Solution
Now `workHours()` and `eat()` methods have been split into two separated interfaces `Worker` and `Eater`.

`Person` still have `workHours()` and `eat()` methods because now it is both a `Worker` and a `Eater`.

`Robot` still be just a `Worker` so losing `eat()` method.

```java
    interface Worker{
        int workHours();   
    } 
  
    interface Eater{
        void eat();    
    } 

    class Person implements Worker, Eater{
        public int workHours(){ return 0; }
        public void eat(){ System.out.println("I'm eating."); }
    }
 
    class Robot implements Worker{
        public int workHours(){ return 0; }
    }  
```


 