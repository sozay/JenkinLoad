#!/usr/bin/env groovy

def create(fileSize, fileCount){
 
  stage('Create Files') {
      script {
       1.upto(fileCount, {
        writeFile file: 'groovy${it}.txt', text: 'Working with files the Groovy way is easy. ${it}'
        sh 'ls -l groovy${it}.txt'
        sh 'cat groovy{it}.txt'
        println "Number ${it}"
       })
       
      }

  }
}


return this;
