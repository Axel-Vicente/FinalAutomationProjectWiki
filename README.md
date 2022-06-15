# MONSTER WIKI TESTING - Automated Testing ![Version](https://img.shields.io/badge/Version-1.0.1-gray?style=plastic&logo=DataVersionControl&logoColor=black&labelColor=success)
## Table of Contents
* [Introduction](#introduction)
* [Execution](#execution)
* [Structure](#structure)
* [functionality](#functionality)
* [Test Cases](#test-cases)
***
This project deals with the automation of regression testing of Monster Wiki.
***
<a name="introduction" id="introduction"></a>
## 📖What is regression testing? 

Regression testing helps to confirm that a recent configuration update or new deployment won’t adversely affect existing functionality, processes, and workflows of a system before it’s released.
<br />
<p align="center">
  <img src="https://i.imgur.com/eIw1Ag7.png">
</p>

***
<a id="execution" name="execution"></a>
## ⚡Execution of the application/component

The project is a standard maven project. To run it from the command line,
type the next command:

Open the terminal and go to the root of project. These are the different ways to launch a test:

- Basis for launching the test: <br />
  ```$ mvn clean antrun:run@envtask test -Dtest=package/nameTest ```
- Launching the test with a specific environment: <br />
  ```$ mvn clean antrun:run@envtask test -Dtest=package/nameTest -Denv=environment```
- Launching the test with a specific environment and a specific test: <br />
  ```$ mvn clean antrun:run@envtask test -Dtest=package/nameTest -Denv=environment```
- Launching the test with a specific environment, specific test and a specific browser: <br />
  ```$ mvn clean antrun:run@envtask test -Dtest=package/nameTest -Denv=environment -Dbrowser=browser```
- Launching the test without opening a browser: <br />
  ```$ mvn clean antrun:run@envtask test -Dtest=package/nameTest -Dheadless```
- Launching of the test locally: <br />
  ```$ mvn clean antrun:run@envtask test -Dtest=package/nameTest -Dbrowser=browser -Dlocal```

On the other hand, we can launch the tests directly from the testng.xml where we will have the test packages pointed. In the same way we open a terminal and go to the root of the project.
<br />
These are the different ways to launch a test with testng:

- Basis for launching the testng.xml: <br />
  ```$ mvn clean antrun:run@envtask test -DsuiteXmlFile=testng.xml```
- Launching the test with a specific environment, specific test and a specific browser: <br />
  ```$ mvn clean antrun:run@envtask test -DsuiteXmlFile=testng.xml -Dbrowser=browser```
- Launching the test without opening a browser: <br />
  ```$ mvn clean antrun:run@envtask test -DsuiteXmlFile=testng.xml -Dheadless```
- Launching of the test locally: <br />
  ```$ mvn clean antrun:run@envtask test -DsuiteXmlFile=testng.xml -Dbrowser=browser -Dlocal```
> **Note:** The testng.xml file is located in the test folder.

***
<a id="structure" name="structure"></a>
## 🗃️Project Structure

- [`resources`](/src/test/resources) **_folder:_** `/src/test/resources` Contains the implementation of the tests and the data files to be used.
- [`cucumber steps`](src/test/java/com/monster/wiki/test/stepdef) **_package:_** `com.monster.wiki.test.steps` Contains the steps _(Gherkin steps)_ of the test scenarios.
- [`cucumber runner`](src/test/java/com/monster/wiki/test/runners) **_package:_** `com.monster.wiki.test.runner` Contains instructions on how to run the cucumber tool.
- [`pageObjects`](src/main/java/com/monster/wiki/pageobjects) **_package:_** `com.monster.wiki.pageobjects` Contains the methods for the various automations in the application.
- [`utils`](src/main/java/com/monster/wiki/utils) **_package:_** `com.monster.wiki.utils` Contains the methods for the various automations in the application.

***
<a id="functionality" name="functionality"></a>
## ⚙️New functionalities

`# 2022-04-13 #`

- `✔️Implementation of the cucumber tool`
- `✔️README.md file`

***
<a id="test-cases" name="test-cases"></a>
## 🟢Tests
### List of tests by feature:

[`# Routing #`](src/test/resources/features/routing.feature)
---
- `FTN001_v1.0.0`

[`# SearchEngine #`](src/test/resources/features/searchEngine.feature)
---
- `FTN002_v1.0.0`
- `FTN003_v1.0.1`

[`# HomePage #`](src/test/resources/features/home.feature)
---
- `FTN004_v1.0.1`