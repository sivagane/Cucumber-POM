Feature: FreeCrm Application Test

#Scenario: Testing the FreeCRM Application - HomePage
#Then User enters the hompage checks the title and logo
#
#Scenario: Testing the FreeCRM Application - ContactsPage
#Then User enters the new Contacts page verify title and enters the contact details
#
#Scenario: Testing the FreeCRM Application - DealsPage
#Then User enters the new Deals page and verifys title and enters the deals details

Scenario: Testing the FreeCRM Application
Given User Login to the FreeCRM Application
Then User enters the hompage checks the title and logo
Then User enters the new Contacts page verify title and enters the contact details
Then User enters the new Deals page and verifys title and enters the deals details
