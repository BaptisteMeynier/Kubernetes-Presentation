# Kubernetes Presentation

## Microprofile

#### Compile: 
mvn clean install

#### Launch:
java -jar portfolio-app/target/portfolio-app-hollow-thorntail.jar portfolio-app/target/portfolio-app.war -s portfolio-app/src/main/filters/project-defaults.yml

#### Url:  

##### Portfolio:
http://localhost:8080/api/v1/portfolio
http://localhost:8080/api/v1/portfolio?page=10&per_page=2

##### Health:
http://localhost:8080/health

##### Metric:
http://localhost:8080/metrics

###### Swagger:
http://localhost:8080/  
http://localhost:8080/api/v1/swagger.json


_____________________________________________
## Gatling

mvn gatling:test -Dgatling.simulationClass=portfolio.GetPortfoliosSimulation

_____________________________________
## Docker

### Download a wildfly image
docker pull jboss/wildfly

### Build image
docker build -t microprofile/server:1.0.0 -f Dockerfile-server .

docker build -t microprofile/application:1.0.0 -f Dockerfile-application .

[baptiste@localhost Kubernetes-Presentation]$ docker images
REPOSITORY                     TAG                 IMAGE ID            CREATED             SIZE
microprofile/application       1.0.0               c0762d70523d        4 seconds ago       219 MB
microprofile/server            1.0.0               1849f78ba969        9 minutes ago       213 MB
docker.io/jboss/wildfly        latest              5de2811bb236        12 days ago         745 MB


### Launch container
[baptiste@localhost Kubernetes-Presentation]$ docker run -p 8080:8080 -d -it microprofile/application:1.0.0


### Connect to container
[baptiste@localhost Kubernetes-Presentation]$ docker ps
CONTAINER ID        IMAGE                            COMMAND                  CREATED             STATUS              PORTS                    NAMES
a065a091c37f        microprofile/application:1.0.0   "java -jar /opt/ho..."   13 seconds ago      Up 13 seconds       0.0.0.0:8080->8080/tcp   mystifying_golick


[baptiste@localhost Kubernetes-Presentation]$ docker exec -it 1c741289faab /bin/sh

_______________________________________________
## Kubernetes

#### MiniKube installation: 

#### Console installation:
????

#### Generate access token: 
kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep admin-user | awk '{print $1}')

#### Create deployment:
kubectl apply -f portfolio-deployment.yml  

#### Expose deployment:
kubectl expose deployment  portfolio-deployment --type=NodePort --name=portfolio-service

#### Create proxy:
kubectl proxy --port=8080 --accept-hosts="^*$"

#### Url expose:
http://localhost:8080/api/v1/namespaces/default/services/portfolio-service/proxy/api/v1/portfolio


git clean -d -x -f