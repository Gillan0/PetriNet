#Petri Net Simulator

#About the Project

This project is a Petri Net Simulator designed to model and analyze the behavior of discrete-event systems, such as computing or industrial processes. A Petri net is a mathematical model consisting of:

Places: Represent states and hold tokens.
Transitions: Represent events or changes.
Arcs: Connect places and transitions with a defined value (default: 1).
How it Works
A transition is enabled when its input places have enough tokens to satisfy the incoming arc values.
When a transition fires, tokens are transferred from input places to output places based on the arc values.
The simulation allows dynamic changes to token distribution, enabling the modeling of complex system behaviors.


Java Implementation: Developed in Java (version 23.0.1) with JUnit 5 for testing.


#Getting Started

Prerequisites
Java Development Kit (JDK): Ensure you have JDK 23.0.1 or higher installed.
JUnit 5: Add JUnit to your build path for testing.
Installation
Clone the repository:
bash
Copy code
git clone https://github.com/Gillan0/PetriNet.git
Open the project in your preferred IDE.
Add JUnit 5 to the build path to avoid errors.

#Running the Simulation

Navigate to the petrinet package in your IDE.
Create a main file to start the simulation.
Set petrinet, places, transitions, arcs, and tokens.
Edit the main class to modify values and rerun the file.

#Development

This project was developed by Antonino GILLARD and Othmane EL AKRABA as part of a university assignment. The source code is managed via Github.

#Technologies Used:

Java 23.0.1
JUnit 5


#Contribution

This project is closed for external contributions, but feel free to fork the repository for personal use. If you'd like to provide feedback, contact the developers directly.

#License
This project is developed for educational purposes and is not licensed for commercial use.
