import java.util.Date;

public class Reservasi {
    private final Tamu tamu;
    private final Kamar kamar;
    private final Date checkIn;
    private final Date checkOut;

    public Reservasi(Tamu tamu, Kamar kamar, Date checkIn, Date checkOut) {
        this.tamu = tamu;
        this.kamar = kamar;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public double hitungTotalBiaya() {
        long durasi = (checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24);
        return durasi * kamar.getHarga();
    }

    public void tampilkanDetailReservasi() {
        System.out.println("Nama Tamu: " + tamu.getNama());
        System.out.println("Tipe Kamar: " + kamar.getTipeKamar());
        System.out.println("Nomor Kamar: " + kamar.getNomorKamar());
        System.out.println("Tanggal Check-in: " + checkIn);
        System.out.println("Tanggal Check-out: " + checkOut);
        System.out.println("Total Biaya: " + hitungTotalBiaya());
        System.out.println("---------------------------------");
    }

    public String getInfoReservasi() {
        return "Nama Tamu: " + tamu.getNama() + ", Tipe Kamar: " + kamar.getTipeKamar() +
                ", Nomor Kamar: " + kamar.getNomorKamar() + ", Total Biaya: " + hitungTotalBiaya();
    }
}
