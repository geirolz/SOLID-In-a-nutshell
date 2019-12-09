# (I)nterface Segregation

If you have a **class that has several clients**, rather than loading the class **with all the methods that the clients need**, create
**specific interfaces** for each client and **multiply inherit** them into the class.

<div class="notebox">
    “Clients should not be forced to depend upon interfaces that they do not use.”
</div>


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

