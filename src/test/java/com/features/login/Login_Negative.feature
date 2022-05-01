Feature: Login Page - User Unsuccessful Login attempts

  @NegativeLogin
  Scenario Outline: User should NOT be able to login with invalid credentials
    Given user is on index page url as "<Url>" and page title as "A place to practice your automation skills!"
    When user clicks on Login Or Register link
    And user should be on account login page with option to login as "Returning Customer" or create an Account as "I am a new customer."
    And user enters wrong combination of both login Name as "<loginName>" or password as "<password>"
    And user clicks on Login_Button
    Then User gets error message as "<loginValidationErrorMessage>" and still on Home page title as "<pageTitle>"

    Examples:
      | Url                              | loginName       | password      | loginValidationErrorMessage                  | pageTitle     |
      | https://automationteststore.com/ | WrongLoginName  | Manchester1   | Error: Incorrect login or password provided. | Account Login |
      | https://automationteststore.com/ | datastudioplace | WrongPassword | Error: Incorrect login or password provided. | Account Login |
      | https://automationteststore.com/ | WrongLoginName  | WrongPassword | Error: Incorrect login or password provided. | Account Login |
      | https://automationteststore.com/ |                 |               | Error: Incorrect login or password provided. | Account Login |
      | https://automationteststore.com/ | datastudioplace |               | Error: Incorrect login or password provided. | Account Login |
      | https://automationteststore.com/ |                 | Manchester1   | Error: Incorrect login or password provided. | Account Login |