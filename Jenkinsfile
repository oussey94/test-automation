pipeline {
    agent any
    tools {
        maven 'Maven'
    }

    stages {

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh "mvn clean verify sonar:sonar -Dsonar.projectKey=SonarQubeDockerDemoWithJenkins" //port 9000 is default for sonar
                    echo 'SonarQube Analysis Completed'
                }
            }
        }
        stage('Build docker image') {
            steps {
                sh "docker build -t localhost:5003/test-sonar:v1.0.${BUILD_NUMBER} ."
                script {
                    try {
                        sh 'docker rm -f test'
                    }catch (exc) {
                        echo 'Erreur de supp'
                    }
                }
                sh "docker run --name test -d -p 8088:8080 localhost:5003/test-sonar:v1.0.${BUILD_NUMBER}"
            }
        }
        stage('Push docker image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                    sh "docker push localhost:5003/test-sonar:v1.0.${BUILD_NUMBER}"
                }
            }
        }
    }
}