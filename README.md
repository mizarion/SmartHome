# SmartHome


## Available scenarios:

### RabbitMQ
#### RUN:
1.     docker compose -f .\docker\docker-compose-rabbitmq.yml up
2.     RabbitExampleApplication

#### USE:
* GET http://localhost:8090/single_queue
* GET http://localhost:8090/workers
* GET http://localhost:8090/publisher


### Eureka + @LoadBalanced
#### RUN:
* EurekaApplication
* WebApplication
* SensorApplication (2+ instances)

#### USE:

##### eureka-service
* GET http://localhost:8761

##### web-service
* GET http://localhost:8080/test/1
* GET http://localhost:8080/test/2
* GET http://localhost:8080/test/3

##### sensor-service
* GET  http://localhost:8081/api/example
* POST http://localhost:8081/api/example


### Eureka + Spring Boot Admin
#### RUN:
* EurekaApplication
* AdminApplication
* ....

#### USE:
##### admin-service
* http://localhost:9090


