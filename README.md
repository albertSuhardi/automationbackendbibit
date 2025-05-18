Visual Code : 
- Choose View then Command Pallete in Visual Studio or type Command Pallete in Search bar VS Code
- Choose Java:Create Java Project...
- Choose Maven 
- Choose Maven Quickstart

in Pom xml, copy past or import this library that can you get from here "link"
in test/java/com/bibit make 3 directory 
base  : for store/save base or abstract class that reused multiple times when creating test case
utils : store helper class or method in reusable task
tests : stored actual test cases that user created


type "mvn clean -Dtest=com.bibit.tests.BibitTestSuite test" in terminal, code will running
go to target ExtentReport.html for detail report