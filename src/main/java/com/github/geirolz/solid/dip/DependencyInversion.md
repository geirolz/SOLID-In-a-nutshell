# (D)ependency Inversion 
> *Depend on abstractions, not on concretions.*

### Goal
Decouple software modules

### Rules
- **Abstractions** should **NOT** depends on **concretes**.
- **Concretes** should depends on **abstractions**.
 
### Advantages
- Flexible and reusable code
- Decoupled modules 
- Easy testing

---
## Don't abuse of DIP

> *Simpler is better*

We need to depends on abstraction, right! But with moderation:
- Depend on **abstraction** in case of a **volatile** class.
- Depend on **concretes** in case of a **stable** class. 

**Stable** class is a class that has low probabilities to be changed.
For instance, `String` class in Java is a stable class.

**Volatile** class is a class that has frequent changes. 

---
## Problem
`Client` depends directly on concrete `Service`.
Assuming that `Service` is a volatile class the DIP in violated.

<img style="width: 60%" class="centered" src="src/main/resources/imgs/DependencyInversion_problem.svg"/>

## Solution
Introducing `Service` interface `Client` depends on abstraction and the DIP is respected

<img style="width: 60%" class="centered" src="src/main/resources/imgs/DependencyInversion_solution.svg"/>

---
## Problem - Example 
`PlcMachine` depends on concrete `AlarmNotifier`. 

```java
    class AlarmNotifier{
        public void notifyAlarm(String msg){
            //Send msg via mail with SMTP
        }
    }  

    class PlcMachine {
        public final AlarmNotifier alarmNotifier 
                            = new AlarmNotifier();
    
        public void run(){
            [...]
            //in case of error
            alarmNotifier.notifyAlarm("Plc error.")
            [...]
        }         
    }   
```

---
## Problem - Example solution
Now `PlcMachine` depends on abstract `AlarmNotifier` and we can inject the instance we prefer.  

```java
    interface AlarmNotifier{
        void notifyAlarm(String msg);
    }   
    class MailAlarmNotifier implements AlarmNotifier{
        public void notifyAlarm(String msg){...}
    }  
    class PlcMachine {
        public final AlarmNotifier alarmNotifier;
    
        public PlcMachine(AlarmNotifier alarmNotifier){
            this.alarmNotifier = alarmNotifier;  
        }
   
        public void run(){...}         
    }   
```

_This solution is known as **Dependency Injection**_
