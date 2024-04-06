pipeline {
    agent any
    tools {
        maven 'maven' 
    }

    environment {
        PROJECT_ID = 'projectdeliverable2-419406' // Define your project ID here
    }

    stages {
        stage ('Init') {
            steps {
                sh 'echo "Start of Job"'
                sh 'ls -la'
            }
        }

        stage ('test') {
            steps {
                sh 'mvn clean test -f ./pom.xml'
            }
        }

        stage ('build') {
            steps {
                sh 'mvn package -DskipTests -f ./pom.xml'
            }
        }

        stage ('Deploy') {
            steps {
                // Update Jenkinsfile to replace placeholder with actual project ID
                sh "sed -i 's|REPLACE_WITH_YOUR_PROJECT_ID|projectdeliverable2-419406|' Jenkinsfile"
                sh 'echo "Jenkinsfile updated with project ID"'
                
                // Set GCP project ID
                sh 'gcloud config set project projectdeliverable2-419406'

                // Example: Deploy application to Google App Engine
                sh 'gcloud app deploy --project=projectdeliverable2-419406 --version=v1'
                
                // You can add more deployment steps as needed
            }
        }
    }
}
