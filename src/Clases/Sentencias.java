package Clases;

import static Clases.Conexion.con;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sentencias extends Conexion {
    Statement query;
    ResultSet rs;

    public Sentencias() {
        super();
    }

    public boolean insertarTabla(String sql) {
        try {
            query = con.createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    public boolean ModificarTabla(String sql) {
        try {
            query = con.createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    public ResultSet consulta(String sql) {
        try {
            query = con.createStatement();
            rs = query.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Sentencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean eliminarElemento(String sql) {
        try {
            query = con.createStatement();
            query.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }
}
