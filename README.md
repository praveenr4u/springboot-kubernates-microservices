# springboot-kubernetes-microservices
Deploying Java Applications with Docker and Kubernetes

### install 

    Brew install kubectl
    Brew install hyperkit
    Brew install minikube 

### Run these commands

    mvn clean install
    minkube start
    minikube status
    kubectl cluster-info
    eval $(minikube docker-env)
    

### Build the images

    docker build -t praveenr4u/stockmanager:latest . 
    docker build -t praveenr4u/productbrochure:latest . 
    docker build -t praveenr4u/showroom:latest .

### Push images

    docker push praveenr4u/showroom:latest
    docker push praveenr4u/stockmanager:latest
    docker push praveenr4u/productbrochure:latest

### Create deployments 

    kubectl apply -f stockmanager-service.yaml
    kubectl apply -f showroom-service.yaml
    kubectl apply -f productbrochure-service.yaml
    kubectl get deployments
    kubectl get pods

### Load the pages

    minikube service showroom - copy the URL & load it from a browser
    minikube service stockmanager - copy the URL & load it from a browser
    minikube service productbrochure - copy the URL & load it from a browser

