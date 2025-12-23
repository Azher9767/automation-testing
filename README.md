# Automation Testing Assignment

This repository contains a Java-based Selenium automation project created as part of an academic assignment.  
The project is developed step by step, strictly following the assignment instructions.

---

## A: Java Setup

### Linux

1. **Install OpenJDK** (latest version)

```bash
sudo pacman -Syu
sudo pacman -S jdk-openjdk
````

2. **Verify installation**

```bash
java -version
javac -version
```

Expected output example:

```
openjdk version "25.0.1" 2025-10-21
OpenJDK Runtime Environment (build 25.0.1)
OpenJDK 64-Bit Server VM (build 25.0.1, mixed mode)
```

3. **Set JAVA_HOME and update PATH**

* Open your profile in VS Code:

```bash
code ~/.profile
```

* Add these lines at the end:

```bash
export JAVA_HOME=/usr/lib/jvm/java-25-openjdk
export PATH=$JAVA_HOME/bin:$PATH
```

* Save and close VS Code, then reload terminal:

```bash
source ~/.profile
```

4. **Verify JAVA_HOME**

```bash
echo $JAVA_HOME
```

Expected:

```
/usr/lib/jvm/java-25-openjdk
```

---

### Windows

1. **Install JDK**

* Download latest JDK from [Oracle](https://www.oracle.com/java/technologies/downloads/) or OpenJDK.
* Install in default location, e.g.:

```
C:\Program Files\Java\jdk-25
```

2. **Set Environment Variables**

* Open **This PC → Properties → Advanced system settings → Environment Variables**
* Add new **System Variable**:

```
Name: JAVA_HOME
Value: C:\Program Files\Java\jdk-25
```

* Edit `Path` variable → Add:

```
%JAVA_HOME%\bin
```

3. **Verify installation**

Open Command Prompt and run:

```cmd
java -version
javac -version
```

Expected output example:

```
openjdk version "25.0.1" 2025-10-21
OpenJDK Runtime Environment (build 25.0.1)
OpenJDK 64-Bit Server VM (build 25.0.1)
```

---

## Current Status

* Java environment configured successfully
* JAVA_HOME set correctly
* Initial **HelloWorld.java** program created and executed successfully
* Project folder structure ready for Maven + Selenium integration

---

### Project Folder Structure

```
automation-testing/        ← Git repository
 ├── README.md             ← Setup instructions
 └── SeleniumAutomation/   ← Java project folder
     └── src/
         └── HelloWorld.java
```

``


## B: Selenium Automation Project

This project demonstrates setting up a Java environment for Selenium WebDriver, writing basic Selenium scripts, and running them using Maven. It follows the standard Maven directory structure.

## Prerequisites

- Java JDK (version 25 used here, assignment suggests 17)
- Maven
- Google Chrome Browser
- ChromeDriver

---

## Linux Setup

1. **Install Java (OpenJDK)**

```bash
sudo pacman -S jdk-openjdk
java -version
javac -version
````

* Ensure JAVA_HOME is set:

```bash
export JAVA_HOME=/usr/lib/jvm/java-25-openjdk
export PATH=$PATH:$JAVA_HOME/bin
```

2. **Install Maven**

```bash
sudo pacman -S maven
mvn -version
```

3. **Install Google Chrome and ChromeDriver**

```bash
sudo pacman -S chromium chromedriver
```

* Add ChromeDriver to PATH if necessary:

```bash
export PATH=$PATH:/usr/bin
```

4. **Project Structure**

```
SeleniumAutomation/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── automation/
                    └── BasicAutomation.java
```

5. **Compile and Run Basic Automation Script**

From the project root (where `pom.xml` is):

```bash
mvn compile exec:java -Dexec.mainClass="com.automation.BasicAutomation"
```

* Expected behavior: Chrome opens Wikipedia, prints page title in terminal, then closes automatically.

---

## Windows Setup

1. **Install Java JDK 17 (or 25)**

* Download from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [Adoptium](https://adoptium.net/).
* Set `JAVA_HOME` and update PATH:

```powershell
setx JAVA_HOME "C:\Program Files\Java\jdk-25"
setx PATH "%PATH%;%JAVA_HOME%\bin"
```

* Verify installation:

```powershell
java -version
javac -version
```

2. **Install Maven**

* Download from [Maven official site](https://maven.apache.org/download.cgi).
* Extract and set `MAVEN_HOME` and update PATH:

```powershell
setx MAVEN_HOME "C:\apache-maven-3.9.11"
setx PATH "%PATH%;%MAVEN_HOME%\bin"
```

* Verify:

```powershell
mvn -version
```

3. **Install Chrome and ChromeDriver**

* Download ChromeDriver that matches your Chrome version: [https://chromedriver.chromium.org/downloads](https://chromedriver.chromium.org/downloads)
* Add the folder containing `chromedriver.exe` to your PATH.

4. **Run the Basic Automation Script**

From the project root (where `pom.xml` is):

```powershell
mvn compile exec:java -Dexec.mainClass="com.automation.BasicAutomation"
```

* Browser opens, Wikipedia loads, page title prints in console, browser closes automatically.

---

## C: TestNG Integration and Automated Tests

After successfully running a single Selenium automation class using Maven, the next step in the assignment is to integrate **TestNG** and execute automated test cases.

### Objective

* Configure TestNG with Maven
* Create automated Selenium test cases
* Execute tests using `mvn test`

---

### TestNG Dependency Configuration

TestNG is added as a test dependency in `pom.xml`:

```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.7.1</version>
    <scope>test</scope>
</dependency>
```

The Maven Surefire plugin is configured to run TestNG using `testng.xml`.

---

### TestNG Configuration File

A `testng.xml` file is created at the project root:

```
SeleniumAutomation/testng.xml
```

This file controls which test classes are executed during the test phase.

---

### Test Classes Structure

TestNG test classes are placed under the standard Maven test directory:

```
src/test/java/com/automation/
```

Current test classes:

* `BasicAutomationTest.java`
  → Verifies that TestNG setup is working correctly

* `WikipediaSearchTest.java`
  → Automates a search operation on Wikipedia and validates the page title

---

### Running TestNG Tests

From the project root (`SeleniumAutomation`):

```bash
mvn test
```

Expected behavior:

* TestNG test suite executes successfully
* Browser launches for Selenium tests
* Test results are displayed in the console
* Build completes with **BUILD SUCCESS**

---

### Notes

* The `target/` directory is generated automatically by Maven during test execution
* `target/` is excluded using `.gitignore` and should not be committed
* ChromeDriver version warnings may appear if browser versions differ, but tests still execute successfully


### Data-Driven Testing with TestNG

This project includes a data-driven Selenium test using TestNG's `@DataProvider`.

Test data is stored in an Excel file:

```
src/test/resources/TestData.xlsx

```

Each row in the Excel sheet is read using Apache POI and executed as a separate test case.

### Run Tests

From the `SeleniumAutomation` directory:

```bash
mvn test
````

Expected result:

* Browser opens for each search term
* Wikipedia search is performed
* Tests pass for all rows in the Excel file
