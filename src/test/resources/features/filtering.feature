Feature: filtering functionality of craigslist

  Scenario: filtering test

    Given user goes to the main page "url"
    Then user clicks on the link "product"
    Then user types in the make and model text box "bmw"
    Then user types in the miles text box "150"
    Then user types in the ZIP text box "zipCode"
    Then user types in the year text box "2005"
    When the filtered options of "product" appear on the page
    Then year of the selected motorcycle must be greater or equal to "2005"



