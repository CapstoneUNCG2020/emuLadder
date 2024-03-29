![Image of EMULADDER](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/GitHubEmuLogo.png)

<p align="center">
  <a href="#team-members">Team Members</a> •
  <a href="#project-definition">Project Definition</a> •
  <a href="#architecture">Architecture</a> •
  <a href="#class-diagram">Class Diagram</a> •
  <a href="#entity-relationship-diagram">ER Diagram</a> •
  <a href="#user-interface">User Interface</a> •
  <a href="#how-to-install">How To Install</a> •
  <a href="#license">License</a>
</p>

## Team Members
- [Daniel Frye](https://github.com/danfrye)
- [Gabriel Wilmoth](https://github.com/GabeWilmoth)
- [Mckenzie Moize](https://github.com/mckenziemoize)
- [Rinty Chowdhury](https://github.com/rintychy)
- [Robert Meyer](https://github.com/rhmeyer314)

## Project Definition
The application, emuLadder, is a Fantasy eSports game similar to ESPN’s Fantasy Football, Hockey, etc. Users draft real-life eSports players from games such as League of Legends and compete against other users with their drafted players. Users earn points based on their drafted players stats per game. Fantasy games are very popular in sports such as football, soccer, hockey and many more, however, there is not a strong presence of Fantasy eSports. eSports is an ever-growing scene, and emuLadder seeks to provide a Fantasy experience to a community that not only enjoys eSports but also to those that enjoy video games in general. To achieve this, emuLadder looks to provide a competitive environment that keeps the user involved in both their Fantasy game and the eSports games their players are competing in. 

## Architecture
![EMULADDER Architecture](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/Architecture.png)

## Class Diagram
![EMULADDER Class Diagram](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/Class%20Diagram.png)

## Entity Relationship Diagram
![EMULADDER ER Diagram](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/Database%20Tables.jpg)

## User Interface
  ### Landing Page
  ![EMULADDER Landing Page](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/ScreenGrabs/landingPage.png)
  
  ### Sign In
  ![EMULADDER Sign In](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/ScreenGrabs/loginImg.png)
  
  ### Sign Up
  ![EMULADDER Sign Up](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/ScreenGrabs/SignupImg.png)
  
  ### League Of Legends Page
  ![EMULADDER LOL Page](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/ScreenGrabs/lol1.png)
  ![EMULADDER LOL Page](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/ScreenGrabs/lol2.png)
  ![EMULADDER LOL Page](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/ScreenGrabs/lol3.png)
  ![EMULADDER LOL Page](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/ScreenGrabs/lol4.png)
  
  ### Contest Creation Page
  ![EMULADDER Contest Creation Page](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/ScreenGrabs/contestCreation1.png)
  
  ### Contest Drafting Page
  ![EMULADDER Contest Drafting Page](https://github.com/CapstoneUNCG2020/emuLadder/blob/master/documents/Images/ScreenGrabs/lolDrafting.png)
  
## How To Install
  To clone and run this application, you'll need [Git](https://git-scm.com), [Node.js](https://nodejs.org/en/download/) (which comes with [npm](http://npmjs.com)), [Angular](https://angular.io/guide/setup-local), and [Maven](http://maven.apache.org/) installed on your computer. From your command line:
  
  ```
  # Clone this repository
  $ git clone https://github.com/CapstoneUNCG2020/emuLadder
  
  # Front End Setup:
  
  # Go into the repository
  $ cd angular
  
  # Install dependencies
  $ npm install
  
  # Run the app
  $ ng serve -o
  
  # Back End Setup:
  
  # Go into the repository
  $ cd java
  
  # Run the service
  $ mvn spring-boot: run
  ```
  ### [Data Collection Service](https://github.com/CapstoneUNCG2020/Data-Collection)
  The Data Collection service is built upon the unofficial League of Legends API which is documented and maintained [here](https://vickz84259.github.io/lolesports-api-docs/).

## License
[![Open Source Love](https://badges.frapsoft.com/os/mit/mit.svg?v=102)](https://github.com/ellerbrock/open-source-badge/)
