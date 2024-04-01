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
        
        stage('Test') {
            steps {
                echo 'Testing...'
                dir('src/test/java/com/example/myproject') {
                    sh 'mvn clean test -f /var/jenkins_home/workspace/Proj2SQC/pom.xml'
                }
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building...'
                dir('src/main/java/com/example/myproject') {
                    sh 'mvn package -DskipTests -f /var/jenkins_home/workspace/Proj2SQC/pom.xml'
                }
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
