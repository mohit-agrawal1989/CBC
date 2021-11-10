@all
Feature: Keep Watching

  @keepwatching

  Scenario: C1503727 "Keep Watching"

    Given I navigate to the CBS Digital website
    When I click on sign in button
    And I enter the email and password in sign in page
  And I observe Continue Watching section with blue Progress Bar displayed underneath thumbnail