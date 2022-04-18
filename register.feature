Feature: Register user
  Background:
    Given I navigate to the website

  Scenario: I register a user
    Given I enter the e-mail address "Email"
    And I enter the user name "Name"
    And I enter the password "Password"

    When I press the register button

    Then A user is registered

  Scenario:
    Given I enter the e-mail address "Email"
    And I enter the user name "LongName"
    And I enter the password "Password"

    When I press the register button

    Then I receive an error

  Scenario:
    Given I enter the e-mail address "Email"
    And I enter the user name "UsedName"
    And I enter the password "Password"

    When I press the register button

    Then I receive an error

  Scenario:
    Given I enter the user name "Name"
    And I enter the password "Password"

    When I press the register button

    Then I receive an error
