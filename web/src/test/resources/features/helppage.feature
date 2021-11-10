@all
Feature: Help Page

  @helppage


  Scenario: CC1503685"Selecting Help takes the user to the CBS Help page"

    Given I navigate to the CBS Digital website
    When I click on sign in button

    And I enter the email and password in sign in page
  Then  I observe Selecting Help takes the user to the CBS Help page