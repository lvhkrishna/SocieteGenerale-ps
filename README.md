# SocieteGenerale-ps
Societe Generale Problem Statement

Software/IDEs to install:
1. NodeJS (https://nodejs.org/en/download/) - Global install
2. Angular-cli (Using command npm install -g @angular/cli) - Global Install
3. Eclipse (https://www.eclipse.org/downloads/)
4. Install "Spring Tools 4 - for Spring Boot" from Help -> Eclipse Marketplace

Project Setup:
1. Download the zip file from GitHub
2. Import the project into Eclipse as Maven project (File -> Import -> Maven -> Existing Maven Projects))
3. Update the project (Right click on the project in Eclipse -> Maven -> Update Project)
4. Now Open Command Prompt
5. cd to the root directory of the project "SocieteGenerale-ps-master"
6. Then cd to SGenerale/src/main/webapp/sg-ui and update npm using command "npm update"

Running the project - Back End:
1. In Eclipse, Right click on the project in Package Explorer -> Run As -> Spring Boot App
2. Back-end runs on port 8080 (localhost:8080)

Running the project - Front End:
1. In command prompt cd to /SGenerale/src/main/webapp/sg-ui folder as already done above
2. Use command "ng serve" to run the front-end
3. Front-end runs on port 4200 (localhost:4200)
4. Now opening the url "localhost:4200" gives the UI
