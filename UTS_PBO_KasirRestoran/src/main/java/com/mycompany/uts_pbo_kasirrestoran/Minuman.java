/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uts_pbo_kasirrestoran;

/**
 *
 * @author LENOVO
 */

public class Minuman extends Menu {
    public Minuman(String nama, double harga) {
        super(nama, harga, Enums.JenisMenu.MINUMAN);
    }

    @Override
    public double hitungHarga() {
        return getHarga(); // tidak ada pajak
    }
}
