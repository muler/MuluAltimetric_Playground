The following projects are involved to accomplish the asked Task.
1. Client is running at http://localhost:8080
2. RESTful microservices running at:
http://localhost:8084/api/track/top/{country_name}

3.Eureka from netflix used for service discovery running at
http://localhost:8761/dashboard/ 

4. Zuul is used as reverse proxy, such that every request coming from the cliend passes through it to the target


5. Access the swagger for more details on the end points, the models created, and other available information.
http://localhost:8084/swagger-ui.html#/Track_Controller
