@all
Feature: Schedule

	@schedule, @smoke
	Scenario Outline: C1503925 Date Drop Down - Hover
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click on Schedule
		And I hover over the date drop down
		Then the date drop down window appears

		Examples:
			|userType|
			|Anonymous|
			|Registered|
			|Ghost|
#			|AuthZ|

	@schedule
	Scenario Outline: C1503927 Show Poster Validation
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click on Schedule
		And I click on the first available show and land on the right page

		Examples:
			|userType|
			|Anonymous|
			|Registered|
			|Ghost|
#			|AuthZ|

	@schedule
	Scenario Outline: C1503927 Show Poster Validation
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click on Schedule
		And I click on the first available show name and land on the right page

		Examples:
			|userType|
			|Anonymous|
			|Registered|
			|Ghost|
#			|AuthZ|

	@schedule
	Scenario Outline: C1503927 Watch Live Tv button is not working on the schedule page for non-subscribers
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click on Schedule
		And I am at the Schedule page
		And I click on Watch Live TV
		Then I am at the Live TV local locked page

		Examples:
			|userType|
			|Anonymous|
			|Registered|

	@schedule
	Scenario Outline: C1503927 Watch Live Tv button is working on the schedule page
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click on Schedule
		And I am at the Schedule page
		And I click on Watch Live TV
		Then I am at the Live TV local page

		Examples:
			|userType|
			|Ghost|
#			|AuthZ|
	
	