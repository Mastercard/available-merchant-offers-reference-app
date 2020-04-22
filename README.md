## Available Merchant Offers Reference Implementation

This is a reference application that demonstrates how Available Merchant Offers APIs can be used. 
Please see here for details on the APIs: [Mastercard Developers](https://developer.mastercard.com/product/avail-merchant-offers). 
This application requires consumer key and .p12 file as received from [Mastercard Developers](https://developer.mastercard.com/dashboard).

#### Setup Pre-requisites:

 - Maven 3.6 or later

 - JDK 1.8.0 or later

 - Spring Boot 2.2+  

 - A text editor or IDE

#### If your IDE is IntelliJ IDEA, you may not need to download the Maven and JDK 

#### Checkout the code onto your local machine

#### Configuration
#### If you do not want to use the default STAGE keys associated with this project. 
 - Setup account at [Mastercard Developers](https://developer.mastercard.com/account/sign-up)   
 - Create a project & download signing key for the Avail Merchant Offers API. It will download a zip file.  
 - Select .p12 file and copy it to `src\main\resources` folder.
 - Open `${project.basedir}/src/main/resources/application.properties` and set these parameters: [consumerKey, signingKeyFilePath, keyalias, keystorepassword]. Replace 'stage' with 'sandbox' in the basepath parameter 

#### Build and Execute
#### Running outside of IDE, from command line
 - mvn clean install

 - java -jar target/AvailMerchantOffersReferenceImpl*

Go to your browser: *localhost:8080/* and work through the application 

#### Running on IntelliJ IDE. 
 - On IntelliJ IDEA: *File/New/Project From Version Control/* 

 - Open Maven window to generate dependencies: Click on *Lifecycle - Clean &  Install*
 Compile: *Lifecycle - Clean & compile*
 
 - Run *AvailableOffersApplication.java*
 
This will start up your local server at port 8080 

Go to your browser: *localhost:8080/* and work through the application 

#### Some insights while using the service
 *Could not run this service on Sandbox as the service is not configured properly in Sandbox. Works from STAGE though, however STAGE is not stable all the time*
  
 *It returns a null pointer exception where no offers are found, should return a more meaningful error code or message Or even an empty list*
 
 *Offers API has Category Code as optional but it looks to be a mandatory*   
