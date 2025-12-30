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

# AdvancedAutomation Selenium Script

## Overview

The `AdvancedAutomation.java` class demonstrates advanced Selenium WebDriver functionalities. It covers multiple browser automation scenarios, including dropdown selection, checkboxes, alerts, multiple windows, and explicit waits.

---

## Features Covered

1. **Dropdown Selection**

   * Website: [Dropdown Page](https://the-internet.herokuapp.com/dropdown)
   * Action: Selected "Option 2" using the `Select` class.

2. **Checkbox Handling**

   * Website: [Checkbox Page](https://the-internet.herokuapp.com/checkboxes)
   * Action: Selected the first checkbox if it was not already selected.

3. **Alert Handling**

   * Website: [JavaScript Alerts](https://the-internet.herokuapp.com/javascript_alerts)
   * Action: Clicked the alert button and accepted the alert.
   * Output: Printed the alert text to the console.

4. **Multiple Windows / Tabs**

   * Website: [Multiple Windows](https://the-internet.herokuapp.com/windows)
   * Action: Opened a new window/tab, switched focus, printed its title, and closed it.

5. **Explicit Wait**

   * Website: [Dynamic Loading](https://the-internet.herokuapp.com/dynamic_loading/1)
   * Action: Clicked the Start button and waited for the dynamically loaded text to appear, then printed it.

---

## Implementation Details

* **Implicit Wait:** Set for general element loading.
* **Explicit Wait:** Used for specific elements like alerts and dynamically loaded content.
* **Thread.sleep:** Added for demonstration purposes to pause between actions.
* **Driver Management:** Browser closes automatically at the end of the script.

---

## Console Output Example

```
Dropdown selected
Checkbox selected
Alert text: I am a JS Alert
New window title: New Window
Explicit wait text: Hello World!
AdvancedAutomation completed successfully
```

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

# AdvancedAutomationTest Selenium Test

## Overview

The `AdvancedAutomationTest.java` class is a **TestNG-integrated Selenium WebDriver test** that automates multiple advanced browser interactions. Unlike the earlier standalone `main()` version, this class uses TestNG annotations for structured test execution and reporting.

---

## Features Covered

1. **Dropdown Selection**

   * Website: [Dropdown Page](https://the-internet.herokuapp.com/dropdown)
   * Action: Selects "Option 2" from the dropdown menu using the `Select` class.

2. **Checkbox Handling**

   * Website: [Checkbox Page](https://the-internet.herokuapp.com/checkboxes)
   * Action: Checks the first checkbox if it is not already selected.

3. **Alert Handling**

   * Website: [JavaScript Alerts](https://the-internet.herokuapp.com/javascript_alerts)
   * Action: Clicks the alert button, waits for the alert to appear, prints its text, and accepts it.

4. **Multiple Windows / Tabs**

   * Website: [Multiple Windows](https://the-internet.herokuapp.com/windows)
   * Action: Opens a new window, switches to it, prints its title, closes it, and switches back to the main window.

5. **Explicit Wait (Dynamic Loading)**

   * Website: [Dynamic Loading](https://the-internet.herokuapp.com/dynamic_loading/1)
   * Action: Clicks the Start button and waits explicitly for the dynamically loaded text to appear, then prints it.

---

## TestNG Integration

* **@BeforeMethod** – Initializes the Chrome browser, maximizes the window, and sets implicit and explicit waits.
* **@Test** – Runs all automation steps in sequence.
* **@AfterMethod** – Closes the browser after the test completes.

> This setup ensures each test starts with a fresh browser instance and ends cleanly.

---

## Console Output Example

```
Dropdown selected
Checkbox selected
Alert text: I am a JS Alert
New window title: New Window
Explicit wait text: Hello World!
AdvancedAutomation TestNG completed successfully
```

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

```

# Jenkins Setup & Running Selenium Tests

This section explains how to install Jenkins, set it up, create a job for your Selenium project, run builds, and view output. Both Linux and Windows instructions are included.

---

## 1. Installing Jenkins

### Linux (e.g., Arch, Ubuntu)

1. Install Jenkins:

```bash
sudo pacman -S jenkins
```

Or, on Ubuntu/Debian:

```bash
sudo apt update
sudo apt install openjdk-17-jdk maven git jenkins
```

2. Start Jenkins service:

```bash
sudo systemctl start jenkins
sudo systemctl enable jenkins
```

### Windows

1. Download Jenkins installer from [https://www.jenkins.io/download/](https://www.jenkins.io/download/).
2. Run the installer and follow instructions.
3. Jenkins will install as a Windows service.

---

## 2. Accessing Jenkins Dashboard

1. Open a browser.
2. Navigate to:

```
http://localhost:8080
```

3. On first launch, Jenkins asks for **initial admin password**:

* Linux: `sudo cat /var/lib/jenkins/secrets/initialAdminPassword`
* Windows: Find `initialAdminPassword` in Jenkins installation folder (`C:\Program Files (x86)\Jenkins\secrets\initialAdminPassword`)

4. Copy the password and complete the setup wizard.
5. Create your first admin user (username, password, email).

---

## 3. Creating a New Job

1. On Jenkins Dashboard, click **New Item**.
2. Enter a name, e.g., `Selenium-Automation`.
3. Select **Freestyle project** and click **OK**.

---

## 4. Linking Git Repository

1. Under **Source Code Management**, select **Git**.
2. Enter your project URL:

```
https://github.com/user-name/automation-testing.git
```

3. If the repository is private, provide credentials (username + token or SSH key).

---

## 5. Configuring Build

### Linux

1. Scroll to **Build** section.
2. Click **Add build step → Execute shell**.
3. Enter:

```bash
cd SeleniumAutomation
mvn clean test -Dheadless=true
```

### Windows

1. Scroll to **Build** section.
2. Click **Add build step → Execute Windows batch command**.
3. Enter:

```powershell
cd SeleniumAutomation
mvn clean test -Dheadless=true
```

**Explanation:**

* `-Dheadless=true` makes Chrome run without opening a GUI. Required on servers without display.
* Remove it if you want to see the browser opening locally.

---

## 6. Running the Build

1. Save the job configuration.
2. Click **Build Now** on the job page.
3. Jenkins will:

   * Clone the repository
   * Run Maven `clean test`
   * Execute all Selenium tests

---

## 7. Viewing Build Output

1. Click on the build number (e.g., `#1`) in **Build History**.
2. Click **Console Output** to see logs:

   * Selenium actions
   * Test pass/fail messages
3. Maven test reports are available at:

```
SeleniumAutomation/target/surefire-reports/
```

* `.txt` or `.xml` files contain detailed results.
* Passed and failed tests are listed.

---

## 8. Headless vs Non-Headless Mode

* **Headless mode**: Chrome runs without opening a window. Mandatory for Jenkins servers (Linux) or when no GUI is available. Faster and more stable.
* **Non-headless mode**: Chrome window opens. Useful for debugging locally to see exactly what tests do.

**Sample ChromeOptions in tests:**

```java
ChromeOptions options = new ChromeOptions();

if ("true".equals(System.getProperty("headless"))) {
    options.addArguments("--headless=new");
}

options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
options.addArguments("--disable-gpu");
options.addArguments("--window-size=1920,1080");
options.addArguments("--remote-allow-origins=*");

WebDriver driver = new ChromeDriver(options);
```

---

## 9. Notes and Tips

* Ensure ChromeDriver version matches Chrome browser version.
* Always set `--headless=new` for Jenkins server to avoid “Chrome instance exited” errors.
* Locally, you can remove `--headless=new` to watch browser execution.
* Jenkins automatically provides logs and console output for debugging.

---
