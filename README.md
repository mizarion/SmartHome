# SmartHome

## Clone
```bash
git clone https://github.com/mizarion/SmartHome
cd SmartHome/
```

## Build & Run  (docker)
### Build 
```
mvn clean package dockerfile:build
```
### Run 
```
docker-compose -f docker/docker-compose.yml up
```

## Build & Run (IntelliJ IDEA)
IDEA -> Alt+8 -> Run each service:
* com/example/web/WebApplication.java
* com/example/sensor/SensorApplication.java

## Available endpoints:
#### 8081 (sensor)
* GET  http://localhost:8081/api/example
* POST http://localhost:8081/api/example

#### 8080 (web)
* GET http://localhost:8080/test/1
* GET http://localhost:8080/test/2


