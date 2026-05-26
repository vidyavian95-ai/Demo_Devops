pipeline {
    agent any

    environment {
        APP_NAME = "bookstore-api"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                credentialsId: 'github-token',
                url: 'https://github.com/vidyavian95-ai/Demo_Devops.git'
            }
        }

        stage('Build Application') {
            steps {
                bat '"C:\\Program Files\\maven\\apache-maven-3.9.15\\bin\\mvn.cmd" clean package -DskipTests'
            }
        }

        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {

        success {
            echo 'Build completed successfully'
        }

        failure {
            echo 'Build failed'
        }
    }
}