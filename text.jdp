pipeline {
    agent any
    stages {
        stage('Pull') {
            steps {
                git credentialsId: 'tomcat', url: 'https://gitlab.com/prasad-deo/cbz-student-ui.git'
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
             deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://172.31.37.203:8080')], contextPath: '/', war: '**/*.war'
            }
        }
    }
}