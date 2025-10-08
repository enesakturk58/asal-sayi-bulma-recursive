import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        long number = sc.nextLong();

        boolean prime = isPrime(number);
        System.out.println(number + (prime ? " asaldır." : " asal değildir."));
    }

    // Dış arayüz
    static boolean isPrime(long number) {
        if (number <= 1) return false;    // 0 ve 1 asal değildir
        if (number == 2) return true;     // 2 asaldır
        if (number % 2 == 0) return false;// 2'den büyük çiftler asal değildir
        return isPrimeRec(number, 3);     // 3'ten başlayarak tek bölenler
    }

    // Özyinelemeli yardımcı metot
    static boolean isPrimeRec(long number, long divisor) {
        // divisor*divisor > number demek; overflow riskine karşı divisor > number/divisor yazdık
        if (divisor > number / divisor) return true;      // Hiç bölen bulunmadı → asal
        if (number % divisor == 0) return false;    // divisor, number'i bölüyorsa asal değil
        return isPrimeRec(number, divisor + 2);     // Sadece tek sayılar: 3,5,7,...
    }
}
