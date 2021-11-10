@all
Feature: Site Footer

	@sitefooter, @smoke, @sitefooter2
	Scenario Outline: C1504010 Clicking on Help redirects user to the FAQ page
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click Shows
		And I am at the Shows page
		And I navigate to the Site Footer on the Shows page
		And I click on Help-Contact Us on the site footer
		And I tab to the Help-Contact page
		Then I am at the Help-Contact page

		Examples:
			|userType|
			|Anonymous|
			|Registered|
			|Ghost     |
#			|AuthZ     |

	@sitefooter, @smoke
	Scenario Outline: C1504012 Clicking on Privacy Policy redirects the user to the privacy policy
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click Shows
		And I am at the Shows page
		And I navigate to the Site Footer on the Shows page
		And I click on Privacy Policy on the site footer
		And I tab to the Privacy Policy page
		Then I am at the Privacy Policy page

		Examples:
			|userType|
			|Anonymous|
			|Registered|
			|Ghost     |
#			|AuthZ     |

	@sitefooter, @smoke
	Scenario Outline: C1504011 Clicking on Terms of Use redirects user to the corresponding Terms of Use page
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click Shows
		And I am at the Shows page
		And I navigate to the Site Footer on the Shows page
		And I click on Terms of Use on the site footer
		And I tab to the Terms of Use page
		Then I am at the Terms of Use page

		Examples:
			|userType|
			|Anonymous|
			|Registered|
			|Ghost     |
#			|AuthZ     |

	@sitefooter, @smoke
	Scenario Outline: C1504013 Clicking on Cookies redirects the user to the cookies page.
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click Shows
		And I am at the Shows page
		And I navigate to the Site Footer on the Shows page
		And I click on Cookies on the site footer
		And I tab to the Cookies page
		Then I am at the Cookies page

		Examples:
			|userType|
			|Anonymous|
			|Registered|
			|Ghost     |
#			|AuthZ     |

	@sitefooter, @smoke
	Scenario Outline: C1504014 The copyright year and CBS Interactive are displayed
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click Shows
		And I am at the Shows page
		And I navigate to the Site Footer on the Shows page
		Then the copyright reads properly

		Examples:
			|userType|
			|Anonymous|
			|Registered|
			|Ghost     |
#			|AuthZ     |