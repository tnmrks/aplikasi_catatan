import java.util.ArrayList;
import java.util.Scanner;

class Catatan {
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

    public void setIsi(String isi) {
        this.isi = isi;
    }
}

public class AplikasiCatatan {
    private static ArrayList<Catatan> daftarCatatan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("===== Aplikasi Pengelolaan Catatan =====");
            System.out.println("1. Tambah Catatan");
            System.out.println("2. Lihat Catatan");
            System.out.println("3. Hapus Catatan");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi (1/2/3/4): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahCatatan();
                    break;
                case 2:
                    lihatCatatan();
                    break;
                case 3:
                    hapusCatatan();
                    break;
                case 4:
                    berjalan = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }

            System.out.println();
        }

        System.out.println("Terima kasih telah menggunakan Aplikasi Pengelolaan Catatan!");
    }

    private static void tambahCatatan() {
        System.out.print("Masukkan judul catatan: ");
        String judul = scanner.next();

        System.out.print("Masukkan isi catatan: ");
        scanner.nextLine(); // Consuming the \n character from the previous next() call
        String isi = scanner.nextLine();

        Catatan catatan = new Catatan(judul, isi);
        daftarCatatan.add(catatan);
        System.out.println("Catatan berhasil ditambahkan!");
    }

    private static void lihatCatatan() {
        if (daftarCatatan.isEmpty()) {
            System.out.println("Tidak ada catatan yang tersedia.");
            return;
        }

        System.out.println("===== Daftar Catatan =====");
        for (int i = 0; i < daftarCatatan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarCatatan.get(i).getJudul());
        }

        System.out.print("Pilih nomor catatan (1-" + daftarCatatan.size() + "): ");
        int nomor = scanner.nextInt();

        if (nomor >= 1 && nomor <= daftarCatatan.size()) {
            Catatan catatan = daftarCatatan.get(nomor - 1);
            System.out.println("\n===== " + catatan.getJudul() + " =====");
            System.out.println(catatan.getIsi());
        } else {
            System.out.println("Nomor catatan tidak valid.");
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


