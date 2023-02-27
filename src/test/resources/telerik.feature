Feature: Kullanici telerik sitesinde birden fazla urun aramasi yapabilmektedir

  @teleriksearch
  Scenario Outline: : Arama sonucu gelen urunler arama metni ile eslesmektedir
    Given Kullanici telerik sitesine gider
    When Telerik teki cookies leri kabul eder
    And Arama kutusu sayfasina gider
    Then Arama kutusuna "<Aranack Kelime>" yazar ve arama butonuna tiklar ve test eder
    Examples:
      | Aranack Kelime |
      |keyword test    |
      |data testing    |



