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
    private static int idCounter = 0; 
    private int id;
    private String meja;
    private Enums.StatusMeja status;
    private int totalJumlah; 

    public Pesanan(String meja, Enums.StatusMeja status) {
        this.id = ++idCounter; 
        this.meja = meja;
        this.status = status;
        this.totalJumlah = 0; 
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

    public void addJumlah(int jumlah) {
        this.totalJumlah += jumlah;
    }

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
