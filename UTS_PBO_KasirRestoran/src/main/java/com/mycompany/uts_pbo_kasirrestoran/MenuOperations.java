/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uts_pbo_kasirrestoran;

/**
 *
 * @author LENOVO
 */


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuOperations {

    public void addMenu(Menu menu) {
        String query = "INSERT INTO Menu (Nama_Menu, Harga_Menu, Jenis_Menu) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, menu.getNama());
            stmt.setDouble(2, menu.getHarga());
            stmt.setString(3, menu.getJenis().name());
            stmt.executeUpdate();
            System.out.println("Menu berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Menu> getMenus() {
        List<Menu> menus = new ArrayList<>();
        String query = "SELECT * FROM Menu";
        try (Statement stmt = DatabaseConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int idMenu = rs.getInt("id_menu");
                String namaMenu = rs.getString("Nama_Menu");
                double hargaMenu = rs.getDouble("Harga_Menu");
                String jenisMenuString = rs.getString("Jenis_Menu");

                try {
                    Enums.JenisMenu jenisMenu = Enums.JenisMenu.valueOf(jenisMenuString.toUpperCase());
                    Menu menu = new Menu(idMenu, namaMenu, hargaMenu, jenisMenu);
                    menus.add(menu);
                } catch (IllegalArgumentException e) {
                    System.err.println("Jenis menu tidak valid: " + jenisMenuString);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }

    public void updateMenu(int id, Menu menu) {
        String query = "UPDATE Menu SET Nama_Menu = ?, Harga_Menu = ?, Jenis_Menu = ? WHERE id_menu = ?";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, menu.getNama());
            stmt.setDouble(2, menu.getHarga());
            stmt.setString(3, menu.getJenis().name());
            stmt.setInt(4, id);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Menu berhasil diupdate!");
            } else {
                System.out.println("Menu dengan ID " + id + " tidak ditemukan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMenu(int id) {
        String query = "DELETE FROM Menu WHERE id_menu = ?";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Menu berhasil dihapus!");
            } else {
                System.out.println("Menu dengan ID " + id + " tidak ditemukan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
public void addPesanan(Pesanan pesanan, int idMenu, int jumlah) {
    try (Connection conn = DatabaseConnection.getConnection()) {
        conn.setAutoCommit(false);

        // Step 1: Insert ke tabel pesanan
        String pesananQuery = "INSERT INTO pesanan (Meja, Status) VALUES (?, ?)";

        int generatedIdPesanan = -1;
        try (PreparedStatement pesananStmt = conn.prepareStatement(pesananQuery, Statement.RETURN_GENERATED_KEYS)) {
            pesananStmt.setString(1, pesanan.getMeja());
            pesananStmt.setString(2, pesanan.getStatus().name());
            pesananStmt.executeUpdate();

            // Ambil generated ID dari tabel pesanan
            ResultSet generatedKeys = pesananStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedIdPesanan = generatedKeys.getInt(1);
            }
        }

        // Step 2: Insert ke detail_pesanan dengan menambahkan jumlah
        String detailQuery = "INSERT INTO detail_pesanan (Id_Pesanan, Id_Menu, Jumlah) VALUES (?, ?, ?)";
        try (PreparedStatement detailStmt = conn.prepareStatement(detailQuery)) {
            detailStmt.setInt(1, generatedIdPesanan);  // ID Pesanan yang baru dimasukkan
            detailStmt.setInt(2, idMenu);              // ID Menu yang dipilih
            detailStmt.setInt(3, jumlah);              // Jumlah yang dipesan
            detailStmt.executeUpdate();
        }

        // Commit transaksi
        conn.commit();
        System.out.println("Pesanan berhasil ditambahkan.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public List<Pesanan> getPesanan() {
    List<Pesanan> pesananList = new ArrayList<>();
    String query = "SELECT p.meja, p.status, d.id_menu, d.jumlah " +
                   "FROM pesanan p " +
                   "JOIN detail_pesanan d ON p.id_pesanan = d.id_pesanan";

    try (Statement stmt = DatabaseConnection.getConnection().createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            String meja = rs.getString("meja");
            Enums.StatusMeja statusMeja = Enums.StatusMeja.valueOf(rs.getString("status").toUpperCase());
            int idMenu = rs.getInt("id_menu");
            int jumlah = rs.getInt("jumlah");

            Pesanan pesanan = pesananList.stream()
                .filter(p -> p.getMeja().equals(meja) && p.getStatus().equals(statusMeja))
                .findFirst()
                .orElseGet(() -> {
                    Pesanan newPesanan = new Pesanan(meja, statusMeja);
                    pesananList.add(newPesanan);
                    return newPesanan;
                });

            pesanan.addJumlah(jumlah); // Assuming adding quantity to total
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return pesananList;
}}



