public class TamuBuilder {
    private String nama;
    private String ignoredKontak;

    public TamuBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public TamuBuilder setIgnoredKontak(String ignoredKontak) {
        this.ignoredKontak = ignoredKontak;
        return this;
    }

    public Tamu createTamu() {
        return new Tamu(nama, ignoredKontak);
    }
}