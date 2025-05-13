/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uts_pbo_kasirrestoran;

/**
 *
 * @author LENOVO
 */


public class Menu extends ItemMakanan {
    private int id_menu;
    private Enums.JenisMenu jenis;

    public Menu(String nama, double harga, Enums.JenisMenu jenis) {
        super(nama, harga);
        this.jenis = jenis;
    }

    public Menu(int id_menu, String nama, double harga, Enums.JenisMenu jenis) {
        super(nama, harga);
        this.id_menu = id_menu;
        this.jenis = jenis;
    }

    public int getIdMenu() {
        return id_menu;
    }

    public Enums.JenisMenu getJenis() {
        return jenis;
    }

    @Override
    public double hitungHarga() {
        return harga; 
    }

    @Override
    public String toString() {
        return "Menu{id_menu=" + id_menu + ", nama='" + nama + "', harga=" + hitungHarga() + ", jenis=" + jenis + "}";
    }
}

