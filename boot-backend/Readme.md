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

#### Concourse Set Up

1. Download Concourse docker-compose file. `wget https://concourse-ci.org/docker-compose.yml`
2. Update `docker-compose.yml` file. Update `image: concourse/concourse` to `image: concourse/concourse-rc`
3. Create credentials.yaml file with following contents. Do **NOT** commit this file to git.
   ```yaml
    docker-hub-email: <docker-hub-email>
    docker-hub-username: <docker-hub-username>
    docker-hub-password: <docker-hub-password>
    ```
4. Create concourse pipeline by running following command
   ```bash
   fly -t tutorial sp -c spring-boot-kubernetes/boot-backend/src/main/ci/pipeline.yaml -p boot-backend -l spring-boot-kubernetes/boot-backend/src/main/ci/credentials.yaml
   ```
5. Start the pipeline by clicking **+** sign
6. Login to Docker Hub to verify new docker image is available. 