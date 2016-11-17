Feature: Register

Scenario: Successful Register
Given the LDS homepage
When I navigate to the register page 
And I enter Nickname And check if it is unique
And I enter Password 
And I enter First Name
And I enter last Name
And I enter Address
And I enter PhoneNumber
And I enter Salary And i should be able to enter only numbers
And I click Submit
Then i should be able to view the customer details page

Scenario: Not successful Register
Given the LDS homepage
When I navigate to the register page 
And I enter Nickname And check if it is unique
And I enter Password 
And I enter First Name
And I enter last Name
And I enter Address
And I enter PhoneNumber
And I enter Salary And i should be able to enter only numbers 
And I enter negative values
And I click Submit
Then i should be not able to register successfully


