/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uts_pbo_kasirrestoran;

/**
 *
 * @author LENOVO
 */
public class DetailPesanan {
    private int idMenu;
    private int jumlah;

    public DetailPesanan(int idMenu, int jumlah) {
        this.idMenu = idMenu;
        this.jumlah = jumlah;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public int getJumlah() {
        return jumlah;
    }

    @Override
    public String toString() {
        return "Menu ID: " + idMenu + ", Jumlah: " + jumlah;
    }
}

