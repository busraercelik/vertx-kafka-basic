# Pushing images to Docker Hub

```
   docker login 
```

```
   docker push bercelik/producer_vertx_app:v1.0
```

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

   paste the values below in postgres-secret.yaml file
   ```
      echo -n <username> | openssl base64
      echo -n <password> | openssl base64 
   ```
3. Kubernetes configuration file for deploying a PostgreSQL application and its Service
4. Kubernetes configuration file for deploying vertx-kafka-basic application with its Service

## Deploy All Resources in Minikube cluster

1. Create the external configurations on K8s cluster.
    

    kubectl apply -f <file-name.yaml>

```
   kubectl apply -f postgres-config.yaml
```

```
   kubectl apply -f postgres-secret.yaml
```

```
   kubectl apply -f postgres.yaml
```

```
   kubectl apply -f webapp.yaml
```
```
   kubectl apply -f .\namespace-kafka.yam
```
## Interacting with K8s cluster

1. Get all the components created in the cluster 

```
   kubectl get all
```

2. Verify if configmap is created
```
   kubectl get configmap
```

3. Get detailed information with 'describe' command

```
   kubectl describe service webapp-service
```

4. View logs of container

```
   kubectl logs postgres-deployment-5bdbf46679-4xvvc 
```

Stream the log 

```
   kubectl logs postgres-deployment-5bdbf46679-4xvvc -f
```

# Access WebApp in Browser
Get the address of minikube
``` 
   minikube ip
```
or
``` 
   kubectl get node -o wide
```

# Create External IP Address For vertx-app 


      minikube service vertx-webapp


# Get all namespaces in Kubernetes Cluster

      kubens

# Switch to namespace you want 

   
      kubens <namespace>