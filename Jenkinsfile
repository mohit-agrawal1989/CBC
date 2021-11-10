// pipeline{
// 	agent any
// 	stages{
// 		stage("Pull Image"){
// 			steps{
// 				sh "docker pull viacomcbs/aquaweb"
// 			}
// 		}
// 		stage("Start Grid"){
// 			steps{
// 				sh "docker-compose up -d hub chrome firefox"
// 			}
// 		}
// 		stage("Run Test"){
// 			steps{
// 				sh "docker-compose up cucumber"
// 			}
// 		}
// 	}
// 	post{
// 		always{
// 		//	archiveArtifacts artifacts: 'result.txt'
// 			sh "docker-compose down"
// 		//	sh "sudo rm -rf result.txt"
// 		}
// 	}
// }


pipeline{
	agent any
	stages{
		stage("Pull Image"){
			steps{
// 			    sh "docker push us-docker.pkg.dev/i-cbscom-dev/pplus-qa-automation/webtest:latest"
                sh "docker push us-docker.pkg.dev/i-cbscom-dev/pplus-qa-automation/cbs-stage-web-smoketest:latest"
			}
		}
		//stage("Start Grid"){
		//	steps{
		//		sh "docker-compose up -d hub chrome firefox"

		//	}
		//}
		stage("Run Test"){
			steps{
				sh "docker-compose up cucumber"
			}
		}
	}
	post{
		always{
			sh "docker-compose down"
		}
	}
}