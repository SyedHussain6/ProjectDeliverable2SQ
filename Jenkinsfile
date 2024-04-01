pipeline {
    agent any
    tools {
        maven 'maven' 
    }
    stages {
        stage ('Init') {
            steps {
                sh 'echo "Start of Job"'
                sh 'ls -la'
            }
        }
        stage ('Test') {
            steps {
                // Change directory to the current workspace before running tests
                dir('.') {
                    sh 'mvn clean test'
                }
            }
        }
        stage ('Build') {
            steps {
                // Change directory to the current workspace before building
                dir('.') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
        stage ('Deploy') {
            steps {
                sh 'echo "bye bye"'
            }
        }
    }
