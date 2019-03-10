# Kubernetes Presentation

____________________
####compile: 
mvn clean package -DskipTests

___________________
####Launch:
java -jar target/microprofile-1.0-SNAPSHOT-thorntail.jar
____________________
####url:  
http://localhost:8080/api/v1/portfolio?page=10&per_page=2

http://localhost:8080/health

https://github.com/gatling/gatling-maven-plugin-demo


_____________________________________
## Docker

### Build image
docker build -t microprofile/portfolio:v1 .

[baptiste@localhost Kubernetes-Presentation]$ docker images
REPOSITORY                     TAG                 IMAGE ID            CREATED             SIZE
microprofile/portfolio         v1                  025525503819        2 minutes ago       214 MB
docker.io/jboss/wildfly        latest              09689dda7ad5        2 months ago        675 MB
docker.io/payara/server-full   latest              f5982f444a3d        3 months ago        973 MB
docker.io/jenkins              latest              cd14cecfdb3a        7 months ago        696 MB
docker.io/openjdk              jre-alpine          ccfb0c83b2fe        8 months ago        83 MB


### Launch container
[baptiste@localhost Kubernetes-Presentation]$ docker run -p 8080:8080 -it microprofile/portfolio:v1

### Connect to container
[baptiste@localhost Kubernetes-Presentation]$ docker ps
CONTAINER ID        IMAGE                       COMMAND                  CREATED             STATUS              PORTS                    NAMES
1c741289faab        microprofile/portfolio:v1   "java -jar /opt/ho..."   2 minutes ago       Up 2 minutes        0.0.0.0:8080->8080/tcp   inspiring_kirch

[baptiste@localhost Kubernetes-Presentation]$ docker exec -it 1c741289faab /bin/sh

