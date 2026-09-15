Feature: Bank

  Background:
    Given go to "https://parabank.parasoft.com/parabank/index.htm"
  Scenario: Bank Account
    When Click the register button
    And Signing up with FirstName "hmida", LastName "hmida", Address "rue oued sbou", city "sala", state "rabat", zipcode "11920", phone "02938203", SSN "2983232", Username "hmidamagana", password "9ri3amagana"
    And submit register
    And verify the welcome message
    And Click LogOut
    And verify title login "Customer Login"
    And Enter Username "hmidamagana" and password "9ri3amagana"
    Then Verify title "Accounts Overview"