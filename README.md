# Tronium Test Automation Framework  - Web
This is a Cucumber-Java Project. Followed BDD approach

# Getting Started
 First you need to clone the 'master' branch of this project into your local machine. After that you can open configuration.properties file and set your desired browser for testing.
 
 # Prerequisites
 You have to install Firefox borwser and Chrome browser in your machine. And also change the test plan parameters as needed.
 
# Run individual Test Scenario

Goto Feature file and right mouse click on the scenario which you want to run.

# Running the Test Suite
  
 Make sure that you successfully import all the maven dependencies. After that run the following command to start the execution,

  mvn clean install -P<suite_name>
  
  To run scenarios in parallel,
  
    mvn clean install -PSmokeTest
    
  To run scenarios in cross browser
  
    mvn clean install -PSmokeTest_Parallel
  
# Edit existing Test suite

You can change the Platform, Browser name and Browser version according to your local machine.

# Enable Selenium grid

Set Up the selenium grid and change the Selenium grid URL in the configuration.properties file. Also Turn On the grid-mode. Then run your distributed test suite.

    mvn clean install -PSmokeTest_Distributed
  
# View Allure report 

First you need to download allure from https://github.com/allure-framework/allure2/releases

Then add the bin folder location into your PATH variable.Once you run your test suite, 'allure-results' directory will create inside target directory. Copy the path of it. Then open the command prompt. Run following command,

      allure serve <location to your allure-results directory>
  
