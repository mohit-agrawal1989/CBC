@all
Feature: Sign Out

  @signout


  Scenario: C1503686"Selecting Sign Out signs the user out"

    Given I navigate to the CBS Digital website
    When I click on sign in button

    And I enter the email and password in sign in page
    Then I observe Selecting Sign Out signs the user out