pipeline {
  agent any
  environment {
    IMAGE = "yourdockerhub/employee-service"
  }
  stages {
    stage('Checkout') { steps { git url: 'https://your-repo.git' } }
    stage('Build') { steps { sh './mvnw clean package -DskipTests' } }
    stage('Docker') {
      steps {
        script {
          docker.build("${IMAGE}:${BUILD_NUMBER}").push()
        }
      }
    }
    stage('Kubernetes Deploy') {
      steps {
        sh 'kubectl apply -f k8s/deployment.yaml'
      }
    }
  }
}
