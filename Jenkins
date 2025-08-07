// This make the gv variable global, it gets initialized below
def gv

pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
	    string(name: 'VERSION', defaultValue: '', description: 'This is a string value')    
    }
    stages {
        stage("init") {
            steps {
		        echo 'initializing the application...'
                script {
                   gv = load "script.groovy" 
                }
            }
        }
        stage("build") {
            steps {
		        echo 'building the application...'
                script {
                    gv.buildApp()
                }
            }
        }
        stage("test") {
            when {
                expression {
		            // Use params to access parameter, see at start of script
                    params.executeTests()
                }
            }
            // Steps block runs only if the when condition above is true
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }   
}
