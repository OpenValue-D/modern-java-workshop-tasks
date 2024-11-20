# Ktor Workshop
In this workshop we want to build a ktor application from scratch. We want to use Exposed to connect to a database and get some more Kotlin experience.

The application we want to write is a Rest API which validates if a given email address might be valid. It does so be checking if it contains an @ and if the top level domain is one officially listed by the IANA.  
The case should not matter.

The following emails addresses are valid according to our definition:
- mail@com
- mail@example.com
- mail@subdomain.example.com
- mail@CoM

These are not valid
- com
- mail@some-random-text
- mail@some.random-text

Use Kotlin functionality over Java where possible, e.g. functional API, listOf, ...

## 1. Start a new Project
Use the initializer to start a new project: https://start.ktor.io/settings  
Apply the following settings:
- chose Maven as build system
- add the exposed dependency
- leave all other settings as is

## 2. Simple Validation
At this point we do not want to introduce the database yet. Leave all the database stuff as is. We focus on getting the validation started, even if it means we will not use the database for now.

Create a class which holds the email address and the specified TLD which is extracted when the object is created.
Use a [companion object](https://kotlinlang.org/docs/object-declarations.html#companion-objects) to create a static initializer like `MailAddress.of("mail@address")`.  
Write tests for your MailAddress class.

Add an endpoint which parses the email address to your new class. The endpoint should then call a ValidationService which checks if a TLD is present.  
This is the only validation for now.

Extend the Application test, to call your endpoint and check if the email validation works as expected

## 3. Top Level Domain Validation
In this part we also want to validate if the TLD of the email address is valid.

### 3.1 Add a client to download TLDs
Add a client according to this documentation: https://ktor.io/docs/client-create-new-application.html  
Though we do not want to use the CIO client here, but the apache5 one.

The list with all the valid top level domains can be accessed here: https://data.iana.org/TLD/tlds-alpha-by-domain.txt

Write the client as a [Singleton in Kotlin](https://kotlinlang.org/docs/object-declarations.html).  
You may want to add a main method to print the result, so you can test it locally.

### 3.2 Validation with TLDs
Adjust the pre generated exposed classes and methods so that you are able to save the TLDs in the database.  
Extend the validation with the comparison of the TLDs.

Extend the Application test, to call your endpoint and check if the email validation works as expected

## 4. Bulk validation endpoint
Create another endpoint which accepts a list of email addresses 

Use `Json.encodeToString()` to turn an object into Json. You can simply compare the results as Strings or parse them back.

## Additional Tasks
If you manage to still have time you might want to add checks for these lists: https://github.com/willwhite/freemail

Add an endpoint which unifies all these checks.