# IAM Horus Web

Open Sorce IAM with the following features:

- User management
- Applications (api & web) management
- Options management
- Profiles & Roles
- Client Grant

# Requirements

- java 8
- mysql

```
docker run -d -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=secret mysql:5.7 --character-set-server=utf8 --collation-server=utf8_unicode_ci
```
- maven

# Global Steps

Execute this steps if you want to run the app in developer or production mode

- Clone this repository
- Install offline dependencies

```
mvn install:install-file -Dfile=openxava.jar -DgroupId=org.openxava -DartifactId=openxava -Dversion=1.0.0 -Dpackaging=jar

mvn install:install-file -Dfile=addons.jar -DgroupId=org.openxava -DartifactId=openxava-addons -Dversion=1.0.0 -Dpackaging=jar

mvn install:install-file -Dfile=ox-jdbc-adapters.jar -DgroupId=org.openxava -DartifactId=openxava-jdbc-adapters -Dversion=1.0.0 -Dpackaging=jar

mvn install:install-file -Dfile=hibernate-core-5.3.9.Fixed.jar -DgroupId=org.hibernate -DartifactId=hibernate-core -Dversion=5.3.9.Fixed -Dpackaging=jar
```
- create a database and execute this file: src/main/resources/database-ddl/structure.sql

# Variables

| variable | sample value | description |
|----------|--------------|-------------|
|DATABASE_HORUS_HOST| localhost|mysql ip |
|DATABASE_HORUS_PORT| 3306|mysql port |
|DATABASE_HORUS_NAME| my_horus|mysql database name |
|DATABASE_HORUS_WEB_USER| john|mysql user |
|DATABASE_HORUS_WEB_PASSWORD| changeme|mysql pasword |
|ADMIN_PASSWORD| ***** | horus admin password |
|LOG_HIBERNATE_SQL| true| enable horus web java log |

# Developer Mode

- Open this repository using eclipse
- Disable jsp and javascript validations: https://yandao.github.io/quick%20tips/2015/03/26/disable-stupid-eclipse-jsp-validation-errors
- Disable xml validation in this file : src/main/resources/application.xml
- Add tomcat 9 to your eclipse
- Configure the run of this app using eclipse "Run Configurations ..." and select Apache Tomcat
- Configure the required environment variables using eclipse "Run Configurations ..."
- Select the previous configured task in eclipse and press "Run"


# Production Mode

- compile this maven repository using : mvn clean package
- export variables in your java server : tomcat, widfly, etc
- deploy the generated war

# Login

If you deploy the war with name : iam-horus-web.war in your tomcat, the managment url will be:

> http://localhost:8080/iam-horus-web/

- user: ADMIN
- password: whatever you configured in **ADMIN_PASSWORD**

# TO-DO

- Use properties file or environment variables instead hardcoded values
- Add ant run to update sql schema
- Add a new tas in official openxava distribution to create this maven project
- Open a pull request with hibernate improvement to use environment values: https://github.com/jrichardsz/hibernate-orm/tree/5.3.9-Final-Feature_env
- Create Login for web clients
- Remove google dependency in order to create a plugin
