@all
Feature: Account Page

  @accountpage

	@cbsnstream
  Scenario: C1503684"Selecting Account takes the user to their Account page"

    Given I navigate to the CBS Digital website
    When I click on sign in button
    And I enter the email and password in sign in page
    Then I observe Selecting Account takes the user to their Account page
