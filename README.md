# To run the project:
maven, java jdk8, 
Go to the folder you want to download the project and:
git clone https://github.com/kostasmakris1/work.git

The command to run the tests is:
mvn clean install -DbrowserName=chrome ( runs on a Mac machine  )
mvn clean install -DbrowserName=firefox ( tested with firefox version 42. The latest verrson of firefox doesn't work with selenium)

or from the IDE ( in the run configurations under the VM arguments 
-DbrowserName=chrome)


