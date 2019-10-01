Feature: Automated End2End test
  
  Discription: The purpose of the feature is to test End 2 End integration

  Scenario Outline: Customer places an order by plurchasing an item from search
    Given user goes to Home Page
    And he clicks the search icon
    And he types shoes in the enter text field
    And searches for description and item and price
    And chooses to buy the first item
    And clicks on cart link
    And user clicks proceed to checkout
    And enters personal details "<firstname>" and "<lastname>" and "<address>" and "<town>" and "<postcode>" and "<phone>"and "<email>"   on checkout Page
    And place the order
    Then user confirms seeing order details

    Examples: 
      | firstname | lastname | address           | town       | postcode | phone       | email                   |
      | chris     | ovie     | 3 orton buildings | london     | br1 4rd  | 07654323675 | hristophodibo@gmail.com |
      | peter     | brown    | 4 horse road      | manchester | mn4 6yt  | 07564536754 | peter56@yahoo.com       |
     # | john      | brown    | 34 calm st        | leicester  | le10 8uh | 07234566759 | john67@hotmail.com      |
