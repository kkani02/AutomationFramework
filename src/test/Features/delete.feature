Feature: Delete items in the basket
  As a user I should delete the items added in the basket

  @delete
  Scenario Outline: : verify deleting multiple items in the bag
    Given I open homepage "https://www.amazon.co.uk/" with title as "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more"
    When I click sign button
    And I enter username "tmtntesting@gmail.com"
    And I click continue
    And I enter password"Testing@22"
    And I click sign-In button
    And I click Go to Basket
    And I choose the item "<selectItem>" and click delete button
    Then I should able to see the items deleted in the basket and message displayed as "Shopping Basket"
    Examples:
      | selectItem                                             |
      | Delete Mens Womens Sunglasses Polarised UV Protection  |
      | Delete Levi&#39;s Men&#39;s SS Original HM Tee T-Shirt |
      | Delete GILDAN Men&#39;s Heavyweight Hooded Sweatshirt  |