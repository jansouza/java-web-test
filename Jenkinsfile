node {

    stage('Getting ready...') {

      git branch: "dev", credentialsId: 'your_id_on_jenkins', url: 'https://github.com/amenski/jenkins_pipeline.git'

  }
    stage 'checkout'
    git 'git@github.com:jansouza/java-web-test.git' 

    stage 'build'

    sh 'mvn clean install'

