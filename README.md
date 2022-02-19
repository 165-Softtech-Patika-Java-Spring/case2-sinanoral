# Case2

## Adres Kayıt Sistemi:

Bir adreste bulunması gereken alanlar:

- Ülke
- Şehir
- İlçe
- Mahalle
- Sokak
- Kapı No
- Daire No

Bir adet controller yazınız(Tek controller yeterli).

Bu controller içerisinde aşağıdaki işlemler yapılabilmelidir.

1. Ülke kaydedilebilmelidir. [OK]
2. Ülke kodundan ülke sorgulanabilmelidir. [OK]
3. Şehir kaydedilebilmelidir. [OK]
4. Plakadan şehir bilgisi sorgulanabilmelidir. [OK]
5. İlçe kaydedilebilmelidir. [OK]
6. Bir ilçeye ait mahalleler sorgulanabilmelidir.[OK]
7. Bir ile ait ilçeler sorgulanabilmelidir.[OK]
8. Mahalle kaydedilebilmelidir.[OK]
9. Mahalle adını güncellenebilmelidir.[OK]
10. Bir mahalleye ait sokaklar sorgulanabilmelidir.[OK]
11. Sokak kaydedilebilmelidir.[OK]
12. Sokak adı güncellenebilmelidir.[OK]
13. Adres kaydedilebilmelidir.
14. Adres silinebilmelidir. [OK]
15. Id den adres bilgisi edinilebilmelidir. [OK]

### NOT:

- Address entitysi hariç diğer entitylerin servislerinde entity kullanabilirsiniz. Yani metot parametresi için dto,
  return için başka bir dto kullanmanıza gerek yok.
- Address kaydeden dönen vs yerlerde mapper ya da converterlar kullanarak DTO ile veri akışını sağlayınız.
