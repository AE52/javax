package idman;
class Idman {
    private int burpeeSayisi;
    private int pushupSayisi;
    private int squatSayisi;
    private int situpSayisi;

    public Idman(int burpeeSayisi, int pushupSayisi, int squatSayisi, int situpSayisi) {
        this.burpeeSayisi = burpeeSayisi;
        this.pushupSayisi = pushupSayisi;
        this.squatSayisi = squatSayisi;
        this.situpSayisi = situpSayisi;
    }

    public void hareketYap(String hareketTuru, int sayi) {
        if (hareketTuru.equals("burpee")) {
            burpeeYap(sayi);
        } else if (hareketTuru.equals("pushup")) {
            pushupYap(sayi);
        } else if (hareketTuru.equals("squat")) {
            squatYap(sayi);
        } else if (hareketTuru.equals("situp")) {
            situpYap(sayi);
        } else {
            System.out.println("Geçersiz hareket...");
        }
    }

    private void burpeeYap(int sayi) {
        if (burpeeSayisi == 0) {
            System.out.println("Yapacak burpee kalmadı.");
        } else if (burpeeSayisi - sayi < 0) {
            System.out.println("Yapmanız gereken burpee sayısından fazla girdiniz.");
        } else {
            burpeeSayisi -= sayi;
            System.out.println(sayi + " burpee yaptınız. Kalan burpee sayısı: " + burpeeSayisi);
        }
    }

    private void pushupYap(int sayi) {
        if (pushupSayisi == 0) {
            System.out.println("Yapacak push-up kalmadı.");
        } else if (pushupSayisi - sayi < 0) {
            System.out.println("Yapmanız gereken push-up sayısından fazla girdiniz.");
        } else {
            pushupSayisi -= sayi;
            System.out.println(sayi + " push-up yaptınız. Kalan push-up sayısı: " + pushupSayisi);
        }
    }

    private void squatYap(int sayi) {
        if (squatSayisi == 0) {
            System.out.println("Yapacak squat kalmadı.");
        } else if (squatSayisi - sayi < 0) {
            System.out.println("Yapmanız gereken squat sayısından fazla girdiniz.");
        } else {
            squatSayisi -= sayi;
            System.out.println(sayi + " squat yaptınız. Kalan squat sayısı: " + squatSayisi);
        }
    }

    private void situpYap(int sayi) {
        if (situpSayisi == 0) {
            System.out.println("Yapacak sit-up kalmadı.");
        } else if (situpSayisi - sayi < 0) {
            System.out.println("Yapmanız gereken sit-up sayısından fazla girdiniz.");
        } else {
            situpSayisi -= sayi;
            System.out.println(sayi + " sit-up yaptınız. Kalan sit-up sayısı: " + situpSayisi);
        }
    }

    public boolean idmanBittiMi() {
        return (burpeeSayisi == 0 && pushupSayisi == 0 && squatSayisi == 0 && situpSayisi == 0);
    }
}