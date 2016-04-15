package muharremkilicervize;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public final class DB {

    String driver = "com.mysql.jdbc.Driver";
    String dbName = "vize1";

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public DB() {
        baglan();
    }

    public DB(String dbName) {
        if (kontrol()) {
            this.dbName = dbName;
            baglan();
        } else {
            JOptionPane.showMessageDialog(null, "Lütfen Bağlantınızı Kontrol Ediniz");
        }
    }

    public void baglan() {
        try {
            if (kontrol()) {
                // Bağlantı nesnesi kontrol ediliyor
                Class.forName(driver);
                /*UTF8 Kodlama*/
                conn = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName + "?useUnicode=true&characterEncoding=UTF-8", "root", "");
                st = conn.createStatement();
                System.out.println("Bağlantı başladı.");
            } else {
                JOptionPane.showMessageDialog(null, "Lütfen Bağlantınızı Kontrol Ediniz");
                System.exit(0);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Bağlantı Hatası : " + e);
        }
    }

    public static boolean kontrol() {
        boolean durum = false;
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            // trying to retrieve data from the source. If offline, this line will fail:
            Object objData = urlConnect.getContent();
            durum = true;
        } catch (MalformedURLException ex) {
            //Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            // Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return durum;
    }

    /* Procedure getirme*/
    public ResultSet proOku(String sorgu) {
        try {
            rs = st.executeQuery("call" + sorgu);
        } catch (Exception ex) {
            System.err.println("Procedure SQL Okuma Hatası: " + ex);
            JOptionPane.showMessageDialog(null, "Procedure SQL Okuma Hatası");
        }
        return rs;
    }

    public void kapat() {
        try {
            conn.close();
            st.close();
        } catch (Exception e) {
            System.err.println("Bağlantı Kapatma Hatası : " + e);
        }
    }

    // Tüm datları getirme fonksiyonu
    public ResultSet dataGetir(String tableName) {
        try {
            rs = st.executeQuery("select *from " + tableName);
        } catch (Exception e) {
            System.err.println("Data Getirme Hatası : " + e);
        }
        return rs;
    }

    // Genel query fonksiyonu
    public boolean genelQuery(String query) {
        boolean durum = false;
        try {
            durum = st.execute(query);
            durum = true;
        } catch (Exception e) {
            System.err.println("genelQuery Hatası : " + e);
        }
        return durum;
    }

    //MD5 Şifreleme
    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
