Feature: E2E test

  Background:
    Given Page saucedemo is opened

    @E2E
  Scenario: LogIn
    Given LogIn page is displayed with all elements
    When user is logged in with valid credentials "standard_user" and "secret_sauce"
    Then Main page with correct UI elements is displayed
