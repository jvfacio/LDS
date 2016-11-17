Feature: Login

   Scenario: Successful Login
      Given the LDS homepage
      When I navigate to the login page
      And I login with
        |username|ok|
        |password|ok|
      Then the page title should be "LDS - Customer Details"

   
