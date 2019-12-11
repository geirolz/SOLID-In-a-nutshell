# (L)iskov Substitution

This principle was coined by Barbar Liskov in her work regarding data abstraction and type theory.
It also derives from the concept of Design by Contract (DBC) by Bertrand Meyer.


<div class="notebox">
    "Subclasses should be substitutable for their base classes."
</div>

Given:
* User
* BaseClass
* DerivedClass

Let's do an example!

---

## Implementing the definition

```java

class Base {
    
}

class Derived extends Base {
    
}

class User {
    
    static void doSomethingWithBaseClass(Base base) {
        
    }
    
    doSomethingWithBaseClass(new Derived())
}

```

It's seems even obvious or easy...but...

---

## TO BE MORE PRACTICAL

Let's introduce the **Circle/Ellipse Dilemma**.
All circles are ellipses with coincident foci.
This relationship tempts us to model circles and ellipses using inheritance.

```java

class Ellipse {
    
}

class Circle extends Ellipse {
    
}

class Point {
    
    Int x;
    Int y;
    
    Point(Int x, Int y) {
        this.x = x;
        this.y = y;
    }
}

```

---

# Ellipse class

```java

class Ellipse {
    
    Point focusA;
    Point focusB;
    Double majorAxisLength;
    
    Ellipse(Point focusA, Point focusB, Double majorAxisLength) {
        this.focusA = focusA;
        this.focusB = focusB;
        this.majorAxisLength = majorAxisLength;
    }
    
    void setFoci(Point a, Point b) {
        this.focusA = a;
        this.focusB = b;
    }
    
    void setMajorAxisLength(Double majorAxisLength) {
        this.majorAxisLength = majorAxisLength;
    }
    
    Point getFocusA() {
        return focusA;
    }
    
    Point getFocusB() {
        return focusB;
    }
    
    Double getMajorAxisLength() {
        return majorAxisLength;
    }
}


```