# (O)pen/Closed

We should write our modules so that they can be **extended**, **without modifying them**. In other
words, we want to be able to change what the modules do, without changing the
source code of the modules.

> *A module should be open for extension but closed for modification.*

<p class="centered"><b>Abstraction is the key to the OCP</b></p>

---
## Example
This class violates the OCP because:
* Every time anything needs to be done to the modem, a switch statement if/else chain will
  need to select the proper functions to use.
* When new modems are added, or modem policy changes, the code must be scanned for all these selection statements, and each
  must be appropriately modified. 
  
```java
        enum Type { Modem1, Modem2 }
    
        interface Modem { Type getType(); }

        public class Modem1 implements Modem {
            public Type getType(){ return Type.Modem1; }
        }
        public class Modem2 implements Modem {
             public Type getType(){ return Type.Modem2; }
        }

        public void logOn(Modem m, String pno) {
            if (m.getType() == Type.Modem1)
                dialModem1(pno);
            else if (m.getType() == Type.Modem2)
                dialModem2(pno);
            // ...you get the idea
        }
```

---
## Example solution - Dynamic Polymorphism
We have to be able to make the `LogOn` function depends only upon the `Modem` interface. 
Additional modems will not cause the `LogOn` function to change. 
Thus, we have created a module that can be extended, with new modems, without requiring modification.

```java
public class LogOn {

    public void logOn(Modem modem, String pno) {

        modem.dial(pno);
    }
    public interface Modem {

        void dial(String pno);
        void send(String toSend);
        String receive();
        void hangup();
    }
}
```

- `LogOn` has been closed for modification because we don't need to modify the class if a `Modem` functionality changes or if a new `Modem` is added.
- `LogOn` has been opened for extension because if we want to change the behaviour of a `Modem` we only have to inject it in the `logOn` method without modifying his implementation.

---
## An example of Modem implementation

```java
public class Modem1 implements Modem {

    public void dial(String pno) {
        System.out.println("Dial modem 1");
    }

    public void send(String toSend) {
        System.out.println("Send modem 1");
    }

    public String receive() {
        return "Receive modem 1";
    }

    public void hangup() {
        System.out.println("Hangup modem 1");
    }
}
```

Try to think about another Modem implementation! The `LogOn` code will not change!

---
## Example solution - Static Polymorphism 
The LogOn function can be extended with many different types of modems without requiring modification thanks to the Generic Parameter.

```java

public class LogOn<GenericModem extends Modem> {

    public void logOn(GenericModem modem, String pno) {
        modem.dial(pno);
    }

    public interface Modem {
        void dial(String pno);

        void send(String toSend);

        String receive();

        void hangup();
    }
}
```

---
## Architectural Goals of OCP

* We can create modules that are extensible, without being changed
* We can add new features to existing code, without changing the existing code and by only adding new code

> *It is always better if changes do not propogate into existing code that already works.
> If you don’t have to change working code, you aren’t likely to break it.*

---
## Exercise
Look at `com.github.geirolz.solid.ocp.exercise` package and then:
- **Add a new `TShirtPriceCalculator`** in `ItemPrice` in the rough way.
- **Refactor** `ItemPrice` in order to respect the OCP adopting dynamic polymorphism.
- **Refactor** `ItemPrice` in order to respect the OCP adopting static polymorphism.
- **Execute** the `com.github.geirolz.solid.ocp.exercise.OcpMain` class to check the outputs.

#### Hints
- Abstraction is the key of OCP