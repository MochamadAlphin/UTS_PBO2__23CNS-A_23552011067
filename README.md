UTS Pemrograman Berorientasi Obyek 2
•	Mata Kuliah: Pemrograman Berorientasi Obyek 2
•	Dosen Pengampu: Muhammad Ikhwan Fathulloh
Profil
•	Nama: {Mochamad Alphin}
•	NIM: {23552011067}
•	Studi Kasus: { KASIR RESTORAN (NIM Belakang 7) }
Judul Studi Kasus
Kasir Restoran
Penjelasan Studi Kasus
Sistem kasir restoran ini dirancang untuk membantu staf dalam mengelola pemesanan dan pembayaran makanan dan minuman. Pelanggan dapat memesan berbagai jenis menu seperti makanan dan minuman, lalu sistem akan mencatat pesanan tersebut dan menghitung total harga yang harus dibayar, termasuk pajak 
 Penjelasan 4 Pilar OOP dalam Studi Kasus
1. Inheritance
Inheritance: Menu -> Makanan, Minuman
public abstract class ItemMakanan {
    protected String nama;
    protected double harga;

    public ItemMakanan(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public abstract double hitungHarga();
}

public class Menu extends ItemMakanan {
    private int id_menu;
    private Enums.JenisMenu jenis;

    public Menu(String nama, double harga, Enums.JenisMenu jenis) {
        super(nama, harga);
        this.jenis = jenis;
    }

    @Override
    public double hitungHarga() {
        return harga;
    }
}

public class Makanan extends Menu {
    public Makanan(String nama, double harga) {
        super(nama, harga, Enums.JenisMenu.MAKANAN);
    }

    @Override
    public double hitungHarga() {
        return getHarga() * 1.1;
    }
}

public class Minuman extends Menu {
    public Minuman(String nama, double harga) {
        super(nama, harga, Enums.JenisMenu.MINUMAN);
    }

    @Override
    public double hitungHarga() {
        return getHarga();
    }
}
•	Menu mewarisi dari ItemMakanan.
•	Makanan dan Minuman mewarisi dari Menu.
•	Dengan ini, seluruh subclass (Menu, Makanan, Minuman) otomatis memiliki atribut dan method dari superclass-nya (ItemMakanan dan Menu).
2. Encapsulation
Encapsulation: Informasi pemesanan
public class Pesanan {
    private String namaPelanggan;
    private Menu item;
    private int jumlah;

    public Pesanan(String namaPelanggan, Menu item, int jumlah) {
        this.namaPelanggan = namaPelanggan;
        this.item = item;
        this.jumlah = jumlah;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public Menu getItem() {
        return item;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getTotal() {
        return item.hitungHarga() * jumlah;
    }
}
Encapsulation menyembunyikan data dari luar dan hanya bisa diakses lewat getter/setter. Misalnya, data pesanan disimpan dalam objek Pesanan.	
3. Polymorphism
Polymorphism: Menu:hitungHarga()
// Override metode hitungHarga di subclass
public class Minuman extends Menu {
    public Minuman(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public double hitungHarga() {
        return harga + (harga * 0.1);
    }
}

Polymorphism memungkinkan metode hitungHarga() berperilaku berbeda tergantung pada objeknya. Misalnya, Minuman bisa memiliki tambahan pajak berbeda dari Makanan..
4. Abstract
Abstract Class: ItemMakanan
public abstract class ItemMakanan {
    protected String nama;
    protected double harga;

    public ItemMakanan(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public abstract double hitungHarga();
}

public class Menu extends ItemMakanan {
    public Menu(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public double hitungHarga() {
        return harga;
    }
}

ItemMakanan adalah kelas abstrak, yaitu kelas yang tidak bisa dibuat objeknya secara langsung dan biasanya digunakan sebagai kerangka dasar (template) untuk kelas-kelas turunannya
Demo Proyek
•	Github: 
•	Youtube: 

