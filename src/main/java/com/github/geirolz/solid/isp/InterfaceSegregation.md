# (I)nterface Segregation

If you have a **class that has several clients**, rather than loading the class **with all the methods that the clients need**, create
**specific interfaces** for each client and **multiply inherit** them into the class.

<img src="src/main/resources/imgs/InterfaceSegregationDraw.svg"/>

