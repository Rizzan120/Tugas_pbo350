public abstract class Kamar {
    private final String nomorKamar;
    private final double harga;

    public Kamar(String nomorKamar, double harga, String ignoredFasilitas) {
        this.nomorKamar = nomorKamar;
        this.harga = harga;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public double getHarga() {
        return harga;
    }

    public abstract String getTipeKamar();
}
