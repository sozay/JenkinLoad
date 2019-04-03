#!/usr/bin/env groovy

def call(fileSize, fileCount){
  stage('Checkout') {
    checkout scm
  }
  stage('Create Files') {
      script {
        def buildImage = docker.build("v-ops-build:${env.BUILD_ID}", "-f config/Dockerfile config")

        def current_dir = pwd();

        buildImage.inside(
            "-v ${HOME}/.aws:/root/.aws \
            -v /var/run/docker.sock:/var/run/docker.sock \
            -w ${current_dir} \
            -u 'root' \
            -e USER=${USER} \
            -e AWS_DEFAULT_REGION=eu-west-1 \
            -e ANSIBLE_CONFIG=/app/infrastructure/ansible.cfg \
            --net=host"
        ) {
            sh "account_name=${accountName} environment_identifier=${environmentIdentifer} component_name=${componentName} make ${target}"

        }
      }

  }
}


return this;
