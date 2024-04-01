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
                sh 'mvn clean test -f src/test/java/com/example/myproject/pom.xml'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'mvn package -DskipTests -f src/main/java/com/example/myproject/pom.xml'
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
