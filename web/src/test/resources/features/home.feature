@all
Feature: Home

	@home, @smoke
	Scenario Outline: C1503714 Home Page
		Given I navigate to the CBS Digital website

		And I navigate to the CBS Digital website
		Then I am at the Home page

		Examples:
			|userType|
			|Anonymous|
			|Registered|
			|Ghost|
			|AuthZ|

	@home
	Scenario: C1503715 P+ user can't Sign In on cbs.com
		Given I navigate to the CBS Digital website
		When I update access as "Anonymous"
		And I navigate to the CBS Digital website
		And I go to the sign in page
		And I enter the email and password as a P+ user
		And I click continue
		Then Error message Invalid email and or password appears above text boxes

	
	
	