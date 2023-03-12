Feature: Tablodaki urunleri sorgulama

  Scenario: DB ile urunleri sorgulama
    Given DB ile baglanti kurulur
    When Tablo ya gidilir
    Then Tablodaki urun sayisi assert edelir
    And Tabloda fiyati en yuksek urun assert edilir
    And Urun isimlerinden birinin adi degistirirlir
    And Urun fiyat ortalamasi yazdirirlir
    And Tablodaki sutunlarin isimleri farkli yazdirilir
    And Urun isimlerinin hepsi buyuk harf olacak sekilde yazdirilir
    And Hepsi kucuk harf olacak sekilde yazdirilir
    And Birinci harfi buyuk olacak sekilde yazdirilir
    And Belli bir fiyatin altindaki urunleri isme gore azalan olarak yazdirilir