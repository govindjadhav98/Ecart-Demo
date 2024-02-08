pipeline {
    agent any

    stages {
        stage('Fetching code from github') {
            steps {
                git 'https://github.com/govindjadhav98/Ecart-Demo.git/'
            }
        }
        stage('Execute the code in Chrome') {
            steps {
                bat 'mvn -Dmaven.test.failure.ignore=true test -PRegression -Dbrowser=Chrome'
            }
        }
        stage('Execute the code in Firefox') {
            steps {
                bat 'mvn -Dmaven.test.failure.ignore=true test -PRegression -Dbrowser=Firefox'
            }
        }
        
    }
    post {
        always{
            emailext attachLog: true, attachmentsPattern: 'test-output/index.html', body: '''Hi, This is the Jenkins test email please ignore it.

Note: This is an autoemail please do not respond.''', subject: 'Jenkins Test mail', to: 'govindjadhav29199@gmail.com'
        }
    }
}