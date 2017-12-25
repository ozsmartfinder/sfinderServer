# sfinderServer
back-end TCP/UDP server for sfinder Project; 3G,5G Compatible, not for Lora.


# File Structures
1. the "src" folder contains the source code of the project.
2. the pom.xml file is the maven xml to download all the dependencies including Postgresql JDBC and Hibernate.
3. the hibernate.cgf.xml file is the hibernate-to-postgresql mapping file.

# To do
--> now only TCP is done, while UDP is to be done for future 5G communication

# Design pattern
1.  All components are written in com.* packages.
2.  for gps datum processing, as there are many different protocols, so that a simple factory design pattern is given for easier future insertion of other protocols.
