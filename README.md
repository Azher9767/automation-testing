# Automation Testing Assignment

This repository contains a Java-based Selenium automation project created as part of an academic assignment.  
The project is developed step by step, strictly following the assignment instructions.

---

## Java Setup

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

```

