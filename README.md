# XENIOO TEST AUTOMATION FRAMEWORK
* XeniooTAF

### Stack of used technologies :

    - Maven
    - Java 16
    - Selenium Webdriver 4.21
    - JUnit 5
    - RestAsured

### Required software

* To install Test Automation Framework Java 16 is
  required: [Java JDK 16 (64-bit version)](https://adoptopenjdk.net/releases.html?variant=openjdk16&jvmVariant=hotspot)
  ;
* To effectively use this Test Automation Framework, following IDE is
  recommended: [Intellij IDEA Community Edition](https://www.jetbrains.com/idea/download/download-thanks.html?code=IIC)
  ;
* Install **`Lombok`** IDEA plugin;
* Set up annotation
  processing `File` > `Settings` > `Build Execution Deployment` > `Compiler` > `Annotation Processors`
  ; and set `enable annotation processing` checkbox

### VM Options

The default browser is set to Chrome
* Use [ -DbrowserName=firefox ] to switch the browser to Firefox
* Use [ -DbrowserName=headless ] to switch the browser to Chrome headless mode

The Default base URL is https://luckybandit.club.test-delasport.com
* Use[ -DbaseURL=https://luckybandit.club.test-delasport.com ] to run tests against test environment
-To run tests against Test env on Firefox browser, open the Edit Configuration window and add the following parameters in VM options: -DbrowserName=firefox -DbaseURL=https://test.xenioo.com

### Maven Run

* mvn test - runs the framework with the default options
* mvn test -DbaseURL=https://luckybandit.club.test-delasport.com - runs the framework against Test env
* mvn test -DbrowserName=firefox runs the framework on Firefox