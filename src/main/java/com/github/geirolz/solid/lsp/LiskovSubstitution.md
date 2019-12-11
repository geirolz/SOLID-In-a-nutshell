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

```

---

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

---

## Let a Circle be an Ellipse

The first smell is that since Circle inherits from Ellipse it will inherit all ellipse properties but it only needs two properties(center point, radius lenght).

Let's try to implement the Circle class.

```java

class Circle extends Ellipse {

        @Override
        void setFoci(Point a, Point b) {
            super.setFoci(a, a);
        }
    }

```

Certainly the model we have created is self consistent. An instance of Circle will obeys all the rules of a circle. There is nothing you
can do to it to make it violate those rules. So too for Ellipse. The two classes form
a nicely consistent model, even if Circle has one too many data elements.

---

## Circle and Ellipse do not live alone...

Circles and Ellipses cohabit in a universe with many other entities and a lot of users can use them to make their logic.

For example...

```java

class Client {

        void prove(Ellipse e) {
            Point f1 = new Point(-1, 1);
            Point f2 = new Point(1,0);
            double majorAxisLength = 3d;
            e.setFoci(f1, f2);
            e.setMajorAxisLength(majorAxisLength);

            assert(e.getFocusA() == f1);
            assert(e.getFocusB() == f2);
            assert(e.getMajorAxisLength() == majorAxisLength);
        }
    }

```
* If we pass an Ellipse instance to our prove method it will respect all the assertions.
* What happens if we pass a Circle instance? **Hint: remember the implementation of Circle setFoci**

** Circle violates the LSP because it does not honor the implied contract of Ellipse and it's not substitutable**

---

## Repercussions of LSP Violation
Unfortunately, LSP violations are difficult to detect until it is too late. 
In the Circle/Ellipse case, everything worked fine until some client came along and discovered that the implicit contract had been violated.

