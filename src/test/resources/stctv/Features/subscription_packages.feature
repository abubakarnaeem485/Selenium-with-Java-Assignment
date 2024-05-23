Feature: Subscription Packages Validation

  Scenario Outline: Validate subscription packages for different countries
    Given I navigate to the STC TV subscription page
    When I select the country "<country>"
    Then I should see the "<price1>" and "<currency1>" against "LITE" Plan A:
    And I should see the "<price2>" and "<currency2>" against "CLASSIC" Plan B:
    And I should see the "<price3>" and "<currency3>" against "PREMIUM" Plan C:

    Examples: 
      | country | price1 | currency1 | price2 | currency2 | price3 | currency3 |
      | KSA     |     15 | SAR       |     25 | SAR       |     60 | SAR       |
      | Kuwait  |    1.2 | KWD       |    2.5 | KWD       |    4.8 | KWD       |
      | Bahrain |      2 | BHD       |      3 | BHD       |      6 | BHD       |
