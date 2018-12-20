# Tronium Test Automation Framework  - Web
This is a Cucumber-Java Project. Followed BDD approach

# Getting Started
 First you need to clone the 'master' branch of this project into your local machine. After that you can open configuration.properties file and set your desired browser for testing.
 
# Run individual Test Scenario

Goto Feature file and right mouse click on the scenario which you want to run.

# Running the Test Suite
In the terminal window type following command,
  
  mvn clean install
  
 Make sure that you successfully import all the maven dependencies. After that run the following command to start the execution,

  mvn clean -P<suite_name>
  
 e.g:  mvn clean -PSmokeTest
  
# Edit existing Test suite

You can change the Platform, Browser name and Browser version according to your local machine.

# Enable Selenium grid

Set Up the selenium grid and change the Selenium grid URL in the configuration.properties file. Then run your distributed test suite.
  
  
