Feature: Basket
  As a user I should add products to bag

  @basket
  Scenario Outline: Verify adding multiple items to bag
    Given I open homepage "https://www.amazon.co.uk/" with title as "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more"
    When I click sign button
    And I enter username "tmtntesting@gmail.com"
    And I click continue
    And I enter password"Testing@22"
    And I click sign-In button
    And I do search for "<searchOption>"
    And I select the product "<selectOption>"
    And I select the size and colour
    And I click Add to Basket
   #Then I should be able to see the product added on the basket

    Examples:
      | searchOption | selectOption                                                 |
      | hoodie       | Heavyweight Hooded Sweatshirt Hoodie                         |
      | t-shirt      | Men's Ss Original Hm Tee T-Shirt                             |
      | sunglasses   | Mens Polarised Sunglasses 100% UV Protection Mens Sunglasses |