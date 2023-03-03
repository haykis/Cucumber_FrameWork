Feature: Sepetteki urunleri tetst ediyor

  @telerik2
  Scenario: urunleri test eder
    Given ana sayfaya gider telerik
    When cookiesleri kabul eder telerik
    And pricing butonuna tiklar
    And paket secipi yap sepete ekle
    And navigate ile geri gelir
    Then assert eder sepeti
