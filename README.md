## Available Merchant Offers Reference Implementation

This is a reference application that demonstrates how Available Merchant Offers APIs can be used. 
Please see here for details on the APIs: [Mastercard Developers](https://developer.mastercard.com/product/avail-merchant-offers). 
This application requires consumer key and .p12 file as received from [Mastercard Developers](https://developer.mastercard.com/dashboard).

#### Setup Pre-requisites:

Maven 3.6 or later

JDK 1.8.0 or later

Spring-framework  

IntelliJ IDEA (or any other IDE of your choice)

Mastercard Developers Account with access to Available Merchant Offers API. (By default STAGE Keys are configuredto run with this project) 

#### If your editor is IntelliJ IDEA, you will not need to download the Maven and JDK 

#### Checkout the code from the repo. Import the code into your IDE: 
On IntelliJ IDEA: 
*File/New/Project From Version Control/* (Select GIt from version control dropdown)

If you do not want to use the default STAGE/Sandbox keys associated with this project. 
 - Setup account at [Mastercard Developers](https://developer.mastercard.com/account/sign-up)   
 - Download signing key for the project. It will download a zip file.  
 - Select .p12 file and copy it to `src\main\resources` folder.
 - Open `\src\main\resources\application.properties` and set these parameters: [consumerKey, signingKeyFilePath, keyalias, keystorepassword] 

#### Running on IntelliJ IDE. 
 Open Maven window: Click on *Lifecycle/Clean & Lifecycle/Install*
 
#### Compile your source files:
 Click on *Lifecycle/clean & Lifecycle/compile*
 
#### Run AvailableOffersApplication.java
This will start up your local server at port 8080 

#### Go to your browser and type in *localhost:8080/* and work through the application 

## Running outside of IDE, from command line
mvn package

java -jar target/AvailMerchantOffersReferenceImpl*

#### Some insights while using the service
 *Could not run this service on Sandbox as the service is not configured properly in Sandbox. Works from STAGE though, however STAGE is not stable all the time*
  
 *It returns a null pointer exception where no offers are found, should return a more meaningful error code or message Or even an empty list*
 
 *Offers API has Category Code as optional but it looks to be a mandatory*   
