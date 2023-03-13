Feature: DB ile baglanti kurup urun sorgusu yapma
  @DBtest
  Scenario: DB sorgusu calismasi
    Given DB ile baglanti kuruluri
    When Tablo ya gidiliri
    Then Tablodaki urun sayisi assert edeliri
    And Tabloda fiyati en yuksek urun assert ediliri
    And Urun isimlerinden birinin adi degistirirliri
    And Urun fiyat ortalamasi yazdirirliri
    And Tablodaki sutunlarin isimleri farkli yazdiriliri
    And Urun isimlerinin hepsi buyuk harf olacak sekilde yazdiriliri
    And Hepsi kucuk harf olacak sekilde yazdiriliri
    And Birinci harfi buyuk olacak sekilde yazdiriliri
    And Belli bir fiyatin altindaki urunleri isme gore azalan olarak yazdiriliri