/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;
import ConnectDB.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author conghuynh
 * file in this process package. will handle some process to database
 */
public class DoiBong {
    
    public int ThemDoiBong(String maDoi, String tenDoi, String quocGia)
            throws ClassNotFoundException, SQLException {
        String sqlQuery = "INSERT INTO DOIBONG VALUES('"
                + maDoi + "','" + tenDoi + "','" + quocGia + "')";
        System.out.println(sqlQuery);
        int i = 0;
        Connection con = ConnectionUtils.getMyConnection();
        Statement ps = con.createStatement();
        i = ps.executeUpdate(sqlQuery);
        return i;

    }
    
}
