# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: {Mochamad Alphin}</li>
  <li>NIM: {23552011067}</li>
  <li>Studi Kasus: { KASIR RESTORAN (NIM Belakang 7) }</li>
</ul>

## Judul Studi Kasus
<p>Kasir Restorant</p>

## Penjelasan Studi Kasus
<p>LSistem kasir restoran ini dirancang untuk membantu staf dalam mengelola pemesanan dan pembayaran makanan dan minuman. Pelanggan dapat memesan berbagai jenis menu seperti makanan dan minuman, lalu sistem akan mencatat pesanan tersebut dan menghitung total harga yang harus dibayar, termasuk pajak </p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>. Inheritance
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
</p>

### 2. Encapsulation
<p>Encapsulation
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
</p>

### 3. Polymorphism
<p>Polymorphism: Menu:hitungHarga()
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
.</p>

### 4. Abstract
<p>4. Abstract
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
.</p>

## Demo Proyek
<ul>
  <li>Github: <a href="">[Github](https://github.com/MochamadAlphin/UTS_PBO2__MochamadAlphin_23552011067/blob/main/README.md)</a></li>
  <li>Youtube: <a href="">Youtube</a></li>
</ul>
