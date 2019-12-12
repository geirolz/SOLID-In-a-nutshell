class: center, middle
# SOLID Principles

---

## A true story - by Robert C. Martin:
The design of many software applications begins as a vital image in the minds of its designers.
 
At this stage it is **clean, elegant, and compelling**.

It has a simple beauty that makes the designers and implementers **itch to see it working**.

<div class="centered">
    <img src="https://media.giphy.com/media/Mp4hQy51LjY6A/source.gif" alt="Well done!" />
</div>

---
## A (sad) true story - by Robert C. Martin
But then something begins to happen.

The software starts to rot.

At first it isn’t so bad. An ugly wart here, a clumsy hack there, but the beauty of the design still shows through.

<div class="centered">
    <img src="https://media.giphy.com/media/R58jyn0kwwSpq/source.gif" alt="Ok, I can fix that!" />
</div>

---
## A (very sad) true story - by Robert C. Martin
The program becomes a festering mass of code that the developers find increasingly hard to maintain.

Eventually the sheer effort required to make even the simplest of changes to the application becomes so high that the 
engineers and front line managers cry for a **redesign project**. Such redesigns rarely succeed.
 
Though the designers start out with good intentions, they find that **they are shooting at a moving target**. 
The old system continues to evolve and change, and the new design must keep up.
On that fateful day, usually much later than planned, the morass of problems in the new design may be so bad that the 
designers are already crying for another redesign.
<div class="centered">
    <img src="https://media.giphy.com/media/L2iazgzya38bK/source.gif" alt="Ok, goodbye ..." />
</div>
 
---
## Symptoms of Rotting Design:
The immediate cause of the degradation of the design is well understood. 
The requirements have been changing in ways that the initial design did not anticipate. 
Often these changes need to be made quickly, and may be made by engineers who are not familiar with the original design 
philosophy.

The Symptoms of Rotting Design are:
* **Rigidity**: difficult to change, even in simple ways. Every change causes a cascade of subsequent changes in dependent modules.
* **Fragility**: the tendency of the software to break in many places every time it is changed.
* **Immobility**: the inability to reuse software from other projects or from parts of the same project.
* **Viscosity**: 
    - *viscosity of the design*: when faced with a change, engineers usually find more than one way to make the change. 
When the design preserving methods are harder to employ than the hacks, then the viscosity of the design is high. 
It is easy to do the wrong thing, but hard to do the right thing.
    - *viscosity of the environment*:  when the development environment is slow and inefficient. For example, if compile 
times are very long, engineers will be tempted to make changes that don’t force large recompiles, even though those
changes are not optimal from a design point of view.

---
## Useful design principles
* The theory of SOLID principles was introduced by Robert C. Martin in his 2000 paper **'Design Principles and Design Patterns'** 
* **S.O.L.I.D. acronym** was introduced later (in 2004) by Michael Feathers.

The goal of the principles is the creation of software structures that:
* Tolerate change
* Easy to understand
* Basis of components that can be used in many software systems.

---
## SOLID Principles
- [(S)ingle Responsibility](src/main/java/com/github/geirolz/solid/srp/SingleResponsibility.md)
- [(O)pen/Closed](src/main/java/com/github/geirolz/solid/ocp/OpenClosed.md)
- [(L)iskov Substitution](src/main/java/com/github/geirolz/solid/lsp/LiskovSubstitution.md)
- [(I)nterfaces Segregation](src/main/java/com/github/geirolz/solid/isp/InterfaceSegregation.md)
- [(D)ependency Inversion](src/main/java/com/github/geirolz/solid/dip/DependencyInversion.md)
