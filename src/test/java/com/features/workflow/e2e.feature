Feature: Verifying e-commerce Search to Order item functionality

  Scenario: user should be able to place an order
    Given user is on index page url as "https://automationteststore.com/" and page title as "A place to practice your automation skills!"
    When user clicks on search button
    And user enters product name as "keyword"
    And user should be able to see search result items
    And user adds products to the cart
    And user verifies the product item by item image, unit price, quantity and grand total
    And user should be able to increase and remove item from cart
    And user clicks on the Check out button
    And user is on checks Customer Shipping Address, Method,Order Summary, Coupon and Total
    And user should be able to edit the cart
    And user verifies the unit price against total price
    And user clicks on continue button
    And user confirms email, Shipping Address, Method, Billing and total
    And user should be able to edit the cart, Shipping,Method and Billing Address
    And user is given the option to register or login or as a guest
    And user registers and login as a new user
    And user enters payment details and clicks on place order button
    And user is presented with a purchase confirmation page.
    Then user gets an order number and thank message with first name displayed
    And user order confirmation page is populate with print icon, item image total price and continue shipping button
    And user clicks on continue and logout button
    Then user is back to home page
