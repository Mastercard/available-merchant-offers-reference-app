# Available Merchant Offers Reference Implementation

#### Setup Pre-requisites:

IntelliJ IDEA (or any other IDE of your choice)

Maven 3.6 or later

JDK 1.8.0 or later

#### Mastercard Developers Account with access to Available Merchant Offers API. (Default Keys are configured for this project) 

#### If your editor is IntelliJ IDEA, it will have the Maven and JDK already with it.

#### Checkout the code from the repo. Import the code straight into your IDE: 
On IntelliJ IDEA: 
*File/New/Project From Version Control/* (Select GIt from version control dropdown)

Setup your signing keys (p12) in the application.properties if you dont want to use the default keys associated with this project 

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


*Some insights from using the service*
 It returns a null pointer exception where no offers are found. 
 Should return a more meaningful error code code or message Or even a empty list
 Offers API has Category Code as optional but looks to be a mandatory   
