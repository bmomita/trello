Feature: Login into account

 Scenario Outline: As a valid user of the site
    Given I access the homepage
    When I enter the Username <username> and the Password <password> and I press the Login button to log into my account
    Then I verify that I am logged into my account by checking that the username is displayed in the navigation bar in the right corner of the application by using XPath selector

  Examples:
    | username | password |
    | Admin    | admin123 |

  Scenario Outline: As an invalid user of the site
    Given I access the homepage
    When I enter the Username <username> and the Password <password> and I press the Login button to log into my account
    Then I verify that I am that an appropriate message is displayed for invalid credentials

    Examples:
      | username | password |
      | Adminnn    | admihggh123 |