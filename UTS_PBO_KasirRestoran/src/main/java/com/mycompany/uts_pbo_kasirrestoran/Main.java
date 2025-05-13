/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uts_pbo_kasirrestoran;

/**
 *
 * @author LENOVO
 */


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static MenuOperations menuOperations = new MenuOperations();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Menu Kasir Restoran ---");
            System.out.println("1. Tambahkan Menu");
            System.out.println("2. Lihat Semua Menu");
            System.out.println("3. Update Menu");
            System.out.println("4. Hapus Menu");
            System.out.println("5. Tambahkan Pesanan");
            System.out.println("6. Lihat Semua Pesanan");
            System.out.println("0. Exit");
            System.out.print("Pilih opsi: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Harap masukkan angka!");
                scanner.next(); 
            }
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: 
                    System.out.print("Masukkan Nama Menu: ");
                    String namaMenu = scanner.nextLine();

                    double hargaMenu = 0;
                    while (true) {
                        try {
                            System.out.print("Masukkan Harga Menu: ");
                            hargaMenu = scanner.nextDouble();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Input tidak valid. Silakan masukkan angka.");
                            scanner.next();
                        }
                    }

                    Enums.JenisMenu jenisMenu = null;
                    while (jenisMenu == null) {
                        try {
                            System.out.print("Masukkan Jenis Menu (MAKANAN/MINUMAN): ");
                            jenisMenu = Enums.JenisMenu.valueOf(scanner.next().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Jenis menu tidak valid. Silakan coba lagi.");
                        }
                    }

                    Menu menuBaru;
                    if (jenisMenu == Enums.JenisMenu.MAKANAN) {
                        menuBaru = new Makanan(namaMenu, hargaMenu);
                    } else {
                        menuBaru = new Minuman(namaMenu, hargaMenu);
                    }

                    menuOperations.addMenu(menuBaru);
                    break;

                case 2: 
                    System.out.println("Daftar Menu:");
                    List<Menu> menus = menuOperations.getMenus();
                    menus.forEach(System.out::println);
                    break;

                case 3: 
                    System.out.print("Masukkan ID Menu untuk diupdate: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Masukkan Nama Menu Baru: ");
                    String newNamaMenu = scanner.nextLine();

                    double newHargaMenu = 0;
                    while (true) {
                        try {
                            System.out.print("Masukkan Harga Menu Baru: ");
                            newHargaMenu = scanner.nextDouble();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Input tidak valid. Silakan masukkan angka.");
                            scanner.next();
                        }
                    }

                    Enums.JenisMenu newJenisMenu = null;
                    while (newJenisMenu == null) {
                        try {
                            System.out.print("Masukkan Jenis Menu Baru (MAKANAN/MINUMAN): ");
                            newJenisMenu = Enums.JenisMenu.valueOf(scanner.next().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Jenis menu tidak valid. Silakan coba lagi.");
                        }
                    }

                    Menu updatedMenu;
                    if (newJenisMenu == Enums.JenisMenu.MAKANAN) {
                        updatedMenu = new Makanan(newNamaMenu, newHargaMenu);
                    } else {
                        updatedMenu = new Minuman(newNamaMenu, newHargaMenu);
                    }

                    menuOperations.updateMenu(idUpdate, updatedMenu);
                    break;

                case 4: 
                    System.out.print("Masukkan ID Menu untuk dihapus: ");
                    int idDelete = scanner.nextInt();
                    menuOperations.deleteMenu(idDelete);
                    break;

       case 5:
    System.out.print("Masukkan ID Menu: ");
    int idMenu = scanner.nextInt(); 
                    
    System.out.print("Masukkan Jumlah: ");
    int jumlah = scanner.nextInt();
                    
    System.out.print("Masukkan Meja: ");
    String meja = scanner.next(); 

    Enums.StatusMeja statusMeja = null;
    while (statusMeja == null) {
        try {
            System.out.print("Masukkan Status Meja (TERSEDIA/TIDAK_TERSEDIA): ");
            statusMeja = Enums.StatusMeja.valueOf(scanner.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Status meja tidak valid. Silakan coba lagi.");
        }
    }

    Pesanan pesanan = new Pesanan(meja, statusMeja);

    menuOperations.addPesanan(pesanan, idMenu, jumlah); 
    break;


                case 6:
                    System.out.println("Daftar Pesanan:");
                    List<Pesanan> pesananList = menuOperations.getPesanan();
                    pesananList.forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Keluar...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }

        } while (choice != 0);

        scanner.close();
        DatabaseConnection.closeConnection();
    }
}
