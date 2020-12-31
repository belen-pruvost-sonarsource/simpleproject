node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'maven3.6';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn sonar:sonar"
    }
  }
}
