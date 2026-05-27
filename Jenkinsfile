pipeline {
    agent any

    tools {
        jdk 'JDK21.0.11'
        maven 'Maven3'
    }

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

        stage('Clean Workspace') {
            steps {
                bat 'if exist target rmdir /s /q target'
            }
        }

        stage('Build Application') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Unit Tests') {
            steps {
                steps {
                    bat 'mvn test'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat '''
                    mvn sonar:sonar ^
                    -Dsonar.projectKey=Demo_Devops ^
                    -Dsonar.projectName=Demo_Devops ^
                    -Dsonar.host.url=http://localhost:9000 ^
                    -Dsonar.login=%SONAR_AUTH_TOKEN% ^
                    -Dsonar.java.binaries=target/classes
                    '''
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Package Application') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Display Artifact') {
            steps {
                bat 'dir target'
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

        always {
            echo 'Pipeline execution finished'
        }
    }
}