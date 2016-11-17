Feature: Login

   Scenario: Successful Login
      Given the LDS homepage
      When I navigate to the login page
      And I login with
        |username  |password|
        |ok        |ok      |
        |antonyrmrz|1234    |
      Then the page title should be "LDS - Home"

   Scenario: Not Successful Login
       Given the LDS homepage
       When I navigate to the login page
       And I login with
        |username  |password|
        |ok        |od      |
        |antonyrmrz|1231    |
      Then the page should be the same
      
    Scenario: Not Successful Login
       Given the LDS homepage
       When I navigate to the login page
       And I login with
        |username|password|
        |        |        |
      Then the page should be the same
    Scenario: Not Successful Login
       Given the LDS homepage
       When I navigate to the login page
       And I login with
        |username  |password|
        |ok        |        |
        |antonyrmrz|        |
      Then the page should be the same
