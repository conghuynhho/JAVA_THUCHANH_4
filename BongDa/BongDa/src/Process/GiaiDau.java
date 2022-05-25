/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 *
 * @author conghuynh
 */
public class GiaiDau {
    
    public int ThemGiaiDau(String maGiai, String tenGiai, Date ngayBD, Date ngayKT)
            throws ClassNotFoundException, SQLException {
        
        String sqlQuery = "INSERT INTO GIAIDAU VALUES(?,?,?,?)";
        Connection con = ConnectionUtils.getMyConnection();
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setString(1, maGiai);
        ps.setString(2, tenGiai);
        ps.setDate(3, new java.sql.Date(ngayBD.getTime()));
        ps.setDate(4, new java.sql.Date(ngayKT.getTime()));
        int i = ps.executeUpdate(sqlQuery);
        return i;
    }
}
