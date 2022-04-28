Feature: Verification of Registration functionality

  @RegistrationFunctionality
  Scenario: user should be able to Register with valid credentials
    Given user is on index page url as "https://automationteststore.com/" and page title as "A place to practice your automation skills!"
    When user clicks the LoginOrRegister link
    And user should be on account login page with option to login as "Returning Customer" or create an Account as "I am a new customer."
    And user verifies register account radio button is checked and clicks on Continue button
    And user is on account create page and verifies page heading as "CREATE ACCOUNT" and page Url contains "?rt=account/create"
    And user enters email and personal details in "Your Personal Section"
    And user enters all the address details as "Your Address"
    And user enters all the login requested details as "Login Section"
    And user subscribed to Newsletter and check on Yes
    And user ticks on Privacy Policy radio button and create account button
    Then user gets success confirmation message as "Your Account Has Been Created"
    And user clicks on Continue Shipping button
    And user is on home page and presented with welcome message as "Welcome back yourFirstName"
    When user clicks on SignOut button
    Then user is on index page url as "https://automationteststore.com/" and page title as "A place to practice your automation skills!"