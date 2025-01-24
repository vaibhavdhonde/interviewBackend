pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git url: 'https://github.com/vaibhavdhonde/interviewBackend'
            }
        }
        stage('Build Backend') {
            steps {
                sh '''
                # Install dependencies
                mvn clean install
                '''
            }
        }
        stage('Run Backend') {
            steps {
                sh '''
                # Start the server
                java -jar target/*.jar &
                '''
            }
        }
    }
}
