# abacus

A Spring Boot project which is intended to be deployed via a Docker container. CI and CD are setup in Jenkins. After a successful CI build, the CD build will build the Docker image, and automatically run the application on a Docker host.


CI Build: [http://dmalone.io:8080/jenkins/job/abacus-ci/]
CD Build: [http://dmalone.io:8080/jenkins/job/abacus-cd/]
Live App: [http://dmalone.io:8899/]
