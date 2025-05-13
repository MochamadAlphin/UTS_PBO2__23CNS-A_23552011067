/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uts_pbo_kasirrestoran;

/**
 *
 * @author LENOVO
 */
public class Pesanan {
    private static int idCounter = 0; // Counter untuk auto increment
    private int id;
    private String meja;
    private Enums.StatusMeja status;
    private int totalJumlah; // Menyimpan jumlah total pesanan

    // Constructor untuk menambahkan pesanan dengan meja dan status
    public Pesanan(String meja, Enums.StatusMeja status) {
        this.id = ++idCounter; // Auto increment id
        this.meja = meja;
        this.status = status;
        this.totalJumlah = 0; // Inisialisasi jumlah dengan 0
    }

    public int getId() {
        return id;
    }

    public String getMeja() {
        return meja;
    }

    public Enums.StatusMeja getStatus() {
        return status;
    }

    // Menambahkan jumlah pesanan
    public void addJumlah(int jumlah) {
        this.totalJumlah += jumlah;
    }

    // Mendapatkan total jumlah
    public int getTotalJumlah() {
        return totalJumlah;
    }

    @Override
    public String toString() {
        return "Pesanan{" +
               "id=" + id +
               ", meja='" + meja + '\'' +
               ", status=" + status +
               ", totalJumlah=" + totalJumlah +
               '}';
    }
}
