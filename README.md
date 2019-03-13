# Kubernetes Presentation

##Microprofile

####Compile: 
mvn clean package

####Launch:
java -jar portfolio-business/target/portfolio-hollow-thorntail.jar portfolio-business/target/portfolio.war -s portfolio-business/src/main/filters/project-defaults.yml

####Url:  

#####Health:
http://localhost:8080/health

#####Metric:
http://localhost:8080/metrics

#####Portfolio:
http://localhost:8080/api/v1/portfolio  
http://localhost:8080/api/v1/portfolio?page=10&per_page=2  
######Swagger:
http://localhost:8080/  
http://localhost:8080/api/v1/swagger.json





_____________________________________________
##Gatling

mvn gatling:test -Dgatling.simulationClass=portfolio.GetPortfoliosSimulation

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
[baptiste@localhost Kubernetes-Presentation]$ docker run -p 8080:8080 -d -it microprofile/portfolio:v1

### Connect to container
[baptiste@localhost Kubernetes-Presentation]$ docker ps
CONTAINER ID        IMAGE                       COMMAND                  CREATED             STATUS              PORTS                    NAMES
1c741289faab        microprofile/portfolio:v1   "java -jar /opt/ho..."   2 minutes ago       Up 2 minutes        0.0.0.0:8080->8080/tcp   inspiring_kirch

[baptiste@localhost Kubernetes-Presentation]$ docker exec -it 1c741289faab /bin/sh

_______________________________________________
##Kubernetes

####MiniKube installation: 

####Console installation:
????

####Generate access token: 
kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep admin-user | awk '{print $1}')

####Create deployment:
kubectl apply -f portfolio-deployment.yml  

####Expose deployment:
kubectl expose deployment  portfolio-deployment --type=NodePort --name=portfolio-service

####Create proxy:
kubectl proxy --port=8080 --accept-hosts="^*$"

####Url expose:
http://localhost:8080/api/v1/namespaces/default/services/portfolio-service/proxy/api/v1/portfolio

