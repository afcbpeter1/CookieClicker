Cucumber-Selenium Project
This repository contains a sample project demonstrating how to use Cucumber with Selenium WebDriver for automated testing of a web application.

Prerequisites
Before running the tests, ensure you have the following installed:

Java Development Kit (JDK) version 11 or higher
IntelliJ IDEA (or any preferred Java IDE)
Maven
Setup Instructions
Follow these steps to set up the project:

Clone the repository
https://github.com/afcbpeter1/saucelabs.git

bash
Copy code
git clone https://github.com/afcbpeter1/saucelabs.git
Import the project into IntelliJ IDEA

Open IntelliJ IDEA.
Choose File > Open and navigate to the root of the cloned project.
Select the pom.xml file and click Open to import the project.
Install Dependencies

Maven will automatically download the necessary dependencies (Cucumber, Selenium, etc.) based on the configurations in the pom.xml file. If you encounter issues with dependencies, ensure your pom.xml is correctly configured and then run:

Copy code
mvn clean install
Running Tests
To run the Cucumber tests:

Configure the Cucumber Run Configuration

Click on the dropdown menu next to the green play button at the top right of IntelliJ IDEA.
Select Edit Configurations.
Click the + button in the top left corner and choose Cucumber Java.
Set the following fields:
Name: Enter a name for your configuration (e.g., Run Cucumber Tests).
Glue: Specify the package where your step definitions are located (e.g., stepdefinitions).
Feature or folder path: Specify the path to your feature files (e.g., src/test/java/feature).
Save your configuration.
Run the Cucumber Tests

Click on the green play button next to the dropdown menu and select the configuration you just created (Run Cucumber Tests).

Alternatively, you can run the tests directly from the terminal using Maven:

bash
Copy code
mvn test
View Test Results

After running the tests, IntelliJ IDEA will display the test results in the Run window.
You can view detailed reports and logs directly in IntelliJ IDEA for debugging purposes.
Troubleshooting
Null Pointer Exceptions: If you encounter NullPointerExceptions related to WebDriver, ensure that your WebDriver instance is properly initialized and managed in the Hooks class (runners.Hooks).
Dependency Issues: Double-check your pom.xml file to ensure all necessary dependencies are included and properly configured.
Additional Notes
Customize the project as needed for your specific application and testing requirements.
Refer to the Cucumber documentation and Selenium documentation for more advanced configurations and features.


