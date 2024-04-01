pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Checkout source code from Git repository
                git 'https://github.com/yourusername/ProjectDeliverable2SQ.git'
                // Run Maven build
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                // Deploy the application (replace with your deployment steps)
                sh 'echo "Deploying application"'
            }
        }
    }
}
