Feature: E2E test

  Background:
    Given Page saucedemo is opened

    @E2E
  Scenario Outline: LogIn
    Given LogIn page is displayed with all elements
    When user is logged in with valid credentials <username> and <password>
    Then Main page with correct UI elements is displayed
      Examples:
        | username | password |
        | standard_user | secret_sauce |