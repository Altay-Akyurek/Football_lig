/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.futbolligi;

import java.util.Scanner;
public class FutbolLigi {
 public static void main(String[] args) {
        Scanner oku = new Scanner(System.in);
        int ts = 0; // Takım sayısı
        String[] ti = null; // Takım isimleri
        int[][] skorlar = null; // Takımların skorlarını tutacak  dizi
        
        // Menü
        while (true) {
            // Kullanıcıya yapılabilecek işlemleri gösteren menü
            System.out.println("1-Takim Sayisi Belirleyin (min 2)");
            System.out.println("2-Takim Isimlerini Girin");
            System.out.println("3-Fikstur Olusturun");
            System.out.println("4-Skor girme");
            System.out.println("5-Puan Durumu Goruntuleme ");
            System.out.println("6-Cikis");
            int secim = oku.nextInt();// Kullanıcının menüden bir seçim yapmasını sağlar
            oku.nextLine(); // nextInt() sonrası kalan yeni satırı temizle

            switch (secim) {
                case 1:
                    // Takım sayısını belirleme
                    System.out.println("Takim Sayisini Belirleyin (min 2):");
                    ts = oku.nextInt(); // Kullanıcıdan takım sayısını alır
                    oku.nextLine(); // nextInt() sonrası kalan yeni satırı temizle
                    if (ts < 2) // Minimum 2 takım kontrolü
                    //BİLGİ:Bu bir kısıttır
                    {
                        System.out.println("Takim sayisi minimum 2 olmalidir.");
                        ts = 0; // Geçersiz sayıyı sıfırla
                    }
                    System.out.print("Takim Sayisi:"+ts+" ");
                    System.out.println("olarak belirlenmistir.");
                    break;

                case 2:
                    // Takım isimlerini girme
                    if (ts <= 1) // Takım sayısı girilmeden isim girilmesini engeller
                        //BİLGİ:Bu bir kısıttır
                    {
                        System.out.println("Öncelikle takım sayısını belirleyin (min 2).");
                        break;
                    }
                    System.out.println("Takim isimlerini girin:");
                    ti = new String[ts];// Takım isimlerini tutacak diziyi oluşturur
                    //UYARI:Yukarda bu durumu kaydetmesi ve dizi uzunluğu belirsiz yapmak için null yaptık 
                    // NEDEN: iki veya diğer case ler arasında bu değeri kullanmak için
                    for (int i = 0; i < ts; i++) {
                        System.out.print("Takim " + (i + 1) + ": ");
                        ti[i] = oku.nextLine(); // Takım isimlerini kullanıcıdan alır
                        //BİLGİ:Alınan bilgiler yukarıda girilen null değerini depğiştirip kaydediyoruz
                    }
                    System.out.println("Takimlerin isimleri basarili olarak kaydedilmistir");
                    break;

                case 3:
                    // Fikstür oluşturma
                    if (ti == null || ti.length < 2) 
                    // Takım isimleri girilmeden fikstür oluşturulamaz
                    //BİLGİ:Bu bir kısıttır 
                    {
                        System.out.println("Öncelikle takım isimlerini girin.");
                        break;
                    }

                    System.out.println("\nBirinci Yari:");
                    int n = ti.length;

                    // Takım sayısı tekse "Bay" ekle
                    if (n % 2 != 0) {
                        String[] yeniTi = new String[n + 1];
                        for (int i = 0; i < n; i++) {
                            yeniTi[i] = ti[i]; // Eski diziyi yeniye kopyala
                        }
                        yeniTi[n] = "Bay"; // Bay ekle
                        ti = yeniTi;
                        n++;
                    }

                    int hafta = 1;

                    for (int i = 0; i < n - 1; i++) { // Toplam (n-1) hafta
                        System.out.print("Hafta " + hafta + ": ");
                        for (int j = 0; j < n / 2; j++) { // Her hafta yarı yarıya eşleşme
                            int evSahibi = (i + j) % (n - 1);
                            int deplasman = (n - 1 - j + i) % (n - 1);

                            // Son takımın rotasyona dahil edilmesi
                            if (j == 0) deplasman = n - 1;

                            // "Bay" kontrolü için doğrudan karşılaştırma
                            if (ti[evSahibi] == "Bay") {
                                System.out.print(ti[deplasman] + " dinleniyor");
                            } else if (ti[deplasman] == "Bay") {
                                System.out.print(ti[evSahibi] + " dinleniyor");
                            } else {
                                System.out.print(ti[evSahibi] + " VS " + ti[deplasman]);
                            }

                            if (j < n / 2 - 1) System.out.print(" ||| ");
                        }
                        System.out.println();
                        hafta++;
                    }
                    int hafta2=1;// İkinci yarı maçlarının haftalarını tutar
                    System.out.println("\nIkinci Yari:");
                    int m = ti.length;

                    // Takım sayısı tekse "Bay" ekle
                    if (m % 2 != 0) {
                        String[] yeniTi = new String[m + 1];
                        for (int i = 0; i < m; i++) {
                            yeniTi[i] = ti[i]; // Eski diziyi yeniye kopyala
                        }
                        yeniTi[m] = "Bay"; // Bay ekle
                        ti = yeniTi;
                        m++;
                    }

                    

                    for (int i = 0; i < m - 1; i++) { // Toplam (n-1) hafta
                        System.out.print("Hafta " + hafta2 + ": ");
                        for (int j = 0; j < m / 2; j++) { // Her hafta yarı yarıya eşleşme
                            int evSahibi = (i + j) % (m - 1);
                            int deplasman = (m - 1 - j + i) % (m - 1);

                            // Son takımın rotasyona dahil edilmesi
                            if (j == 0) deplasman = m - 1;

                            // "Bay" kontrolü için doğrudan karşılaştırma
                            if (ti[evSahibi] == "Bay") {
                                System.out.print(ti[deplasman] + " dinleniyor");
                            } else if (ti[deplasman] == "Bay") {
                                System.out.print(ti[evSahibi] + " dinleniyor");
                            } else {
                                System.out.print(ti[evSahibi] + " VS " + ti[deplasman]);
                            }

                            if (j < m / 2 - 1) System.out.print(" ||| ");
                        }
                        System.out.println();
                        hafta2++;
                    }
                    break;

                case 4:
                    // Skor girme
                    if(ti==null|| ti.length<2)
                    // Takım isimleri olmadan skor girilemez
                    //BİLGİ:Bu bir kısıttır
                    {
                        System.out.print("Öncelikle Takım İsimlerini Giriniz:");
                        break;
                    }
                    skorlar= new int[ti.length][ti.length];// Skorları tutacak matris oluşturulur
                    //UYARI:yukaruda 2 boyutlu skorlar dizisini kaydetmesi için null olarka tanımladık
                    
                    
                    
                    // İlk yarı skorlarını girme
                    for(int i=0;i<ti.length;i++)
                    {
                        for(int j=i+1;j<ti.length;j++)
                        {
                            System.out.println(ti[i]+" vs "+ti[j]);
                            System.out.print("Skor Takim 1:");// Ev sahibi skor
                            int skor1=oku.nextInt();
                            System.out.print("Skor Takim 2:");// Deplasman skor
                            int skor2=oku.nextInt();
                            skorlar[i][j]=skor1;
                            skorlar[j][i]=skor2;
                            // Maç sonucu bildirimi
                            if (skor1 < skor2) {
                                System.out.println(ti[j] + " Kazandi");
                            } else if (skor1 == skor2) {
                                System.out.println("Berabere");
                            } else {
                                System.out.println(ti[i] + " Kazandi");
                            }
                            
                        }
                    }
                    System.out.println("Ilk yari basarili sekilde kaydedilmistir");
                    System.out.println("\nTakimlarin Skorlari:");
                    for (int i = 0; i < ti.length; i++) 
                    {
                        for (int j = i + 1; j < ti.length; j++) {
                            System.out.println(ti[i] + " " + skorlar[i][j] + " - " + skorlar[j][i] + " " + ti[j]);
                        }
                    }
                    // İkinci yarı skorlarını girme
                    for(int i=ti.length-1;i>=0;i--)
                    {
                        for(int j =i-1;j>=0;j--)
                        {
                            System.out.println(ti[i]+" vs "+ti[j]);
                            System.out.print("Skor Takim 1:"); // Ev sahibi skor
                            int skor1=oku.nextInt();
                            System.out.print("Skor Takim 2:");// Deplasman skor
                            int skor2=oku.nextInt();
                            skorlar[i][j]=skor1;
                            skorlar[j][i]=skor2;
                            
                            if (skor1 < skor2) {
                                System.out.println(ti[j] + " Kazandi");
                            } else if (skor1 == skor2) {
                                System.out.println("Berabere");
                            } else {
                                System.out.println(ti[i] + " Kazandi");
                            }
                            
                            
 
                        }
                        
                    }
                    
                    System.out.println("Ikinci yari basarili sekilde kaydedilmistir");
                    // Skorların listesi
                    System.out.println("\nTakimlarin Skorlari:");
                    for (int i = 0; i < ti.length; i++) 
                    {
                        for (int j = i + 1; j < ti.length; j++) {
                            System.out.println(ti[i] + " " + skorlar[i][j] + " - " + skorlar[j][i] + " " + ti[j]);
                        }
                    }
                    break;
                case 5:
                    // Puan ve averajlar için diziler oluşturdum
                    int[] puan =new int[ti.length];// Her takımın puanı
                    int[] averaj=new int[ti.length];// Her takımın averajı
                    
                    // Puan ve averaj hesaplama
                for (int i = 0; i < ti.length; i++) 
                {
                    for (int j = 0; j < ti.length; j++) 
                    {
                        if (i != j) 
                        {
                            if (skorlar[i][j] > skorlar[j][i]) // Galibiyet
                            {
                                puan[i] += 3; // Galibiyet
                            } else if (skorlar[i][j] == skorlar[j][i]) // Beraberlik
                            {
                                puan[i] += 1; // Beraberlik
                            }
                            // Averaj hesaplama
                            averaj[i] += skorlar[i][j] - skorlar[j][i];// Averaj hesaplama
                        }
                    }
                }
                // Takımları sıralama
                int[] siralama = new int[ti.length];
                for (int i = 0; i < ti.length; i++) 
                {
                    siralama[i] = i;// Takımların indekslerini sıralama için tut
                }

                for (int i = 0; i < ti.length - 1; i++) 
                {
                    for (int j = i + 1; j < ti.length; j++) 
                    {
                        if 
                                
                        (
                            puan[siralama[i]] < puan[siralama[j]] || // Puan sıralaması
                            (puan[siralama[i]] == puan[siralama[j]] && averaj[siralama[i]] < averaj[siralama[j]]) // Averaj sıralaması
                        ) 
                        {
                            // Daha fazla puan veya averajı yüksek olan takımı öne al
                            int temp = siralama[i];
                            siralama[i] = siralama[j];
                            siralama[j] = temp;
                        }
                    }
                }
                // Puan tablosunu görüntüleme
                System.out.println("\nPuan Durumu:");
                System.out.printf("%-15s %-10s %-10s\n", "Takim", "Puan", "Averaj");
                for (int i = 0; i < ti.length; i++) {
                    int index = siralama[i];
                    System.out.printf("%-15s %-10d %-10d\n", ti[index], puan[index], averaj[index]);
                }
                case 6:
                // Çıkış
                    System.out.println("Program sonlandiriliyor.");
                return; // Programdan çıkış yap
         
                    
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
                    break;
            }
        }
    }
}
