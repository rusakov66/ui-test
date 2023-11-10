Feature: Открыть браузер

  Scenario: Открыть сайт в Chrome
    Given User choose browser "chrome"
    And User choose site bomba
    When User load page "https://bomba.md"
    When User is looking 'TV' on site 'bomba'
    Then Page is loaded

  Scenario: Открыть сайт в Chrome
    Given User choose browser "firefox"
    When User load page "https://maximum.md"
    When User is looking 'TV' on site 'maximum'
    Then Page is loaded
