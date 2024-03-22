pipeline {
    agent any
    tools {
        maven 'Maven'
    }

    stages {

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh '''mvn clean verify sonar:sonar -Dsonar.projectKey=SonarQubeDockerDemoWithJenkins -Dsonar.host.url=http://localhost:9001''' //port 9000 is default for sonar
                    echo 'SonarQube Analysis Completed'
                }
            }
        }
    }
}