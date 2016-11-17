Feature: Login

   Scenario: Successful Login
      Given the LDS homepage
      When I navigate to the login page
      And I login with
        |username  |password|
        |ok        |ok      |
        |antonyrmrz|1234    |
      Then the page title should be "LDS - Home"

   
