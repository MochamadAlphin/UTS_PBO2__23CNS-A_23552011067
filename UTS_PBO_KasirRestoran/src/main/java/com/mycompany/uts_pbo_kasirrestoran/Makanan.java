/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uts_pbo_kasirrestoran;

/**
 *
 * @author LENOVO
 */

public class Makanan extends Menu {
    public Makanan(String nama, double harga) {
        super(nama, harga, Enums.JenisMenu.MAKANAN);
    }

    @Override
    public double hitungHarga() {
        return getHarga() * 1.1; // contoh: pajak 10%
    }
}
