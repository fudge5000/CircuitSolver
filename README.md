# CircuitSolver
Model and solve electric circuits using strategies learned in ECE 081


#Process for solving a simple circuit using nodes

1. Simplify to a certain degree by using Norton / Thevenin and Req

2. Pick a ground node, preferably on one side of a voltage source

3. Fill in any node voltages that are instantly apparent due to a voltage source

4. If there is a voltage source between two unknown nodes, convert to a supernode

5. generate system of KCL equasions for each of the nodes as well as any compatability equasions for supernodes

6. solve system of equasions using matricies

7. Fill in the rest of the node voltages and use to find voltage drops over all elements

8. Use voltages to find all currents through resistors

9. Use KCL to find all currents through voltage sources


#Process for solving a simple circuit using mesh

1. Simplify to a certain degree by using Norton / Thevenin and Req

2. Convert the circuit into a number of non-rhedundant meshes

3. If there is an internal current source, convert to a supermesh

4. generate system of KVL equasions for each of the meshes as well as any compatability equasions for supermeshes

5. solve system of equasions using matricies

6. Use mesh currents to find currents accross all elements

7. Use currents to find all voltage drops over resistors

8. Use KVL to find all voltage drops over current sources
