package muharremkilicervize;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class karsilamaEkrani extends javax.swing.JFrame {

    DB db = new DB();
    DefaultTableModel dtable = new DefaultTableModel();
    int tiklanan;
    //Tablo içerisine gelen verilerin id lerini almak için bir ArrayList oluşturuyoruz
    ArrayList<Integer> idd = new ArrayList<>();

    public karsilamaEkrani() {
        initComponents();
        //Bu form kapatıldığından giriş ekranına geri dön
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                db.kapat();
                new adminGirisi().setVisible(true);

            }
        });
        //Tabloya sütün başlıkları ekliyoruz.
        dtable.addColumn("ID");
        dtable.addColumn("Müşteri Adı");
        dtable.addColumn("Telefonu");
        dtable.addColumn("Cihaz Adı");
        dtable.addColumn("Cihaz Markası");
        dtable.addColumn("Cihaz Modeli");
        dtable.addColumn("Arızası");
        dtable.addColumn("DURUM");
        //Tablo içeriğini dolduruyoruz.
        tabloDoldur();
    }

    public void tabloDoldur() {
        //Öncelikle tablonun içerisinde bulunan verileri temizliyoruz
        dtable.setRowCount(0);
        try {
            /**
             * Durumu 1 olan ve marka modeli eşit olanları getiriyoruz Arizalar
             * ve cihazlar tablosundan, cihazlar.marka = arizalar.cihazModel
             * değerleri eşit olanları getiriyoruz Ayrıca arizalar.durum değeri
             * sadecee 1 olanları getiriyoruz
             */
            ResultSet rs2 = db.dataGetir("arizalar, cihazlar WHERE cihazlar.marka = arizalar.cihazModel AND arizalar.durum=1");
            while (rs2.next()) {
                //Tabloya gelen verileri ekliyoruz
                dtable.addRow(new String[]{rs2.getString("aid"), rs2.getString("madi"), rs2.getString("mtelefon"), rs2.getString("adi"), rs2.getString("marka"), rs2.getString("model"), rs2.getString("cihazArizasi"), rs2.getString("durum")});
                //Arıza id lerinin arraylist'e ekliyoruz ki durumunu değiştirmek için kullanabilelim.
                idd.add(rs2.getInt("aid"));
            }
        } catch (Exception e) {
            System.out.println("Tablo doldurma hatası:" + e);
        }
        jTable1.setModel(dtable);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAriza = new javax.swing.JButton();
        btnCihaz = new javax.swing.JButton();
        btnAra = new javax.swing.JButton();
        txtAra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnArsiv = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Müşteri Adı", "Telefonu", "Cihaz Adı", "Cihaz Markası", "Cihaz Modeli", "Arızası"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnAriza.setText("Yeni Arıza Kaydı");
        btnAriza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArizaActionPerformed(evt);
            }
        });

        btnCihaz.setText("Yeni Cihaz Kaydı");
        btnCihaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCihazActionPerformed(evt);
            }
        });

        btnAra.setText("Ara");
        btnAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });

        txtAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAraKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Yetkli Servis Programı");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Arızadaki Ürünler");

        btnArsiv.setText("Seçiliyi Arşive Gönder");
        btnArsiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArsivActionPerformed(evt);
            }
        });

        jLabel3.setText("Ürün Ara");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCihaz)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAriza))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtAra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAra))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnArsiv)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAriza)
                    .addComponent(btnCihaz)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAra)
                    .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnArsiv)
                .addGap(8, 8, 8))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCihazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCihazActionPerformed
        // TODO add your handling code here:
        cihazEkle ch = new cihazEkle();
        ch.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCihazActionPerformed

    private void btnArizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArizaActionPerformed
        // TODO add your handling code here:
        yeniArizaKaydi yn = new yeniArizaKaydi();
        yn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnArizaActionPerformed

    private void btnArsivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArsivActionPerformed
        // TODO add your handling code here:
        //Tablo üzerinden tıklanan satırın id numarasını alıyoruz.
        //Tiklanan id'nin durum'unu 0 yapıyoruz.
        tiklanan = idd.get(jTable1.getSelectedRow());
        String sql = "UPDATE arizalar "
                + "SET durum = 0 WHERE aid='" + tiklanan + "'";
        boolean durum2 = db.genelQuery(sql);
        if (durum2) {
            JOptionPane.showMessageDialog(rootPane, "Kayıt durum değiştirildi.");
            //Tabloyu yeniliyoruz.
            tabloDoldur();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Hata! Kayıt durumu değiştirilemedi.");
        }
    }//GEN-LAST:event_btnArsivActionPerformed

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed
        // TODO add your handling code here:
        String ara = txtAra.getText().trim();
        if (ara.length()<4) {
            //Fulltext özelliğinde 3 harften sonra arama  yapıyor.
            JOptionPane.showMessageDialog(this, "Arama yapabilmek için 3 harften fazla bir kelime girmelisiniz");
        }
        ResultSet rs2;
        try {
            //Prosedür'ü çağırıyoruz. Aranacak işlemi burada yapılıyor.
            //Full text özelliği ile arama yapıyoruz.
            rs2 = db.st.executeQuery("call arama ('" + txtAra.getText() + "')");
            while (rs2.next()) {
                //Tablodaki verileri siliyoruz
                dtable.setRowCount(0);
                //Tabloya veri ekliyoruz
                dtable.addRow(new String[]{rs2.getString("aid"), rs2.getString("madi"), rs2.getString("mtelefon"), rs2.getString("adi"), rs2.getString("marka"), rs2.getString("model"), rs2.getString("cihazArizasi"), rs2.getString("durum")});
                //Arıza id lerinin arraylist'e ekliyoruz ki durumunu değiştirmek için kullanabilelim.
                idd.add(rs2.getInt("aid"));
                jTable1.setModel(dtable);
            }
        } catch (SQLException ex) {
            System.out.println("Prosedür hatası" + ex);
        }

    }//GEN-LAST:event_btnAraActionPerformed

    private void txtAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAraKeyReleased
        // TODO add your handling code here:
        if (txtAra.getText().equals("")) {
            //txtAra içeriği boş ise tüm verileri getir.
            tabloDoldur();
        }
    }//GEN-LAST:event_txtAraKeyReleased

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
            java.util.logging.Logger.getLogger(karsilamaEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(karsilamaEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(karsilamaEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(karsilamaEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new karsilamaEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnAriza;
    private javax.swing.JButton btnArsiv;
    private javax.swing.JButton btnCihaz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAra;
    // End of variables declaration//GEN-END:variables
}
