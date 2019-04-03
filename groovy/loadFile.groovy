#!/usr/bin/env groovy

def call(fileSize, fileCount){
  stage('Checkout') {
    checkout scm
  }
  stage('Create Files') {
      script {
        writeFile file: 'groovy1.txt', text: 'Working with files the Groovy way is easy.'
        sh 'ls -l groovy1.txt'
        sh 'cat groovy1.txt'
      }

  }
}


return this;
