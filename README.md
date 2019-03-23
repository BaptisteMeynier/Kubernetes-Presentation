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
##### Under Fedora

Create a file in /etc/yum.repos.d
sudo vi kubernetes.repo
''' [Kubernetes]
name=Kubernetes
baseurl=https://packages.cloud.google.com/yum/repos/kubernetes-el7-x86_64
enabled=1
gpgcheck=1
repo_gpgcheck=1
gpgkey=https://packages.cloud.google.com/yum/doc/yum-key.gpg https://packages.cloud.google.com/yum/doc/rpm-package-key.gpg
'''

sudo dnf install kubectl

##### Install miniKube
Launch in your download folder:
curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64

[baptiste@DESKTOP Téléchargements]$ chmod +x minikube
[baptiste@DESKTOP Téléchargements]$ sudo mv -v minikube /usr/local/bin
[baptiste@DESKTOP Téléchargements]$ minikube start
[baptiste@DESKTOP Téléchargements]$ sudo dnf install Virtualbox

if you get this issue :
baptiste@DESKTOP-FUI7H3K Téléchargements]$ minikube start
😄  minikube v0.35.0 on linux (amd64)
💡  Tip: Use 'minikube start -p <name>' to create a new cluster, or 'minikube delete' to delete this one.
🔄  Restarting existing virtualbox VM for "minikube" ...
💣  Unable to start VM: start: Unable to start the VM: /usr/bin/VBoxManage startvm minikube --type headless failed:
VBoxManage: error: VT-x is disabled in the BIOS for all CPU modes (VERR_VMX_MSR_ALL_VMX_DISABLED)
VBoxManage: error: Details: code NS_ERROR_FAILURE (0x80004005), component ConsoleWrap, interface IConsole

Details: 00:00:00.345504 Power up failed (vrc=VERR_VMX_MSR_ALL_VMX_DISABLED, rc=NS_ERROR_FAILURE (0X80004005))

😿  Sorry that minikube crashed. If this was unexpected, we would love to hear from you:
👉  https://github.com/kubernetes/minikube/issues/new

You have to enable VTX in your bios:
Restart your computer enter in the bios configuration (for me I pressed F2)
Go to advanced settings > CPU > enable virtualization

[baptiste@DESKTOP-FUI7H3K ~]$ minikube start
😄  minikube v0.35.0 on linux (amd64)
💡  Tip: Use 'minikube start -p <name>' to create a new cluster, or 'minikube delete' to delete this one.
🔄  Restarting existing virtualbox VM for "minikube" ...
⌛  Waiting for SSH access ...
📶  "minikube" IP address is 192.168.99.100
🐳  Configuring Docker as the container runtime ...
✨  Preparing Kubernetes environment ...
💾  Downloading kubelet v1.13.4
💾  Downloading kubeadm v1.13.4
🚜  Pulling images required by Kubernetes v1.13.4 ...
🔄  Relaunching Kubernetes v1.13.4 using kubeadm ...
⌛  Waiting for pods: apiserver


##### Launch Dashboard

[baptiste@DESKTOP ~]$  kubectl create -f https://raw.githubusercontent.com/kubernetes/dashboard/master/aio/deploy/recommended/kubernetes-dashboard.yaml

[baptiste@DESKTOP ~]$ sudo kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/master/aio/deploy/recommended/kubernetes-dashboard.yaml

[baptiste@DESKTOP ~]$ kubectl proxy

[baptiste@DESKTOP Kubernetes-Presentation]$ kubectl apply -f dashboard-adminuser.yaml
serviceaccount/admin-user created

#### Generate access token: 
kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep admin-user | awk '{print $1}')

Copy past to http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/#!/overview?namespace=default

#### Create deployment:
kubectl apply -f portfolio-deployment.yml  

#### Expose deployment:
kubectl expose deployment  portfolio-deployment --type=NodePort --name=portfolio-service

#### Create proxy:
kubectl proxy --port=8080 --accept-hosts="^*$"

#### Url expose:
http://localhost:8080/api/v1/namespaces/default/services/portfolio-service/proxy/api/v1/portfolio


git clean -d -x -f

_______________________________________________________
#### References
https://github.com/kubernetes/dashboard/wiki/Creating-sample-user