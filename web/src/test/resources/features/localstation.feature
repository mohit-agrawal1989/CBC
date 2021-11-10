@all @gaagg1
Feature: Local channel stream

  @localstation

  Scenario: C1503676 "Selecting CBS (Local Station) opens local channel stream (TV provider-linked account only)"

    Given I navigate to the CBS Digital website

     When I select Tv provider and enter the email and password for credentials

   Then I select livetv options and click on local station and obseve the stream