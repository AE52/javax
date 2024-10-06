package idman;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Burpee sayısını girin: ");
        int burpee = scanner.nextInt();
        System.out.print("Push-up sayısını girin: ");
        int pushup = scanner.nextInt();
        System.out.print("Squat sayısını girin: ");
        int squat = scanner.nextInt();
        System.out.print("Sit-up sayısını girin: ");
        int situp = scanner.nextInt();

        Idman idman = new Idman(burpee, pushup, squat, situp);

        System.out.println("İdman başlıyor...");

        while (!idman.idmanBittiMi()) {
            System.out.print("Hareket türü (burpee, pushup, squat, situp): ");
            String tur = scanner.next();
            System.out.print("Bu harekette kaç tane yapacaksınız: ");
            int sayi = scanner.nextInt();
            idman.hareketYap(tur, sayi);
        }

        System.out.println("Tebrikler, idman bitti!");
    }
}
