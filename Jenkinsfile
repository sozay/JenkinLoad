node {
    
  stage('Checkout') {
    checkout scm
  }

  stage('execute') {
    def loadFile = load "groovy/loadFile.groovy"
    def fileSize = 1024
    def fileCount =100
    workloadPipeline(fileSize, fileCount)
  }
   
}
