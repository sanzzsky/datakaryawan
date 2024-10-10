/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import Controller.koneksidatabase;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Data extends javax.swing.JFrame {
    
    public Statement st;
    public ResultSet rs;
    private Connection koneksi;
    
    public Data() {
          initComponents();
        
        // Panggil metode getkoneksi() dari kelas koneksidatabase
        koneksi = koneksidatabase.getkoneksi();
        if (koneksi == null) {
           JOptionPane.showMessageDialog(this, "Gagal terkoneksi ke database", "Error", JOptionPane.ERROR_MESSAGE);
           return; // Tetap melanjutkan eksekusi metode tanpildata() setelah menampilkan pesan kesalahan
        }
        tampildata();
    }
    
    private void bersih(){
        jTextID.setText("");
        jTextNAMA_.setText("");
        jTextJABATAN.setText("");
        jTextALAMAT.setText("");
        jTextNOTLP.setText("");
        
        jButtonSIMPAN.setText("simpan");
        jTextID.setEditable(true);
    }
    
    private void caridata() {
    try {
        st = koneksi.createStatement();
        rs = st.executeQuery("SELECT * FROM tbldatakaryawan WHERE " + jComboBoxCARI.getSelectedItem().toString() + " LIKE '%" + jTextCARI.getText() + "%'");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("JABATAN");
        model.addColumn("ALAMAT");
        model.addColumn("NO. TELEPON");

        while (rs.next()) {
            Object[] data = {
                rs.getString("ID"),
                rs.getString("NAMA"),
                rs.getString("JABATAN"),
                rs.getString("ALAMAT"),
                rs.getString("NO_HP")
            };
            model.addRow(data);
        }

        // Set the table model after fetching all data
        jTableDATA.setModel(model);
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
         


private void tampildata() {
    try {
        st = koneksi.createStatement();
        rs = st.executeQuery("SELECT * FROM tbldatakaryawan order by NAMA asc");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NO.");
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("JABATAN");
        model.addColumn("ALAMAT");
        model.addColumn("NO. TELEPON");
        
        int no = 1;
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        model.setRowCount(0);

        while (rs.next()) {
            Object[] data = {
                no ++,
                rs.getString("ID"),
                rs.getString("NAMA"),
                rs.getString("JABATAN"),
                rs.getString("ALAMAT"),
                rs.getString("NO_HP")
            };
            model.addRow(data);
        }
        
        // Set the table model after fetching all data
        jTableDATA.setModel(model);
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    } finally {
        // Close the statement and result set in the finally block
        try {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextID = new javax.swing.JTextField();
        jTextNAMA_ = new javax.swing.JTextField();
        jTextJABATAN = new javax.swing.JTextField();
        jTextALAMAT = new javax.swing.JTextField();
        jTextNOTLP = new javax.swing.JTextField();
        jButtonSIMPAN = new javax.swing.JButton();
        jButtonHAPUS = new javax.swing.JButton();
        jButtonBATAL = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDATA = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxCARI = new javax.swing.JComboBox<>();
        jTextCARI = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("ID");

        jLabel2.setText("NAMA ");

        jLabel3.setText("JABATAN");

        jLabel4.setText("ALAMAT");

        jLabel5.setText("NO. TELEPON");

        jButtonSIMPAN.setText("SIMPAN");
        jButtonSIMPAN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSIMPAN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSIMPANActionPerformed(evt);
            }
        });

        jButtonHAPUS.setText("HAPUS");
        jButtonHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHAPUSActionPerformed(evt);
            }
        });

        jButtonBATAL.setText("BATAL");
        jButtonBATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBATALActionPerformed(evt);
            }
        });

        jTableDATA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "JABATAN", "ALAMAT", "NO. TELEPON"
            }
        ));
        jTableDATA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDATAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDATA);

        jLabel6.setText("CARI DATA");

        jComboBoxCARI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAMA" }));
        jComboBoxCARI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCARIActionPerformed(evt);
            }
        });

        jTextCARI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextCARIKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("TABLE DATA KARYAWAN");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("\tDATA KARYAWAN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextNAMA_)
                        .addComponent(jTextJABATAN)
                        .addComponent(jTextALAMAT)
                        .addComponent(jTextNOTLP, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSIMPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButtonHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBATAL, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxCARI, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextCARI, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(264, 264, 264))))
            .addGroup(layout.createSequentialGroup()
                .addGap(474, 474, 474)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextNAMA_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextJABATAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextNOTLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSIMPAN)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonHAPUS)
                        .addComponent(jButtonBATAL))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jComboBoxCARI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextCARI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCARIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCARIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCARIActionPerformed

    private void jButtonSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSIMPANActionPerformed
    try {
        st = koneksi.createStatement();
        if (jTextID.getText().equals("") ||
            jTextNAMA_.getText().equals("") ||
            jTextJABATAN.getText().equals("") ||
            jTextALAMAT.getText().equals("") ||
            jTextNOTLP.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong", "Validasi data", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (jButtonSIMPAN.getText().equals("SIMPAN")) {
            String cek = "SELECT * FROM tbldatakaryawan WHERE ID = '" + jTextID.getText() + "'";
            rs = st.executeQuery(cek);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Ups... ID sudah ada");
            } else {
                String sql = "INSERT INTO tbldatakaryawan VALUES ('" + jTextID.getText() +
                        "','" + jTextNAMA_.getText() +
                        "','" + jTextJABATAN.getText() +
                        "','" + jTextALAMAT.getText() +
                        "','" + jTextNOTLP.getText() + "')";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                JOptionPane.showMessageDialog(null, "selamat");
                bersih();
                tampildata();
            }
        }else{
            String update = "UPDATE tbldatakaryawan SET NAMA = '" + jTextNAMA_.getText() + "', JABATAN = '" + jTextJABATAN.getText() + "',ALAMAT = '" + jTextALAMAT.getText() +
                    "', NO_HP   = '" + jTextNOTLP.getText() + "' WHERE ID = '" + jTextID.getText() + "'";
            st.executeLargeUpdate(update);
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            bersih();
            tampildata();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    } finally {
        // Pastikan untuk menutup statement dan result set
        try {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_jButtonSIMPANActionPerformed

    private void jTableDATAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDATAMouseClicked
        jTextID.setText(jTableDATA.getValueAt(jTableDATA.getSelectedRow(), 1).toString());
        jTextNAMA_.setText(jTableDATA.getValueAt(jTableDATA.getSelectedRow(), 2).toString());
        jTextJABATAN.setText(jTableDATA.getValueAt(jTableDATA.getSelectedRow(), 3).toString());
        jTextALAMAT.setText(jTableDATA.getValueAt(jTableDATA.getSelectedRow(), 4).toString());
        jTextNOTLP.setText(jTableDATA.getValueAt(jTableDATA.getSelectedRow(), 5).toString());
        
        jTextID.setEditable(false);
        jButtonSIMPAN.setText("UBAH");// TODO add your handling code here:
    }//GEN-LAST:event_jTableDATAMouseClicked

    private void jButtonHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHAPUSActionPerformed
      if (jTextID.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan dihapus!");
    } else {
        int jawab = JOptionPane.showConfirmDialog(null, "Data ini akan dihapus, lanjutkan?", "Konfirmasi", JOptionPane.YES_OPTION);
        if (jawab == 0) {
            try {
                st = koneksi.createStatement();
                String sql = "DELETE FROM tbldatakaryawan WHERE ID = '" + jTextID.getText() + "'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                tampildata();
                bersih();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            } finally {
                // Pastikan untuk menutup statement
                try {
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }// TODO add your handling code here:
    }//GEN-LAST:event_jButtonHAPUSActionPerformed

    private void jButtonBATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBATALActionPerformed
        bersih();// TODO add your handling code here:
    }//GEN-LAST:event_jButtonBATALActionPerformed

    private void jTextCARIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCARIKeyPressed
        caridata(); // TODO add your handling code here:
    }//GEN-LAST:event_jTextCARIKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBATAL;
    private javax.swing.JButton jButtonHAPUS;
    private javax.swing.JButton jButtonSIMPAN;
    private javax.swing.JComboBox<String> jComboBoxCARI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDATA;
    private javax.swing.JTextField jTextALAMAT;
    private javax.swing.JTextField jTextCARI;
    private javax.swing.JTextField jTextID;
    private javax.swing.JTextField jTextJABATAN;
    private javax.swing.JTextField jTextNAMA_;
    private javax.swing.JTextField jTextNOTLP;
    // End of variables declaration//GEN-END:variables
}
