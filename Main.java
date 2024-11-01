import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final List<Kamar> kamarList;
    private final List<Reservasi> reservasiList = new ArrayList<>();

    public Main() {
        kamarList = new ArrayList<>();
        inisialisasiKamar();
    }

    private void inisialisasiKamar() {
        kamarList.add(new KamarStandar("101", 100.0, "Wi-Fi Gratis, TV"));
        kamarList.add(new KamarSuite("201", 200.0, "Wi-Fi Gratis, TV, Mini Bar"));
        // Tambahkan lebih banyak kamar sesuai kebutuhan
    }

    public void buatReservasi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nama tamu: ");
        String namaTamu = scanner.nextLine();
        System.out.println("Masukkan nomor kontak: ");
        String kontak = scanner.nextLine();

        Tamu tamu = new TamuBuilder().setNama(namaTamu).setIgnoredKontak(kontak).createTamu();

        System.out.println("Kamar yang tersedia: ");
        for (Kamar kamar : kamarList) {
            System.out.println(kamar.getNomorKamar() + " - " + kamar.getTipeKamar() + " - " + kamar.getHarga());
        }

        System.out.println("Masukkan nomor kamar yang ingin dipesan: ");
        String nomorKamar = scanner.nextLine();

        Kamar kamarDipilih = null;
        for (Kamar kamar : kamarList) {
            if (kamar.getNomorKamar().equals(nomorKamar)) {
                kamarDipilih = kamar;
                break;
            }
        }

        if (kamarDipilih == null) {
            System.out.println("Kamar tidak ditemukan.");
            return;
        }

        System.out.println("Masukkan tanggal check-in (format: dd/MM/yyyy): ");
        String checkInStr = scanner.nextLine();
        System.out.println("Masukkan tanggal check-out (format: dd/MM/yyyy): ");
        String checkOutStr = scanner.nextLine();

        try {
            Date checkIn = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(checkInStr);
            Date checkOut = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(checkOutStr);
            Reservasi reservasi = new Reservasi(tamu, kamarDipilih, checkIn, checkOut);
            reservasiList.add(reservasi);
            reservasi.tampilkanDetailReservasi();
        } catch (Exception e) {
            System.out.println("Format tanggal salah. Silakan coba lagi.");
        }
    }

    public void tampilkanReservasi() {
        System.out.println("Daftar Reservasi:");
        for (Reservasi reservasi : reservasiList) {
            System.out.println(reservasi.getInfoReservasi());
        }
        System.out.println("---------------------------------");
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Sistem Manajemen Reservasi Hotel ===");
            System.out.println("1. Buat Reservasi");
            System.out.println("2. Tampilkan Semua Reservasi");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            switch (pilihan) {
                case 1:
                    buatReservasi();
                    break;
                case 2:
                    tampilkanReservasi();
                    break;
                case 3:
                    System.out.println("Terima kasih! Program selesai.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void main(String[] args) {
        Main hotelReservation = new Main();
        hotelReservation.menu();
    }
}
