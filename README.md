# Project Code - Republic-REST_074.
## Project Type - Web Application Automation Tesing with Selenium.
## Framework details - Page object model.
## Scop
1. Visit the web application https://tutorialsninja.com/demo/ :
   
![image](https://github.com/user-attachments/assets/1dc34de1-0fd3-4cd4-9b0e-c78797e2f903)
2. Navigate to register page :
   
![image](https://github.com/user-attachments/assets/ab420571-4a88-440f-b586-6bb9f8d876c6)
3. Fill up the form :

![image](https://github.com/user-attachments/assets/85f31e11-3041-4a22-b969-67518a62e134)
4. Register yourself :

![image](https://github.com/user-attachments/assets/4a4d7cbc-f933-44b5-af4b-08091620a26c)
5. Navigate to Home page :

![image](https://github.com/user-attachments/assets/abbf4832-e795-44c0-a979-626346df9e58)
6. Search any existing product name :

![image](https://github.com/user-attachments/assets/1cd57cbc-43d9-4d03-912b-57e7afbbb627)
7. Search non existing product name :

![image](https://github.com/user-attachments/assets/dfc3c226-8675-4915-8b21-bb3e1505edb7)
8. Don't enter anything into the 'Search' text box field and click on search button :

![image](https://github.com/user-attachments/assets/0545c4be-9436-4bf0-b36e-9c400ac61176)
9. Enter criteria in the 'Search' text box field which can result in mutliple products :

![image](https://github.com/user-attachments/assets/53e5094a-3e1f-45cb-91c9-fc3e7c7d531a)
10. Logout from the Application :

![image](https://github.com/user-attachments/assets/10dffb35-9e13-4f09-9782-d130c11d3105)
## Project Structure & Code Structure
I use Maven Project with Page object model framework and Java for writting script

Here are the reference links for how to setup your project - 
### 1. Download IDE [SprinTool](https://spring.io/tools) or [Eclipse](https://www.eclipse.org/downloads/)
### 2. Create a [Maven Projrct](https://medium.com/@leninstalinesec/benefits-of-maven-for-java-developers-8083f9d33665#:~:text=Maven%20project%20enforces%20a%20standard,src%2Fmain%2Ftest%20folder.).
### 3. Add requered [Maven dependencies](https://mvnrepository.com/) in to your  ```pom.xml``` file.

Example : For this project I use [testng](https://mvnrepository.com/artifact/org.testng/testng/7.7.1), [selenium-java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.22.0), [webdrivermanager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.8.0), [extentreports](https://mvnrepository.com/artifact/com.aventstack/extentreports/5.0.9) and Maven compiler plugin for command line execution.

![image](https://github.com/user-attachments/assets/a0f2829e-6754-497e-82e5-1d9bea0a891f)

## My Project Structure
### In ```src/main/java``` contains all my Page object classes where I mentions all the steps or tasks that mentioned in the requerment.

![image](https://github.com/user-attachments/assets/624f35a0-4234-4eb4-bbe4-7b87377b4bd5)
![image](https://github.com/user-attachments/assets/1a0d7977-ea22-449f-b370-ccebf26c4414)

![image](https://github.com/user-attachments/assets/29da4d28-6776-4ae9-8763-4ec7e150edfd)

![image](https://github.com/user-attachments/assets/2d22ffab-5533-448d-91a9-7a51a702d6c7)
### In ```src/test/java``` contains my test methods.

![image](https://github.com/user-attachments/assets/2f5683d2-1cd7-4424-a87e-3224e162ee24)
### In ```Base_test.java``` contains BeforeTest method and AfterTest method. I setup my browser and setup other plugins and close the browser.

![image](https://github.com/user-attachments/assets/a3f6e7f6-a1ce-43e5-86fe-eb2c2d67beb2)

### In ```/ExtentReport/``` contain test result in html format.

![image](https://github.com/user-attachments/assets/89fb700b-0be0-4384-9d2c-845b9b290db9)


## Getting started
1. Install [git](https://www.git-scm.com/) , [node.js](https://nodejs.org/en) & [Maven](https://maven.apache.org/download.cgi) in your system.
2. Open your terminal
Paste this command
```bash
git clone https://github.com/janasagar/Republic-REST_074.git
```
3. Open this project in your IDE
4. Oepn your terminal in your IDE and run this commad ```mvn test```


Thanks:)





