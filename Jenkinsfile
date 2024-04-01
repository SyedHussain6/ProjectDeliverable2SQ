pipeline {
    agent any
    
    tools {
        maven 'maven'
    }

    stages {
        stage('Initialize') {
            steps {
                echo 'Initializing...'
                // You can add any initialization steps here
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'mvn clean package'
                // Replace 'mvn clean package' with your actual build command
            }
        }
        
        stage('Test') {
            steps {
                echo 'Testing...'
                sh 'mvn test'
                // Replace 'mvn test' with your actual test command
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deployment steps here
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
            // You can add any post-build actions here
        }
    }
}
