#Author: rojal@bajratechnologies.com
@regressiontest
Feature: Feature to test Google search functionality

  @smoketest
  Scenario Outline: Validate Google search is working
    Given browser is open
    And user is on google search page
    When user enters a <text> in search box
    And hits enter
    Then user is navigated to search results page <text>

    Examples: 
      | text  |
      | Apple |

  Scenario Outline: Validate Google search is working
    Given browser is open
    And user is on google search page
    When user enters a <text> in search box
    And hits enter
    Then user is navigated to search results page <text>

    Examples: 
      | text |
      | Ball |
      | Cat  |
