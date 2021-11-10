@all
Feature: Selecting Read

  @selectingread


  Scenario: C1503661 "Selecting Read redirects the user to Help Center"

    Given I navigate to the CBS Digital website
    When I click on sign in button

    And I enter the email and password in sign in page
    Then I observe Selecting Account takes the user to their Account page
     And  I observe Selecting Read redirects the user to Help Center