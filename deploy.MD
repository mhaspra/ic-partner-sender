#Build the jar
mvn clean package

#Build the docker images
docker build -t ic-partner-sender:1.0 .

#Deploy stack
kubectl apply -f kubernetes.yaml

#Delete stack
kubectl delete -f kubernetes.yaml