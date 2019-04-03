#!/usr/bin/env groovy

def create(fileSize, fileCount){
 
  stage('Create Files') {
      script {
        for (def i = 0; element < fileCount; i++) {
         writeFile file: 'groovy${i}.txt', text: 'Working with files the Groovy way is easy. ${i}'
         sh 'ls -l groovy${i}.txt'
         sh 'cat groovy${i}.txt'
         println "Number ${i}"
       }
       
      }

  }
}


return this;
