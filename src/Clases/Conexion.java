package Clases;

import java.sql.*;
import java.util.logging.*;

/**
 * Esta clase permite la conexion con la base de datos tiene 2 métodos
 * constructores el primero es utilizado para conectarse a una base de datos en
 * especifica el segundo es utlizado para conectarse a una base de datos de
 * forma predeterminada
 */
public class Conexion {

    private String base;
    private String usuario;
    private String host;
    private String contraseña;
    public static Connection con;

    public Conexion(String base, String usuario, String host, String contraseña) {
        this.base = base;
        this.usuario = usuario;
        this.host = host;
        this.contraseña = contraseña;
    }

    //Debe ser modificado en producccion
    public Conexion() {
        this.base = "accidentgeoproject";
        this.usuario = "root";
        this.host = "localhost:3306";
        this.contraseña = "Giumax_bd";
    }

    /*
    * Este método permite conectarnos con la base de datos
     */
    public boolean conectar() {
        try {
            String url = "jdbc:mysql://" + this.host + "/" + this.base;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, contraseña);
            return true;
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
            return false;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }
    /*
    * Este método permite cerrar la conexión con la base de datos
    */
    public void cerrar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
