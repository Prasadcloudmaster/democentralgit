pipeline {
    agent any
    stages {
        stage('Pull') {
            steps {
                git credentialsId: '0771278a-4ae5-45d6-95ad-22781f9785d4', url: 'https://gitlab.com/prasad-deo/cbz-student-ui.git'
                sh 'ls'
            }
        }
        stage('Build') {
            steps {
                echo 'code is Building'
                 sh 'mvn clean package'
            }
        }
        stage('deploy to server') {
            steps {
           deploy adapters: [tomcat9(credentialsId: '8019fdfd-7153-42e5-aac7-1f8fb58c789b', path: '', url: 'http://172.31.37.203:8080')], contextPath: '/', war: '**/*.war'
            }
        }
    }
}