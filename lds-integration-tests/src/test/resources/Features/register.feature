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


|title|fn   |ln        |em             |pass|add           |city       |state     |zc    |country      |mobile    |aliasadd   |
|mr   |Pedro|Picapiedra|roca@gmail.com |1234|bajo la piedra|Lancaster  |California|089992|United States|2223332211|pedropiedra|
#|mr   |user |userln		 |user@gmail.com |1234|user add      |NY				 |Manhatan  |099999|United States|2223335554|sodijfois  |
#|mr   |user1|userln1	 |user1@gmail.com|1234|user add      |NY				 |Manhatan  |099999|United States|2223335554|sodijfois  |
#|mr   |user2|userln2	 |user2@gmail.com|1234|user add      |NY				 |Manhatan  |099999|United States|2223335554|sodijfois  |