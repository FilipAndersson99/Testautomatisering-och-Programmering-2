Feature: Register user
  Background:
    Given I navigate to the website

  Scenario: I register a user
    Given I enter the e-mail address "Email"
    And I enter the user name "Name"
    And I enter the password "Password"

    When I press the register button

    Then A user is registered