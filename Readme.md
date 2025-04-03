# Magento Sign-Up and Sign-In Automation

## Overview
This project automates the **Magento sign-up and sign-in process** using **Selenium with Cucumber (BDD)**. The framework follows the **Page Object Model (POM)** for maintainability and scalability.

## Project Structure
```
WebAutomation_Assignment
├── .idea
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       │   ├── Runner
│       │   │   └── TestRunner.java
│       │   ├── StepDefinition
│       │   │   ├── SignupSigninSteps.java
│       └── resources
│           └── Feature
│               ├── 1signup.feature
│               ├── 2signin.feature
├── target
├── .gitignore
└── pom.xml
```

## Technologies Used
- **Java** (Programming language)
- **Selenium WebDriver** (Browser automation)
- **Cucumber (BDD)** (Behavior-driven testing)
- **Maven** (Build tool)
- **JUnit/TestNG** (Test execution framework)
- **Page Object Model (POM)** (Design pattern for maintainability)

## Features Implemented
- Automated **account creation** on Magento.
- Automated **sign-in** using the created credentials.
- **Dynamic data handling** for test reusability.
- **Error handling** and assertions for robustness.
- **BDD Cucumber scenarios** for better readability.

## Test Case Document
Test cases covering different scenarios of account creation and sign-in are documented in an Excel file:
- **Test Case Document:** https://docs.google.com/spreadsheets/d/17GYJ4xXZvnAE4daHoLfNJxw6K_YVVE0zIKcMJoqgj-k/edit?gid=957154655#gid=957154655

## Execution Steps
### Prerequisites
Ensure the following dependencies are installed:
1. **Java 11+**
2. **Maven**
3. **ChromeDriver** (or relevant WebDriver for the browser being tested)
4. **IDE** (e.g., IntelliJ IDEA, Eclipse)
5. **Git** (for version control)

### Running the Tests
1. Clone the repository:
   ```sh
   git clone https://github.com/Beardo-cs/WebAutomation-Assignment
   ```
2. Navigate to the project directory:
   ```sh
   cd WebAutomation_Assignment
   ```
3. Run tests using Maven:
   ```sh
   mvn clean test
   ```
4. Run tests using TestRunner:
   ```sh
   mvn test -Dcucumber.options="src/test/java/Runner/TestRunner.java"
   ```
5. Open the generated Cucumber report:
   ```sh
   open target/cucumber-reports.html
   ```

## GitHub Repository
The automation code is committed to GitHub with multiple commits for better traceability:
- **GitHub Repo:** https://github.com/Beardo-cs/WebAutomation-Assignment

## Proof of Execution
A screen recording of test execution is provided for reference:
- **Screen Recording:** https://drive.google.com/file/d/14DWnyCd-JcrjkgKYCiBQ5W5jJ38J2q7_/view?usp=sharing
