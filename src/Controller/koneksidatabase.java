package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksidatabase {
    private static Connection koneksi;

    public static Connection getkoneksi() {
        try {
            if (koneksi == null || koneksi.isClosed()) {
                String url = "jdbc:mysql://localhost:3307/dbkaryawan";
                String username = "root";
                String password = "";

                // Ganti com.mysql.jdbc.Driver dengan com.mysql.cj.jdbc.Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                koneksi = DriverManager.getConnection(url, username, password);
                System.out.println("Berhasil terkoneksi ke database!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();  // Tambahkan baris ini
            JOptionPane.showMessageDialog(null, "Error koneksi: " + e.getMessage());
        }
        return koneksi;
    }
}