Feature: Register

Scenario: Successful Register
Given the LDS homepage for the loan delivery system
When I navigate to the register page 
And I enter Nickname with
      | hola   |    
And I enter Password with
      |abc123  |
And I enter First Name with
      |jose     |
And I enter last Name with
      |fran|
And I enter Address with
      |Saltillo| 
And I enter PhoneNumber with
      |7133578842 | 
And I enter Salary with 
      |35000 |
And I click Submit
Then I should be able to view the customer details page 
And I should see Account created successfully

Scenario: Successful Register
Given the LDS homepage for the loan delivery system
When I navigate to the register page 
And I enter Nickname with
      | hola   |    
And I enter Password with
      |abc123  |
And I enter First Name with
      |jose     |
And I enter last Name with
      |fran|
And I enter Address with
      |Saltillo| 
And I enter PhoneNumber with
      |7133578842 | 
And I enter Salary with 
      |-35000 |
And I click Submit
Then I should not be able to register successfully





			 