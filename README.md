### Creating fat-jar & Docker image through buildpacks for consumer-app
In consumer-app directory run the command below:

    ./mvnw spring-boot:build-image

To run the image:

    docker run consumer-app:0.0.1-SNAPSHOT -d

### Building image for vertx-app 
In vertx-app directory run the command below:

    docker build -t vertx-webapp:1.0-SNAPSHOT .

To check all images:

    docker images

To run the image:

    docker run -p 8090:8085 vertx-webapp:1.0-SNAPSHOT

Access to application 

    curl http://localhost:8090/api/v1/hello 

