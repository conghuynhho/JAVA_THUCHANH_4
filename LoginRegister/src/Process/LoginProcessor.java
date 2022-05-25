/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.ConnectionUtils;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author conghuynh file in this process package. will handle some process to
 * database
 */
public class LoginProcessor {

    public int loginInto(String username, String password) {
        int i = 0;
//        String queryString = "SELECT username,password FROM USERDB WHERE username='" + username + "' AND password='" + password + "'";
        String queryString = "SELECT * FROM USERDB";

        try ( Connection con = ConnectionUtils.getMyConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);
            
            System.out.println(rs.next());
            while (rs.next()) {
                System.out.println("next");
                String uname = rs.getString("USERNAME");
                System.out.println(uname);
                if(uname.length() > 0) i = 1;
            }
            con.close();
            System.out.println("Out of next");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e );
            return i;
        } catch (Exception e) {
            System.out.println("Error: " + e );
            return i;
        }
        return i;
    }

}
