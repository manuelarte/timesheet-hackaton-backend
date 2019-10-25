# Timesheet Hackaton Backend

Timesheet backend project. Project that allows you to submit your timesheet and send it to Nora.
Currently the application can pre-fill your requested month, then when you submit it an email is sent with the official excel file.

## TODO
* Complete investigation Bamboo HR
* Add validations to the POJOs
* Think about database engine and storing
* Investigate how to retrieve national/bank holidays from an external party

# How to run the project

You need to set up the following environment variables:

* spring.mail.host
* spring.mail.port
* spring.mail.username
* spring.mail.password

Start it as a regular spring boot application.

./gradlew ...

# Endpoints

Swagger documentation is provided in the following endpoint:

> http://localhost:8080/swagger-ui.html

