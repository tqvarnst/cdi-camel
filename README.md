Camel CDI Integration
========================

What is it?
-----------

This is a sample project for Apache Camel and CDI Integration JBoss EAP 6. 

System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better and JBoss Enterprise Application Platform 6


Configure Maven
---------------

Configure your settings.xml with the example in example-settings.xml or build with  "-s example-settings.xml"


Start JBoss Enterprise Application Platform 6 
-------------------------

1. Open a command line and navigate to the root of the JBoss server directory.
2. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat


Build and Deploy the application
-------------------------

1. Make sure you have started the JBoss Server as described above.
2. Create the directory structure for copying files:
	
	$ mkdir -p /tmp/data/inbox
	$ mkdir -p /tmp/data/outbox
	
3. Open a command line and navigate to the root directory of this project.
4. Type this command to build and deploy the archive:

        mvn clean package jboss-as:deploy
        
alternatively if you haven't configured the settings.xml
	
	mvn -s example-settings.xml clean package jboss-as:deploy

5. This will deploy `target/cdi-camel.war` to the running instance of the server and start the project
6. Drop a file in /tmp/data/inbox. For example:

	$ echo "Some test content" > /tmp/data/inbox
	
7. Wait 1 sec and then verify that the file has been moved to outbox dir
	$ ls -R /tmp/data
	 




Undeploy the Archive
--------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

        mvn jboss-as:undeploy


Run the Arquillian tests
----------------------------

TODO

Run the Example in JBoss Developer Studio or Eclipse
-------------------------------------
You can also start the server and deploy the quickstarts from Eclipse using JBoss tools. For more information, see [Use JBoss Developer Studio or Eclipse to Run the Quickstarts](../README.html/#useeclipse) 


Debug the Application
------------------------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following commands to pull them into your local repository. The IDE should then detect them.

        mvn dependency:sources
        mvn dependency:resolve -Dclassifier=javadoc

