Feature: Login

   Scenario: Successful Login
      Given the LDS homepage
      When I navigate to the login page
      And I login with
        |username  |password|
        |ok        |ok      |
        |antonyrmrz|1234    |
      Then the page title should be "LDS - Login"
      
    Scenario: Not Successful Login with no credentials
       Given the LDS homepage
       When I navigate to the login page
       And I login with the values I should get an error
        |username|password|
        |        |        |
      Then the page title should be "LDS - Login"

    Scenario: Not Successful Login with with no password
       Given the LDS homepage
       When I navigate to the login page
       And I login with the values I should get an error
        |username  |password|
        |ok        |        |
      Then the page title should be "LDS - Login"
