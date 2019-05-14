### Spring Boot Backend Application REST API


1. Create JAR file `mvn clean install`
2. Start Minikube `minikube start`
3. SSH into Minikube `minikube ssh`
4. Goto `boot-backend` directory
5. Execute following command to create Docker container `docker build --file=Dockerfile --tag=boot-backend:latest --rm=true .`
6. Exit out Minikube shell.
7. Execute following command to create K8s objects. `kubectl create -f boot-backend.yaml`


###### Clean Up
1. `kubectl delete service boot-backend`
2. `kubectl delete deployment boot-backend`