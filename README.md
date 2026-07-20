#StasTestTask_Saucedemo_Java_Selenium_TestNG

# UI Automation Testing Framework for Saucedemo

This is a professional, scalable, and robust UI test automation framework designed for the [Saucedemo](https://saucedemo.com) website. Built using Java 21 and modern automation practices, the framework is optimized for speed, stability, and clean architecture.

## 🛠️ Tech Stack

*   **Language:** Java 21 
*   **Automation Tool:** Selenium WebDriver (v4.46.0) with native **Selenium Manager** (no third-party driver managers required)
*   **Test Runner:** TestNG (v7.11.0)
*   **Build Tool:** Maven
*   **Reporting:** Allure Report with AspectJ Weaver for detailed step-by-step test tracking
*   **Logging:** SLF4J (Simple logger implementation)

## 🏗️ Architecture & Design Patterns

*   **Three-Layer Page Object Model (POM):**
    *   `BaseModel` handles core Selenium interactions (explicit waits, element interactions).
    *   `BasePage` manages application-wide components (navigation header, footer, generic modals).
    *   Individual Page classes (e.g., `LoginPage`) contain specific locators and atomic action blocks.
*   **Fluent / Chain API:** Page methods return `this` or the next page object, enabling highly readable, chainable test steps.
*   **ThreadLocal WebDriver Wrapper:** The framework is completely thread-safe and fully prepared for concurrent test execution without session cross-contamination.
*   **Data vs. Configuration Separation:** Environment settings reside in `.properties` files, while application-specific verification strings and credentials are isolated in Java Data classes.

## ⚙️ Configuration

The framework utilizes a prioritized configuration mechanism (`Console Arguments` > `Properties File` > `Hardcoded Defaults`).

Key configurations can be easily modified in `src/test/resources/config.properties`:
*   `browser` (chrome, firefox, edge)
*   `headless` (true/false)
*   `window.size` (maximize or specific dimensions like 1920x1080)
*   `base.url` (target environment URL)

## 🚀 Getting Started

### Prerequisites
Make sure you have **Maven** and **Java 21+** installed on your system.

### Running Tests
To execute the tests using the default configuration (Chrome, Headed mode):
```bash
mvn test
```

To dynamically override the browser via command line arguments:
```bash
mvn test -Dbrowser=firefox
```

### Generating Allure Reports
Since the framework is configured to dump raw test metadata securely into the `target/allure-results` directory, use the following commands to compile and view the visual dashboard:

1. Generate the static HTML report:
```bash
mvn allure:report
```

2. Serve the generated report on a local web server to view it in your browser:
```bash
allure open target/site/allure-report
```
