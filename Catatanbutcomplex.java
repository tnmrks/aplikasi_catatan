import java.util.ArrayList;
import java.util.Scanner;

// Class abstract sebagai blueprint untuk catatan
abstract class Catatan {
    private String judul;
    private String isi;

    public Catatan(String judul, String isi) {
        this.judul = judul;
        this.isi = isi;
    }

    public String getJudul() {
        return judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    // Metode abstract tanpa implementasi
    public abstract void tampilkanInfo();

    // Overriding metode toString() untuk representasi teks objek catatan
    @Override
    public String toString() {
        return "Judul: " + judul + "\nIsi: " + isi;
    }
}

// Class turunan dari Catatan
class CatatanTeks extends Catatan {
    public CatatanTeks(String judul, String isi) {
        super(judul, isi);
    }

    // Implementasi metode tampilkanInfo() dari class Catatan
    @Override
    public void tampilkanInfo() {
        System.out.println("====== Catatan Teks ======");
        System.out.println(toString());
    }
}

// Class turunan dari Catatan
class CatatanGambar extends Catatan {
    private String namaFile;

    public CatatanGambar(String judul, String isi, String namaFile) {
        super(judul, isi);
        this.namaFile = namaFile;
    }

    public String getNamaFile() {
        return namaFile;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }

    // Implementasi metode tampilkanInfo() dari class Catatan
    @Override
    public void tampilkanInfo() {
        System.out.println("====== Catatan Gambar ======");
        System.out.println(toString());
        System.out.println("Nama File: " + namaFile);
    }
}

public class Catatanbutcomplex {
    private static ArrayList<Catatan> daftarCatatan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("===== Aplikasi Pengelola Catatan =====");
            System.out.println("1. Tambah Catatan Teks");
            System.out.println("2. Tambah Catatan Gambar");
            System.out.println("3. Lihat Semua Catatan");
            System.out.println("4. Hapus Catatan");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1/2/3/4/5): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahCatatanTeks();
                    break;
                case 2:
                    tambahCatatanGambar();
                    break;
                case 3:
                    lihatSemuaCatatan();
                    break;
                case 4:
                    hapusCatatan();
                    break;
                case 5:
                    berjalan = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }

            System.out.println();
        }

        System.out.println("Terima kasih telah menggunakan Aplikasi Pengelola Catatan!");
    }

    private static void tambahCatatanTeks() {
        System.out.print("Masukkan judul catatan: ");
        String judul = scanner.next();

        System.out.print("Masukkan isi catatan: ");
        scanner.nextLine(); // Consuming the \n character from the previous next() call
        String isi = scanner.nextLine();

        CatatanTeks catatanTeks = new CatatanTeks(judul, isi);
        daftarCatatan.add(catatanTeks);
        System.out.println("Catatan teks berhasil ditambahkan!");
    }

    private static void tambahCatatanGambar() {
        System.out.print("Masukkan judul catatan: ");
        String judul = scanner.next();

        System.out.print("Masukkan isi catatan: ");
        scanner.nextLine(); // Consuming the \n character from the previous next() call
        String isi = scanner.nextLine();

        System.out.print("Masukkan nama file gambar: ");
        String namaFile = scanner.next();

        CatatanGambar catatanGambar = new CatatanGambar(judul, isi, namaFile);
        daftarCatatan.add(catatanGambar);
        System.out.println("Catatan gambar berhasil ditambahkan!");
    }

    private static void lihatSemuaCatatan() {
        if (daftarCatatan.isEmpty()) {
            System.out.println("Tidak ada catatan yang tersedia.");
            return;
        }

        System.out.println("===== Semua Catatan =====");
        for (Catatan catatan : daftarCatatan) {
            catatan.tampilkanInfo();
            System.out.println();
        }
    }

    private static void hapusCatatan() {
        if (daftarCatatan.isEmpty()) {
            System.out.println("Tidak ada catatan yang tersedia.");
            return;
        }

        System.out.println("===== Daftar Catatan =====");
        for (int i = 0; i < daftarCatatan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarCatatan.get(i).getJudul());
        }

        System.out.print("Pilih nomor catatan untuk dihapus (1-" + daftarCatatan.size() + "): ");
        int nomor = scanner.nextInt();

        if (nomor >= 1 && nomor <= daftarCatatan.size()) {
            daftarCatatan.remove(nomor - 1);
            System.out.println("Catatan berhasil dihapus.");
        } else {
            System.out.println("Nomor catatan tidak valid.");
        }
    }
}
