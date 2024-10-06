Tabii, aşağıda isteğinize göre detaylı ve tasarımı iyi olan bir README dosyası hazırladım. Bu dosya, kodun AE52’ye ait olduğunu ve ne yaptığını, nasıl çalıştığını detaylı bir şekilde anlatmaktadır.

---

# Banka Hesabı Yönetim Programı (AE52)

Bu proje, AE52 tarafından geliştirilmiş bir **Banka Hesabı Yönetim Programı**dır. Kullanıcıların bir banka hesabı açıp, para yatırma ve çekme işlemlerini yapmalarını sağlar. Program, basit bir komut satırı uygulaması olarak yazılmış olup, kullanıcının hesap numarasını ve başlangıç bakiyesini alarak işlemleri gerçekleştirebilir.

## İçindekiler

1. [Genel Bakış](#genel-bakış)
2. [Özellikler](#özellikler)
3. [Nasıl Kullanılır](#nasıl-kullanılır)
4. [Kurulum](#kurulum)
5. [Kodun Yapısı](#kodun-yapısı)
6. [Katkıda Bulunanlar](#katkıda-bulunanlar)
7. [Lisans](#lisans)

## Genel Bakış

Bu proje, bir banka hesabı simülasyonu yapmanıza olanak tanır. Program, hesap numarası ve başlangıç bakiyesi gibi kullanıcı girdilerini alır ve sonrasında para yatırma, çekme işlemlerini gerçekleştirir. Ayrıca, mevcut bakiyeyi kontrol etmenize de olanak sağlar. Program, komut satırında çalıştırılmak üzere tasarlanmıştır ve Java programlama dili kullanılarak yazılmıştır.

**Geliştirici**: AE52  
**Sürüm**: 1.0.0  
**Tarih**: 2024

## Özellikler

- Kullanıcıdan hesap numarası ve başlangıç bakiyesini alır.
- Para yatırma ve çekme işlemleri yapmanıza olanak tanır.
- Hesap bakiyesini kontrol eder ve görüntüler.
- Negatif bakiyeyi engeller, hatalı işlemler için hata mesajları verir.
- Para çekme işleminde bakiye kontrolü sağlar, yetersiz bakiye durumunda uyarı verir.
- Tüm işlemler kullanıcı dostu ve basit bir menü yapısı ile yönetilir.

### İşlemler:

1. **Para Yatırma**: Pozitif bir miktar girerek bakiyeyi artırabilirsiniz.
2. **Para Çekme**: Pozitif bir miktar girerek mevcut bakiyeden para çekebilirsiniz (yetersiz bakiye durumu kontrol edilir).
3. **Bakiye Görüntüleme**: Mevcut hesap bakiyenizi görüntüleyebilirsiniz.
4. **Çıkış**: Programdan çıkabilirsiniz.

## Nasıl Kullanılır

### 1. Hesap Numarası ve Başlangıç Bakiyesi Girişi
Program çalıştırıldığında, kullanıcıdan hesap numarası ve başlangıç bakiyesi istenir. Başlangıç bakiyesi negatif olamaz.

### 2. Menü
Daha sonra kullanıcı, şu işlemleri seçebileceği bir menü ile karşılaşır:

- **Para Yatırma**
- **Para Çekme**
- **Bakiye Gösterme**
- **Çıkış**

Her işlem sonrasında program, bir sonraki işlemi yapabilmeniz için tekrar menüyü gösterir.

### 3. İşlem Sonlandırma
Menüden "Çıkış" seçeneği seçildiğinde, program sonlandırılır.

## Kurulum

Bu projeyi çalıştırmak için bilgisayarınızda aşağıdaki adımları izleyin:

### Gereksinimler

- **Java JDK** (Java Development Kit) yüklü olmalı.
- **VS Code** veya başka bir IDE.

### Adım 1: Java Kurulumu

Java'nın kurulu olup olmadığını kontrol edin. Eğer yüklü değilse, [Java JDK'yı buradan indirebilirsiniz](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

Terminalde şu komutla kontrol edebilirsiniz:

```bash
java -version
```

### Adım 2: Projeyi Çalıştırma

1. **Kodu indirin** veya kopyalayın.
2. Projeyi çalıştırmak için terminalde şu komutları kullanın:

```bash
javac BankaHesabi.java  # Derleme
java BankaHesabi        # Çalıştırma
```

### Adım 3: Kullanıcı Girdisi Alma

Hesap numarası ve başlangıç bakiyesini girdikten sonra işlemleri gerçekleştirebilirsiniz.

## Kodun Yapısı

Programın ana yapısı şu şekildedir:

- **BankaHesabi Sınıfı**: Hesap yönetimi ile ilgili tüm işlemleri barındırır.
    - **paraYatir**: Pozitif bir miktar yatırmanızı sağlar.
    - **paraCek**: Yetersiz bakiye durumunda hata vererek para çekmenizi sağlar.
    - **bakiyeGoster**: Hesap bakiyesini görüntüler.
    - **main**: Kullanıcıdan veri alır ve işlemleri yönetir.

Aşağıda kodun ana bileşenleri özetlenmiştir:

```java
public class BankaHesabi {
    private String hesapNumarasi;
    private double bakiye;

    public BankaHesabi(String hesapNumarasi, double baslangicBakiyesi) {
        this.hesapNumarasi = hesapNumarasi;
        if (baslangicBakiyesi < 0) {
            System.out.println("Başlangıç bakiyesi negatif olamaz. Bakiye sıfır olarak ayarlandı.");
            this.bakiye = 0;
        } else {
            this.bakiye = baslangicBakiyesi;
        }
    }

    // Para yatırma işlemi
    public void paraYatir(double miktar) {
        if (miktar > 0) {
            bakiye += miktar;
        } else {
            System.out.println("Yatırılan miktar negatif olamaz.");
        }
    }

    // Para çekme işlemi
    public void paraCek(double miktar) {
        if (miktar > 0 && miktar <= bakiye) {
            bakiye -= miktar;
        } else if (miktar > bakiye) {
            System.out.println("Yetersiz bakiye.");
        } else {
            System.out.println("Çekilen miktar negatif olamaz.");
        }
    }

    // Bakiye gösterme işlemi
    public void bakiyeGoster() {
        System.out.println("Bakiye: " + bakiye);
    }
}
```

### Kullanılan Metodlar

- **paraYatir(double miktar)**: Kullanıcıdan alınan pozitif miktarı bakiyeye ekler.
- **paraCek(double miktar)**: Çekilmek istenen miktarı bakiyeden düşer, ancak yetersiz bakiye durumunda hata verir.
- **bakiyeGoster()**: Mevcut hesap bakiyesini kullanıcıya gösterir.

## Katkıda Bulunanlar

Bu proje AE52 tarafından geliştirilmiştir. Katkıda bulunmak isterseniz, aşağıdaki adımları izleyerek projeye katkı sağlayabilirsiniz:

1. Projeyi fork edin.
2. Geliştirmelerinizi yapın.
3. Pull request gönderin.

## Lisans

Bu proje MIT lisansı ile lisanslanmıştır. Ayrıntılar için `LICENSE` dosyasına bakabilirsiniz.

---

Eğer bu projeyi beğendiyseniz, yıldız vermeyi unutmayın! :)