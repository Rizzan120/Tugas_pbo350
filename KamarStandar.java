public class KamarStandar extends Kamar {
    public KamarStandar(String nomorKamar, double harga, String fasilitas) {
        super(nomorKamar, harga, fasilitas);
    }

    @Override
    public String getTipeKamar() {
        return "Kamar Standar";
    }
}
