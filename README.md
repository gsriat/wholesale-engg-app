# wholesale-engg-app
ANZ Wholesale Engineering Sample Project - Backend

## Description

This application is a backend application with REST endpoints to provide 
information about customer accounts and transactions.

## Supported endpoints
http://localhost:8081/api/account/getaccounts?customerId=1000
http://localhost:8081/api/transaction/gettransactions?accountId=5000

## Data
For this application to test, an in-memory database HSQLDB is used. Database schema and records are created with data.sql 
in the resources folder. Records for customerId 1000 and accountId 5000 are created. More records can be added by editing resources/data.sql

Also, In-Memory database can be pointed to a disk memory database by changing spring.datasource properties in resources/application.yml

## Profiles
Multiple profiles can be configured by adding application-dev.yml, application-uat.yml and application-prod.yml

## How to run
* Please install Lombok plugin in your IDE (IDEA/Eclipse)
    * IDEA: Open the Settings panel. Search for "Plugins", then search for "Lombok" in the plugins. Find the plugin and install it. Restart your IDEA.
    * Eclipse: run lombok/lombok.jar provided in the source.
* Import project in IDE and run **mvn clean install**
* From IDE directly run Application.java
* Running as a Jar
    * run **mvn clean package**. This will generate wholesale-engg-app-0.0.1.jar in target folder.
    * Open Command/Terminal. 
    * Go to the folder containing Jar. 
    * Execute on terminal **java -jar wholesale-engg-app-0.0.1.jar**
		
		
