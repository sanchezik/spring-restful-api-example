# Spring RESTful API example

This is an example of RESTful API in Java

## How to use

Please have JDK 23 installed on your machine. To check if it's installed, use command:

    java -version

Please have Maven installed on your machine. To check if it's installed, use command:

    mvn -version

Being in the root folder of the project, run this command in terminal to compile the application:

    mvn clean install

Being in the root folder of the project, run this command to start the application:

    java -jar target\restful-api-example-0.0.1-SNAPSHOT.war

To check if application runs, go to this link http://localhost:8080/api/posts in your favorite browser.

## Potential improvements

Despite this project is ready for use, I would make additional changes before deploying it on production:

1. **Unit tests.** There are no unit tests which are highly recommended to have.
2. **Integration (API) tests.** As we have RESTful API here, we should implement also API tests.
3. **Exception handling.** Now I ignore potential exceptions (for example, not founded blog posts) and send empty object
   in response.
4. **Logging.** Despite there is minor logging in some components, still I would log more info related to not usual
   behavior with the content (for example, when users try to create entities without proper fields).
5. **Authentication.** As for now, everybody in the web has access to the service. There should be some restrictions in
   order to avoid malicious actions.