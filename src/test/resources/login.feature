Feature: Kullanici login sayfasini doldurur
  Background:
    Given Kullanici login sayfasina gider

  @smoketest
  @login
  @positive
  Scenario: Kullanici gecerli kullanici adi ve sifreyle login olabilmeli

    When Kullanici adi sifreyi girer
    And Login butonuna tiklar
    Then Aanasayfaya yonlendirilir

  @smoketest
  @login
  @negative
  Scenario: Kullanici gecerli olmayan kullanici adi ve sifreyle login olamamalidir

    When Kullanici gecersiz bir username ve sifre girer
    And Login butonuna tiklar
    Then Kullanici hata mesaji alir
