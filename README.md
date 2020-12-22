# Tronium Test Automation Framework  - Web
This is a Cucumber-Java Project. Followed BDD approach

# Getting Started
 First you need to clone the 'master' branch of this project into your local machine. After that you can open configuration.properties file and set your desired browser for testing.
 
 # Prerequisites

Supported Browsers : Chrome, Firefox, Internet Explorer(IE), Microsoft Edge (EdgeHTML), Safari

Make sure that you have already:
* Installed the browser you want to execute in your local machine. 
* Check your browser version and driver compatibility  `/src/test/resources/driver`

Notes : 
- "Enhanced Protected Mode" must be disabled for IE 10 and higher.
- Firefox driver - https://github.com/mozilla/geckodriver/releases
- Chrome driver - https://chromedriver.chromium.org/downloads

## Open the ProjectT

You can open the project by any IDE (Select `pom.xml` file when opening the project)

# Edit existing Test suite

You can find the available test suites in `/src/test/resources/test_suite`

You can change the Platform, Browser name and Browser version according to your local machine.

Notes:
* Platform should be `linux` , `windows` or `mac`.
* Browser name should be `chrome` , `firefox`, `edge`, `ie` or `safari`.

# Running the Test Suite via XML file

Goto SmokeTest.xml and configure your browser details and start Run.

# Running the Test Suite via CLI
  
 Make sure that you successfully import all the maven dependencies. After that run the following command to start the execution,

  mvn clean install -P<suite_name>
  
  To run scenarios in parallel,
  
    mvn clean install -PSmokeTest
    
  To run scenarios in cross browser
  
    mvn clean install -PSmokeTest_Parallel
  
# Enable Selenium grid

Set Up the selenium grid and change the Selenium grid URL in the configuration.properties file. Also Turn On the grid-mode. Then run your distributed test suite.

    mvn clean install -PSmokeTest_Distributed

# View Allure report

## In Windows

First, you need to download allure from https://github.com/allure-framework/allure2/releases

Then add the bin folder location into your PATH variable.Once you run your test suite, 'allure-results' directory will create inside target directory. Copy the path of it. Then open the command prompt. Run the following command,

``
allure serve <location to your allure-results directory>
``

## In Ubuntu

````
curl -o allure-2.6.0.tgz -Ls https://dl.bintray.com/qameta/generic/io/qameta/allure/allure/2.6.0/allure-2.6.0.tgz   
sudo tar -zxvf allure-2.6.0.tgz -C /opt/   
sudo ln -s /opt/allure-2.6.0/bin/allure /usr/bin/allure  
allure --version 
````

Once you run your test suite, 'allure-results' directory will create inside target directory. Copy the path of it. Then open the command prompt. Run the following command,

``
allure serve <location to your allure-results directory>
``
  
