package bankacilik;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

public class BankaHesabi {
    private String hesapNumarasi;
    private double bakiye;

    // Constructor
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
            System.out.println(miktar + " TL yatırıldı. Güncel bakiye: " + bakiye + " TL");
        } else {
            System.out.println("Yatırılan miktar negatif olamaz.");
        }
    }

    // Para çekme işlemi
    public void paraCek(double miktar) {
        if (miktar > 0) {
            if (miktar <= bakiye) {
                bakiye -= miktar;
                System.out.println(miktar + " TL çekildi. Güncel bakiye: " + bakiye + " TL");
            } else {
                System.out.println("Yetersiz bakiye. Çekmek istediğiniz miktar bakiyeden fazla.");
            }
        } else {
            System.out.println("Çekilen miktar negatif olamaz.");
        }
    }

    // Bakiye gösterme işlemi
    public void bakiyeGoster() {
        System.out.println("Hesap numarası: " + hesapNumarasi + " - Bakiye: " + bakiye + " TL");
    }

    // Kullanıcıdan işlemleri alma
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hesap numaranızı girin: ");
        String hesapNumarasi = scanner.nextLine();

        System.out.print("Başlangıç bakiyesini girin: ");
        double baslangicBakiyesi = scanner.nextDouble();

        BankaHesabi hesap = new BankaHesabi(hesapNumarasi, baslangicBakiyesi);

        boolean devam = true;
        while (devam) {
            System.out.println("\nBir işlem seçin: ");
            System.out.println("1 - Para Yatır");
            System.out.println("2 - Para Çek");
            System.out.println("3 - Bakiye Göster");
            System.out.println("4 - Çıkış");

            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.print("Yatırmak istediğiniz miktarı girin: ");
                    double yatirMiktar = scanner.nextDouble();
                    hesap.paraYatir(yatirMiktar);
                    break;
                case 2:
                    System.out.print("Çekmek istediğiniz miktarı girin: ");
                    double cekMiktar = scanner.nextDouble();
                    hesap.paraCek(cekMiktar);
                    break;
                case 3:
                    hesap.bakiyeGoster();
                    break;
                case 4:
                    devam = false;
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim.");
            }
        }

        scanner.close();
    }
}
