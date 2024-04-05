pipeline {
 environment {
    PROJECT = credentials('project_id') // secret text for the project id. I set it manually in Jenkins credentials
    APP_NAME = "proj2webapp"
    CLUSTER = credentials("cluster_name") // secret text for the cluster name. I set it manually in Jenkins credentials
    CLUSTER_ZONE = credentials("cluster_zone") // secret text for the cluster zone. I set it manually in Jenkins credentials
    REPO_PATH= credentials("repo_path") // secret text for the repo path. I set it manually in Jenkins credentials
    IMAGE_TAG = "$REPO_PATH/${APP_NAME}"
    SERVICE_ACCOUNT= credentials('serive_account')    // secret file for the GCP credential JSON file. I set it manually in Jenkins credentials
  }
    agent{   // create a node under the name gcloud that running google/cloud-sdk:latest docker image 
        kubernetes {
      label 'sample-app'
      yaml """
apiVersion: v1
kind: Pod
metadata:
labels: 
  component: ci
spec:
  containers:
  # Use service account that can deploy to all namespaces
  - name: gcloud
    image:  google/cloud-sdk:latest
    command:
    - cat
    tty: true
"""
    }
}
    tools{
        maven 'maven'
    }
    stages {
        stage ('test') {
            steps {
                sh 'mvn clean test -f ./Webapp/pom.xml'
            }
        }
        stage('build'){
            steps{
                sh 'mvn package -DskipTests -f ./Webapp/ clean package'
            }
        }
        stage('containerize'){
            steps{
                container('gcloud') {   // within the gcloud container
                    dir('Webapp'){
                        // set the credential for gcloud within the container
                        sh 'gcloud auth activate-service-account --key-file $SERVICE_ACCOUNT'
                        sh 'gcloud config set project $PROJECT'
                        
                        script {
                            try {
                                // docker build + push
                                sh 'gcloud builds submit -t $IMAGE_TAG --suppress-logs'
                            }
                            catch (Exception e) {
                            }
                        }
                    }
                }
            }
        }
        stage('deployment'){
            steps{
                container('gcloud') {
                    dir('Webapp'){
                        // set the credential for gcloud and kubectl within the container
                        sh 'gcloud auth activate-service-account --key-file $SERVICE_ACCOUNT'
                        sh 'gcloud config set project $PROJECT'
                        sh 'gcloud container clusters get-credentials $CLUSTER --region=$CLUSTER_ZONE'
                        script{
                            try{
                                // delete it if a previous deployment exists
                                sh 'kubectl delete deployment binarycalculator-deployment'
                            }
                            catch (Exception e){
                                
                            }
                        }
                        // create a new deployment
                        sh 'kubectl create deployment binarycalculator-deployment --image $IMAGE_TAG --port=8080'

                    }
                }
            }
        }
        stage('service'){
            steps{
                container('gcloud') {
                    dir('Webapp'){
                        // set the credential for gcloud and kubectl within the container
                        sh 'gcloud auth activate-service-account --key-file $SERVICE_ACCOUNT'
                        sh 'gcloud config set project $PROJECT'
                        sh 'gcloud container clusters get-credentials $CLUSTER --region=$CLUSTER_ZONE'
                        script{
                            try{
                                // create if it the service doesn't exist. No need to recreate it
                                sh 'kubectl expose deployment binarycalculator-deployment --type=LoadBalancer --name=binarycalculator-service'
                            }
                            catch (Exception e){
                                
                            }
                        }
                        // display the service IP
                        sh "kubectl get service/binarycalculator-service -o jsonpath='{.status.loadBalancer.ingress[0].ip}'"

                    }
                }
            }
        }
    }
}
