node {  
    stage('Checkout') {
        checkout scm
    }    

    stage('Clean') {
        def mvnHome = tool 'Maven3'
        configFileProvider([configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')]) {
            sh "${mvnHome}/bin/mvn -s $MAVEN_SETTINGS clean"
        } 
    }

    stage('Build') {
        def mvnHome = tool 'Maven3'
        configFileProvider([configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')]) {
            sh "${mvnHome}/bin/mvn -s $MAVEN_SETTINGS compile"
        } 
    }

    stage('Test') {
        def mvnHome = tool 'Maven3'
        configFileProvider([configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')]) {
            sh "${mvnHome}/bin/mvn -s $MAVEN_SETTINGS test"
        } 
    }  

    stage('Version') {
        def version = "1.0.${env.BUILD_NUMBER}"
        currentBuild.description = version
    }

    stage('Package') {
        def mvnHome = tool 'Maven3'
        configFileProvider([configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')]) {
            sh "${mvnHome}/bin/mvn package -s $MAVEN_SETTINGS -Dmaven.test.skip=true"    
        }
    }

    stage('Publish') {
        def dockerHome = tool 'Docker17'
        configFileProvider([configFile(fileId: 'docker-registry', variable: 'CONFIG_DOCKER_REGISTRY')]) {
            def dockerRegistry = readFile("$CONFIG_DOCKER_REGISTRY")

            withCredentials([usernamePassword(credentialsId: 'docker-registry-push', passwordVariable: 'CONFIG_DOCKER_PASSWORD', usernameVariable: 'CONFIG_DOCKER_USER')]) {
                sh "${dockerHome}/bin/docker -H $dockerRegistry login -u $CONFIG_DOCKER_USER -p $CONFIG_DOCKER_PASSWORD $dockerRegistry"
            }

            sh "${dockerHome}/bin/docker -H $dockerRegistry build -t $dockerRegistry/$JOB_NAME:${currentBuild.description} ."
            sh "${dockerHome}/bin/docker -H $dockerRegistry push $dockerRegistry/$JOB_NAME:${currentBuild.description}"
            sh "${dockerHome}/bin/docker -H $dockerRegistry rmi $dockerRegistry/$JOB_NAME:${currentBuild.description}"
        } 
    }

    stage('Tag') {
        sh "git tag ${currentBuild.description}"
        sh "git push --tags"
    }
}