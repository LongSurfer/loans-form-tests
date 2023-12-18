Feature: Testing loan application form

  Background: We are on the main page of the website
    Given Open the website "https://testfortesting.online-loans.ph"

  Scenario: The loan amount cannot be set less than 1000 PHP
    When Make sure the loan amount slider is displayed
    And The default amount should be '4,000' PHP
    And Move the slider all the way to the left and press the minus button
    Then Make sure that the amount is displayed and is equal to '1,000' PHP


  Scenario: The warning text will be displayed in the empty fields of the application form
  after clicking the 'Get First Loan' button
    When Click on the 'Get First Loan' button
    Then Make sure that in the fields First Name, Middle Initial, Last Name and Mobile phone the warning 'This field is required' is appeared.


  Scenario: The "Get First Loan" button should be disabled if the amount exceeds 7,000 PHP
    When Make sure the loan amount slider is displayed
    And The default amount should be '4,000' PHP
    And Increase the loan amount to '8,000' PHP
    Then Make sure the 'Get First Loan' button is disabled