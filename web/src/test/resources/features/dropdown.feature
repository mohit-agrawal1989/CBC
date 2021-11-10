@all
Feature: Dropdown

  @dropdown

  Scenario: C1503681 "User name dropdown menu contains Account, Help and Sign Out items"
    Given I navigate to the CBS Digital website
    When I click on sign in button

    And I enter the email and password in sign in page
    Then I observe User name dropdown menu contains Account, Help and Sign Out items