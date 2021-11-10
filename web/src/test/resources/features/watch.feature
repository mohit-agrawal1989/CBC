@all
Feature: Watch Page

  @watchpage

  Scenario: C1503674 "Selecting Full Episodes takes the user to Watch page"
    Given I navigate to the CBS Digital website
    Then I select Shows page, select a show, and select Full Episodes and observe watch page.

