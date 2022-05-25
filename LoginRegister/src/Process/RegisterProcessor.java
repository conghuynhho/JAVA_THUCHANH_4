/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author conghuynh
 */
public class RegisterProcessor {
    public int createNewUser(String username, String password) {
        int i = 0;
//        String queryString = "SELECT username,password FROM USERDB WHERE username='" + username + "' AND password='" + password + "'";
        String queryString = "INSERT INTO USERDB VALUES ('" + username +"','" + password + "')";

        try ( Connection con = ConnectionUtils.getMyConnection()){
            Statement stmt = con.createStatement();
            i = stmt.executeUpdate(queryString);
            con.close();
            
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
