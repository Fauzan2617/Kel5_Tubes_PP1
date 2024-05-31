public class Mahasiswa {
    private String nama;
    private int nim;
    private String universitas;
    private String Matkul;

    public Mahasiswa(String nama, int nim, String universitas,String Matkul) {
        this.nama = nama;
        this.nim = nim;
        this.universitas = universitas;
        this.Matkul = Matkul;
    }

    public String getNama() {
        return nama;
    }

    public int getNim() {
        return nim;
    }

    public String getMatkul() {
        return Matkul;
    }

    public String getUniversitas() {
        return universitas;
    }

    @Override
    public String toString() {
        return "Mahasiswa : " + '\n' +
                "   " + " \t Nama =" + " " + nama + '\n' +
                "   " + " \t Matkul = " + " " + Matkul + '\n'+
                "   " + " \t NIM =" + " " + nim + '\n'+
                "   " + " \t Universitas =" + " " + universitas;
    }
}
