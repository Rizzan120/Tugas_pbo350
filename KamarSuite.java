public class KamarSuite extends Kamar {
    public KamarSuite(String nomorKamar, double harga, String fasilitas) {
        super(nomorKamar, harga, fasilitas);
    }

    @Override
    public String getTipeKamar() {
        return "Kamar Suite";
    }
}
