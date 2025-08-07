// All env variables from the Jenkinsfile are available here

def buildApp() {
    echo 'building the application...'
} 

def testApp() {
    echo 'testing the application...'
} 

def deployApp() {
    echo 'deplying the application...'
    echo "deploying version ${params.VERSION}"
} 

// Always returh this to allow importing the functions in Jenkinsfile
return this