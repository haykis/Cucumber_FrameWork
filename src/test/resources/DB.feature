Feature: DB ile sorgu
  Scenario: DB ile calisma
    Given DB ile baglanti kurar
    When Verileri getiririr
    Then testlerini yapar