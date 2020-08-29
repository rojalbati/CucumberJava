#Author: rojal@bajratechnologies.com
@regressiontest
Feature: Feature to test Login Functionality

  @smoketest
  Scenario Outline: Log in using correct email and correct password
    Given user is on login page
    When user enter <email> and <password>
    And click login button
    Then user is redirected to Landingpage
    And user is notified of successfull login

    Examples: 
      | email           | password |
      | email@email.com | password |

  Scenario Outline: Log in using incorrect email and password combination
    Given user is on login page
    When user enter <email> and <password>
    And click login button
    Then error message is shown

    Examples: 
      | email                    | password          |
      | incorrectemail@email.com | password          |
      | email@email.com          | incorrectpassword |

  Scenario Outline: Log in using empty email and empty password
    Given user is on login page
    When user enter <email> and <password>
    And click login button
    Then validation error message is shown

    Examples: 
      | email | password |
      |       |          |
