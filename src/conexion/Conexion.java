package conexion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Cruz
 * @version 1.0.1
 */
public class Conexion {
    
    private String dbName; //Nombre de la base de datos
    private String url; //Direccion 
    private String user; //Nombre de usuario
    private String password; //Conraseña para la base de datos
    private String driver; //Driver correspondiente
    private Connection connect; //Objeto conexion para realizar las consultas
    
    /**
     * Constructor por defecto de la clase conexion
     */
    public Conexion(){
        this.dbName = "testing";
        this.url = "jdbc:mysql://localhost:3306/";
        this.user = "DevAccessRoot";
        this.password = "Lol_Cow69";
        this.driver = "com.mysql.cj.jdbc.Driver";
    }
    
    public Conexion(String dbName){
        this.dbName = dbName;
        this.url = "jdbc:mysql://localhost:3306/";
        this.user = "DevAccessRoot";
        this.password = "Lol_Cow69";
        this.driver = "com.mysql.cj.jdbc.Driver";
    }
    
    public Conexion(String dbName, String url, String user, String password, String driver){
        this.dbName = dbName;
        this.url = url;
        this.user = user;
        this.password = password;
        this.driver = driver;
    }
    
    public Conexion(String dbName, String ipDirecction, String port, String user, String password, String driver){
        this.dbName = dbName;
        this.url = "jdbc:mysql://" + ipDirecction + ":" + port;
        this.user = user;
        this.password = password;
        this.driver = driver;
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url + dbName, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "La conexion a la base de datos " + dbName + " fallo");
            JOptionPane.showMessageDialog(null, "|ERROR|:" + e.getMessage());
        }
        
        return connect;
    }
    
    public void desconectar(){
        try {
            connect.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la desconexion a la base de datos");
        }
    }
    
}