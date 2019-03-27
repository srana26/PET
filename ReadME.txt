Introduction:-

-	This is a maven arch type project build for API automation testing.
-	This is build using the BDD approach.
-	Implemented using Cucumber, Rest-Assured, Java and Serenity for reports.
-	This includes api’s smoke test for CRUD operations of https://petstore.swagger.io/v2/pet

GITHUB address:-

https://github.com/srana26/PET.git

Steps for Execution:-

1. Since it follows BDD the individual features or scenarios can be run from any IDE’s where cucumber for java plugin is enabled and all project dependencies are installed (mvn install).
2. To run the tests from terminal, navigate to the location in project structure where pom.xml is available and type
 >mvn clean verify –Dcucumber.options=”—tags @Smoketest”
3.	After completion the reports will be available in:
\target\site\serenity\index.html

