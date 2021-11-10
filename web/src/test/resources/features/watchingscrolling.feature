@all
Feature: Watching Scrolling

  @watchingscrolling

  Scenario: C1503730  "Keep Watching - Scrolling"

    Given I navigate to the CBS Digital website
    When I click on sign in button
    And I enter the email and password in sign in page
    Then I observe Thumbnails within carousel scroll through