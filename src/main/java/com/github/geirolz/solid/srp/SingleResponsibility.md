# (S)ingle Responsibility

**Conway's law:**

> *organizations which design systems are constrained to produce designs which are copies of the communication 
structures of these organizations.
— M. Conway*

A corollary to Conway’s law: the best structure for a software system is heavily influenced by the 
social structure of the **organization that uses it** so that each software **module** has one, and only one, 
reason to change.

* organization that uses it: a group—one or more people who require that change.
* module: the simplest definition is just a source file, or, more generally, a cohesive set of functions and data structures.

---
## A typical example:

```java
    class Employee {
        public BigDecimal calculatePay() { ... }
        public BigDecimal reportHours() { ... }
        public void save() { ... }
    }
```

This class violates the SRP because those three methods are responsible to three very different actors.
* The `calculatePay()` method is specified by the accounting department, which reports to the CFO.
* The `reportHours()` method is specified and used by the human resources department, which reports to the COO.
* The `save()` method is specified by the database administrators (DBAs), who report to the CTO.

---

## SYMPTOM 1: ACCIDENTAL DUPLICATION

```java
    class Employee {
        public BigDecimal calculatePay() { ... }
        public BigDecimal reportHours() { ... }
        public void save() { ... }

        private BigDecimal regularHours() { ... }
    }
```
Private method `regularHours()` calculates non-overtime hours and it's shared by `calculatePay()` and `reportHours()`.

*New requirement*: the CFO’s team decides that the way non-overtime hours are calculated needs to be tweaked.
In contrast, the COO’s team in HR does not want that particular tweak because they use non-overtime hours for a 
different purpose.

What happened if `regularHours()` will be changed and the developer will not notice that the function is also called by 
the `reportHours()` function?
* The CFO’s team validates that the new function works as desired, and the system is deployed.
* the COO’s team doesn’t know that this is happening....

---

## SYMPTOM 2: MERGES

Suppose that:
* the CTO’s team of DBAs decides that there should be a simple schema change to the Employee table of the 
database.
* the COO’s team of HR clerks decides that they need a change in the format of the hours report.

Two different developers, possibly from two different teams, check out the Employee class and begin to make changes. 
Unfortunately their changes collide. The result is a merge (*a risky affair*).

<div class="centered">
    <img src="https://media.giphy.com/media/iMI5MNqWc7GsS9YoK6/giphy.gif" alt="A risky affair!" />
</div>

---

## SOLUTION

Key-rule: **SEPARATE THE DATA FROM THE FUNCTIONS**

```java
    class EmployeeData { ... }

    class PayCalculator {
        private EmployeeData employeeData;        
        public PayCalculator(EmployeeData employeeData) {
            this.employeeData = employeeData;
        }
        public BigDecimal calculatePay() { ... }
    }

    class HourReporter {
        private EmployeeData employeeData;        
        public HourReporter(EmployeeData employeeData) {
            this.employeeData = employeeData;
        }
        public BigDecimal reportHours(EmployeeData employeeData) { ... }
    }

    class EmployeeSaver {
        public EmployeeSaver(EmployeeData employeeData) {
            this.employeeData = employeeData;
        }
        private EmployeeData employeeData;
        public void save(EmployeeData employeeData) { ... }
    }
```
---

## Exercise
Look at `com.github.geirolz.solid.srp.exercise` package and then:
- **Refactor** `com.github.geirolz.solid.srp.exercise.Order` in order to respect the SRP.
- **Execute** the `com.github.geirolz.solid.srp.exercise.SrpMain` class to check the outputs.

#### Hints
- _Remember the key-rule: **SEPARATE THE DATA FROM THE FUNCTIONS**_