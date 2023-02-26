Feature: invalid durumda

  @invalidlogin
  Scenario Outline: gecersiz sifre ile login olamaz
    Given Kullanici login sayfasina gider
    And hatali "<username>" ve "<sifre>" girer
    Then login olmak icin butona tiklar
#    data driven testing yapmis olduk asagidaki tablo ile
    Examples:
      | username  | sifre        |  |
      | username1 | hatalisifre1 |  |
      | username2 | hatalisifre2 |  |
