Feature: Ebayda kullanici filtre secimi ile dogru urun bulunabilmelidir

  Background:
    Given Kullanici ebay sayfasina gider
    When Cookies leri kabul eder

  @Win10
  Scenario: Filtre secimi ile dogru urun bulma
    And Arama kutusuna computer yazar ve aratir
    And Cikan sayfada WinOn butanina tiklar
    Then En usstteki urunun WinOn ozelliklerinde oldugunu test eder



