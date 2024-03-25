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
    }
}