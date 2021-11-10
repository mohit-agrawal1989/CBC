@all
Feature: Displays

  @displays

  Scenario: C1503682 "user name on the dropdown menu displays first name for registered or TV Provider w/Name user"
    Given I navigate to the CBS Digital website
    When I click on sign in button

    And I enter the email and password in sign in page
    Then I observe User name dropdown menu displays first name for registered user