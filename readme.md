## Spring Boot - Todo App BE
This is a Todo List application built using Spring Boot as the backend to handle CRUD (Create, Read, Update, Delete) operations on todo data. This application allows users to add, edit, delete, and view the todo list.

## System Requirements

- Java openjdk : Version 17.0.2
- Spring Boot : version 3.4.1
- Database : MariaDB
- Maven : Apache Maven 3.9.3
- Editor : Intellij IDEA 2023.1.1 Community Edition

# Frontend
The frontend of this application can be accessed at the following link:
```
https://github.com/rardan97/todo-app-fe
```

## run project

1. clone project Spring Boot - Todo App BE
```
git clone https://github.com/rardan97/todo-app-be
```
2. add database name "db_todo" in MariaDB

3. open project with intellij IDEA then edit config database in application.properties
```
path : todo-app-be/src/main/resources/application.properties
```

```
spring.application.name=todo-app-be
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/db_todo
spring.datasource.username=root
spring.datasource.password=
spring.jpa.database=mysql
```


4. open terminal input command
```
mvn clean install 
```
5. if success next input command
```
mvn spring-boot:run
```