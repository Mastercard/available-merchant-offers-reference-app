# Available Merchant Offers Reference Implementation

#### Setup Pre-requisites:

IntelliJ IDEA (or any other IDE of your choice)

Maven 3.6 or later

JDK 1.8.0 or later

#### Mastercard Developers Account with access to Available Merchant Offers API. (Default STAGE Keys are configured for this project) 

#### If your editor is IntelliJ IDEA, it will have the Maven and JDK already with it.

#### Checkout the code from the repo. Import the code straight into your IDE: 
On IntelliJ IDEA: 
*File/New/Project From Version Control/* (Select GIt from version control dropdown)

Setup your signing keys (p12) in the application.properties if you dont want to use the default STAGE keys associated with this project 

#### Open Maven window:
 Click on *Lifecycle/Clean*
 
 Click on *Lifecycle/Install*
###### At this point all the maven dependencies are downloaded

#### Compile your source files:
 Click on *Lifecycle/clean*
 
 Click on *Lifecycle/compile*
 
#### Run AvailableOffersApplication.java
This will start up your local server. 

#### Go to your browser and type in *localhost:8080/* and work through the application 


#### Some insights while using the service
  *Could not run this service on Sandbox as the service is not configured properly in Sandbox. Works from STAGE though, however STAGE is    not stable all the time*
  
  *It returns a null pointer exception where no offers are found, should return a more meaningful error code or message Or even an empty list*
 
 *Offers API has Category Code as optional but looks to be a mandatory*   
