package Controllers;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {

    private Connection conn;
    private Statement instruc;
    private String database = "Data/todo.db";

    public conexion() {
        try {
            String conex = "jdbc:sqlite:src/" + database;
            conn = DriverManager.getConnection(conex);
            instruc = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exec(String sql) {
        try {
            instruc.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet get(String sql) {
        ResultSet res = null;
        try {
            res = instruc.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public void close(){
        try {
            instruc.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
