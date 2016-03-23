"# OnlineStore"

This web application is written as a assignment for REST APIs of a OnlineStore and requires following software to be installed first.
- Latest version of Maven
- JDK 7 or later

It utilizes following frameworks,
- Spring Web/MVC
- myBatis
- hsql db
- JUnit

Architecture
- Service Layer: This is set of interfaces and is the core of the application. These are stateless objects. It is implemented by default implementers but can be implemented by
mock implementations to be used in testing of web controllers in isolation.

- Web Controller Layer: This is thin layer and its purpose is to expose service layer as REST APIs, to add security and session management.

- DAO Layer: DB interaction. It can be implemented by any means e.g. myBatis as in this case or hibernate or mock for testing service layer in isolation.

Unit tests can be added at every layer to test them in isolation and to be implemented in isolation or in parallel.

Please check test classes of controllers for REST API usage.



