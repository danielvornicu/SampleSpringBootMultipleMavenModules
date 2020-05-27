Spring BOOT(Multiple Maven Modules version) with Spring MVC and REST(API and test client)

Build the project with Maven:
Navigate to project folder and build the project as;
SampleSpringBootMultipleMavenModules>mvn clean install - clean, builds the maven project and installs the project files (JAR, WAR, pom.xml, etc) to the local repository
SSBMMM>mvn package - builds the maven project and packages them into a JAR, WAR

Run the .war:
SampleSpringBootMultipleMavenModules>cd web
With Java command(same Java version betweend compilateur and runtime(ex: 1.8))
SSBMMM/web>java -jar target/SampleSpringBootMultipleMavenModules.war - run the .war file
or
With Maven Spring Boot Plugin:
SSBMMM/web>mvn spring-boot:run  - Run an application using Spring Boot Plugin Goal

Spring Boot Run Configuration(IntelliJ):
In IntelliJ you CAN NOT put provided scope under tomcat-embed-jasper dependency:
Solution: set the working directory to $MODULE_DIR$ in the run configuration


Spring MVC:
http://localhost:8090/client
http://localhost:8090/client/new
http://localhost:8090/client/1  - consult
http://localhost:8090/client/1/edit
http://localhost:8090/client/1/delete

REST Api:
http://localhost:8090/clients           HTTP GET   - all clients
http://localhost:8090/clients/new       HTTP GET   - show creation window
http://localhost:8090/clients/new       HTTP POST  - save created client
http://localhost:8090/clients/1         HTTP GET   - consult single client
http://localhost:8090/clients/1/edit    HTTP GET   - show modification window
http://localhost:8090/clients/1/edit    HTTP POST  - save modificated client
http://localhost:8090/clients/1/delete  HTTP GET   - delete selected client and show the remaining list of clients

A simple client for REST api:
http://localhost:8090/rsclient
http://localhost:8090/rsclient/new
http://localhost:8090/rsclient/1              - consult
http://localhost:8090/rsclient/1/edit
http://localhost:8090/rsclient/1/delete

If we call the REST API from Angular add this annotation to Rest Controller:
@CrossOrigin(origins = "http://localhost:4200")

http://localhost:8090/h2-console
JDBC URL: jdbc:h2:file:./clients.db
User Name: sa
Pasword: <leave this empty>

Git:
>git init
>git add entities/src/main/*
>git add entities/pom.xml
>git add service/src/main/*
>git add service/pom.xml
>git add web/src/main/*
>git add web/pom.xml
>echo '.idea' >> .gitignore
git add pom.xml
git add readme.txt
git commit -m "first commit"

Connect it to github ad create a new repository: SampleSpringBootMultipleMavenModules
git remote add origin https://github.com/danielvornicu/SampleSpringBootMultipleMavenModules.git
git push -u origin master

