# AnswerAutomationTest
Guidance and reference sites,

Install Java JDK and set path

Install MAVEN and set path

Install IntelliJ 

https://www.jetbrains.com/idea/download/#section=windows


_______ __**Notes for self:**__________

**Final solution to be implemented as per below**

Environment - use Eclipse? use I?

Test Case 1: Check login attempts

 

In TDD/BDD

 

Given I am a registered user on the <http://the-internet.herokuapp.com> site

And I navigate to the <login> page

When I enter <username>

And I enter <password>

And I click <Login Button>

Then the correct <outcome> is shown

 

Test variables: Username|Password|Outcome

(Note: Both username and password are case sensitive so test data to check for this)

 

 

AnswerAutomationTest

com.herokuapp.pages

com.herokuapp.tests

 

**Using POM**

 

homepage-

loginPageLink

 

loginPage-

When I enter <username>

And I enter <password>

And I click <Login Button>

AlertBar(nothing to interact with other than alert is displayed)

 

secureAreaPage

-nothing to interact with other than page is displayed

AlertBar(nothing to interact with other than alert is displayed)

 

BaseTests methods

-Open browser

-Close Browser

-catch errors and exceptions

-log and record actions/steps

-generate execution report

take screenshots

 

 

Test scenarios/conditions plus corresponding outcomes (i.e pass/fail):

If test variables combination is: tomsmith|SuperSecretPassword!|logged in message (Note:and secure area page? do i need to check the navigation to this page or just the successful login message?)

= pass


code should set chromedriver path, instantiate driver, use driver to assign login variables, check login variables assigned = registered details (i.e assert equals),

Case 1 will not equal

Case 2 will not equal

Case 3 will equal

so need to run same method in test case but passing different values login base method, case1/case2/case/ methods

 

 

Or If test variables combination is: Not='tomsmith'|SuperSecretPassword!|wrongusername message (Note: and does not navigate to secure area page, do i need to check the navigation to this page or just the unsuccessful login message?)

=pass

Or If test variables combination is: Not='tomsmith'|Not='SuperSecretPassword!'|wrongusername message (Note: and does not navigate to secure area page, do i need to check the navigation to this page or just the unsuccessful login message?

)

=pass

Or If test variables combination is: tomsmith|SuperSecretPassword!|wrongpassword message (Note: and does not navigate to secure area page, do i need to check the navigation to this page or just the unsuccessful login message?)

pass

 

 

 

 

Goal: run test with all input test data combinations

If all test result = pass

Then overall test passes

Else

overall test fails

 

 

Test Case 2: Check infinite scroll through page content

 

Given I have navigated to the <Infinite Scroll> page

When I click the <scroll bar>

And I <move> the scroll bar

Then the correct <page section> is shown

 

Test Variables: the scroll bar location and corressponding content area?

(Note are there keyboard shortcuts to test when scrolling)

 

Test scenarios/conditions plus corresponding outcomes (i.e pass/fail):

If the page is at the topmost (non blank content), then i can only move the bar downwards

=pass

And If the bar is move down to bottom once? then corresponding x page section is shown.

=pass

And If the bar is move down to bottom second time? then corresponding x page section is shown.

=pass

 

Goal is to run all conditions above and if all result = pass

Then test passes

Else fails

 

 

Test Case 3: Check key presses

 

Given I have navigated to the <Key Presses> page

When I click the <input box>

And I type a <key>

Then the correct <key> is shown

 

Test Variables: lowercase letter, uppercase letter, number, special char which uses shift

 

Test scenarios/conditions plus corresponding outcomes (i.e pass/fail):

If the key pressed = key shown

=pass

 

Then pass

Else fail

 
 
