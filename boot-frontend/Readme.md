### Spring Boot Frontend Application consuming REST API


1. Create JAR file `mvn clean install`
2. Start Minikube `minikube start`
3. SSH into Minikube `minikube ssh`
4. Goto `boot-frontend` directory
5. Execute following command to create Docker container `docker build --file=Dockerfile --tag=boot-frontend:latest --rm=true .`
6. Exit out Minikube shell.
7. Execute following command to create K8s objects. `kubectl create -f boot-frontend.yaml`
8. Finally access UI by executing `minikube service boot-frontend`

###### Clean Up
1. `kubectl delete service boot-frontend`
2. `kubectl delete deployment boot-frontend`