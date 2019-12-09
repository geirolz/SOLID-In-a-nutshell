### A true story:
The design of many software applications begins as a vital image in the minds of its designers. 
At this stage it is clean, elegant, and compelling. 
It has a simple beauty that makes the designers and implementers itch to see it working. 
Some of these applications manage to maintain this purity of design through the initial development and into the first 
release.

![alt text](https://media.giphy.com/media/Mp4hQy51LjY6A/source.gif "Well done!")

---

### A (sad) true story:
But then something begins to happen. The software starts to rot. At first it isn’t so bad. 
An ugly wart here, a clumsy hack there, but the beauty of the design still shows through.

![alt text](https://media.giphy.com/media/R58jyn0kwwSpq/source.gif "Ok, I can fix that!")

---

### A (very sad) true story:

Yet, over time as the rotting continues, the ugly festering sores and boils accumulate until they dominate the design 
of the application. 
The program becomes a festering mass of code that the developers find increasingly hard to maintain.
Eventually the sheer effort required to make even the simplest of changes to the application becomes so high that the 
engineers and front line managers cry for a redesign project.
Such redesigns rarely succeed. 
Though the designers start out with good intentions, they find that they are shooting at a moving target. 
The old system continues to evolve and change, and the new design must keep up.
The warts and ulcers accumulate in the new design before it ever makes it to its first release. 
On that fateful day, usually much later than planned, the morass of problems in the new design may be so bad that the 
designers are already crying for another redesign.
![alt text](https://media.giphy.com/media/L2iazgzya38bK/source.gif "Ok, goodbye ...")

The immediate cause of the degradation of the design is well understood. 
The requirements have been changing in ways that the initial design did not anticipate. 
Often these changes need to be made quickly, and may be made by engineers who are not familiar with the original design 
philosophy.
 
---

### Symptoms of Rotting Design:
* **Rigidity**: the tendency for software to be difficult to change, even in simple ways. Every change causes a cascade of 
subsequent changes in dependent modules.
* **Fragility**: the tendency of the software to break in many places every time it is changed.
* **Immobility**: the inability to reuse software from other projects or from parts of the same project.
* **Viscosity**: 
    - *viscosity of the design*: when faced with a change, engineers usually find more than one way to make the change. 
Some of the ways preserve the design, others do not (i.e. they are hacks.) When the design preserving methods are harder 
to employ than the hacks, then the viscosity of the design is high. It is easy to do the wrong thing, but hard to do the 
right thing.
    - *viscosity of the environment*:  when the development environment is slow and inefficient. For example, if compile 
times are very long, engineers will be tempted to make changes that don’t force large recompiles, even though those
changes are not optimal from a design point of view.

---

### Useful design principles:
* The theory of SOLID principles was introduced by Robert C. Martin in his 2000 paper *'Design Principles and Design Patterns'* 
* SOLID acronym was introduced later (in 2004) by Michael Feathers.

The goal of the principles is the creation of mid-level software structures that:
* Tolerate change
* Easy to understand
* Basis of components that can be used in many software systems.

The term "mid-level" refers to the fact that these principles are applied by programmers working at the module level. 
They are applied just above the level of the code and help to define the kinds of software structures used within 
modules and components.

---
### SOLID PRINCIPLES
* **S**ingle responsibility
* **O**pen closed
* **L**iskov substitution
* **I**nterface segregation
* **D**ependency inversion