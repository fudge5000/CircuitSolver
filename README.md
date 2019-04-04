# CircuitSolver
Model and solve electric circuits using strategies learned in ECE 081

Currently this program can only do nodal analysis on circuits that don't require supernodes and doesn't simplify anything.
Mesh analysis has not yet been implemented.

# Process for solving a simple circuit using nodes

1. Simplify to a certain degree by using Norton / Thevenin and Req

2. Pick a ground node, preferably on one side of a voltage source

3. Fill in any node voltages that are instantly apparent due to a voltage source

4. If there is a voltage source between two unknown nodes, convert to a supernode

5. Generate any compatibility equations for super-nodes

6. Generate system of KCL equations for each of the nodes

7. Solve the system of equations using matrices

8. Fill in the rest of the node voltages and use to find voltage drops over all elements

9. Use voltages to find all currents through resistors

10. Use KCL to find all currents through voltage sources 


# Process for solving a simple circuit using mesh

1. Simplify to a certain degree by using Norton / Thevenin and Req

2. Convert the circuit into a number of non-redundant meshes

3. If there is an internal current source, convert to a supermesh

4. Generate compatibility equations for all super-meshes

5. Generate system of KVL equations for each of the meshes

6. Solve the system of equations using matrices

7. Use mesh currents to find currents across all elements

8. Use currents to find all voltage drops over resistors

9. Use KVL to find all voltage drops over current sources

# Future Features
* Adjust to use complex values to allow for solutions in the phasor domain
* Import netlist from circuit building UI
* Solve switching problems
* Add op-amps
