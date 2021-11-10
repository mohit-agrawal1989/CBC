@all
Feature: Watching Click

  @keepwatching

  Scenario: C1503729 "Keep Watching - Click"

    Given I navigate to the CBS Digital website
    When I click on sign in button
    And I enter the email and password in sign in page
    Then I observe Requested Shows video episode resumes