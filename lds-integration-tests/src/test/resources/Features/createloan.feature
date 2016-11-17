Feature: This feature is to create automated tests for the creation of the loan 

Background:
      Given the LDS homepage
      When I navigate to the login page
      And I login with loan user
        |username  |password|
        |ok        |ok      |
      Then the page title should be "LDS - Customer Details"


Scenario: Successful loan creation
    Given the LDS Customer page And I click the Create Loan button
    And the page title should be "LDS - Create a Loan"
    And I select Type "Mortgage" and verify it
    And I select Loan Period 10 years and verify it
    And I enter The porcentage of interest 10.0
    And I enter the total amount 999999
    And I click submit button on the loan page
    Then the page title should be "LDS - Loan Report"

