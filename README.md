### Creating fat-jar & Docker image through buildpacks for consumer-app
1. In consumer-app directory run the command below:


    ./mvnw spring-boot:build-image

2. List images:

you should see consumer-app image tagged with 0.0.1-SNAPSHOT.


    docker images

3. To run the image:


    docker run consumer-app:0.0.1-SNAPSHOT --name consumer-app -d

### Building image for vertx-app 
In vertx-app directory run the command below to build Docker image from Dockerfile:

    docker build -t vertx-webapp:1.0-SNAPSHOT .

To check all images:

    docker images

To run the image:

-p tag maps the host's port 8090 to port 8085 inside that container.

    docker run -p 8090:8085 vertx-webapp:1.0-SNAPSHOT

Access the application using port 8090 on the host machine:

    curl http://localhost:8090/api/v1/hello 

---

# Run the app

To set up your application simply run the command below: 

    docker-compose up

Next commands should be executed on the kafka container, 
## so first log in into the container by typing:

    docker-compose exec kafka bash

### create a Kafka topic:
    
    /opt/bitnami/kafka/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --topic channel

To test the Kafka topic: 

1. execute consumer on topic-name topic:

    
    /opt/bitnami/kafka/bin/kafka-console-consumer.sh --topic channel --from-beginning --bootstrap-server localhost:9092


2. In new terminal on kafka container type:

    
    /opt/bitnami/kafka/bin/kafka-console-producer.sh --topic channel --bootstrap-server localhost:9092

now you can type messages that will be listening in the consumer. 

---

# Requests

    http://localhost:8085/api/v1/hello

    
    http://localhost:8085/api/v1/hello/henry


# Local Kubernetes installation 

    1. minikube start

    2. minikube status

    3. kubectl get node

## Kubernetes Configuration

Created 4 Kubernetes configuration files. 

1. ConfigMap with PostgreSQL database endpoint
   [ConfigMap Doc](https://kubernetes.io/docs/concepts/configuration/configmap/)
2. Secret with PostgreSQL username and password
   [Secret Doc](https://kubernetes.io/docs/concepts/configuration/secret/)

   #### Encoding username and password
   
   paste the values below in psql-secret.yaml file
   ```
      echo -n <username> | openssl base64
      echo -n <password> | openssl base64 
   ```
3. Kubernetes configuration file for deploying a PostgreSQL application and its Service
4. Kubernetes configuration file for deploying vertx-kafka-basic application with its Service



    