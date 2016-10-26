/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.StringTokenizer;

/**
 *
 * @author Alejandro
 */
public class DatabaseSQL {
    private static com.mysql.jdbc.Connection conexion;
    private String user = "";
    private String bd = user + "_proyecto621";
    private String password = "";
    private String host = "";
    private String server = "jdbc:mysql://" + host + "/" + bd;

    public DatabaseSQL() {
        /**
         * Leemos el archivo configuracion de los datos de acceso de la base de
         * datos
         */
        try {
            leer();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        /**
         * Asignamos los valores para los datos de conexion
         */
        
        try {
            System.out.println(bd);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(server);
            conexion = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.server, this.user, this.password);

            System.out.println("Conexion a base de datos " + this.server + " ...OK");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }

    public com.mysql.jdbc.Connection getConexion() {
        return this.conexion;
    }

    /**
     * Nos sirve para comprobar que los datos estan correctamente introducidos
     * @throws FileNotFoundException controla la excepcion si no encuentra archivo
     * @throws IOException
     *
     */
    public void leer() throws FileNotFoundException, IOException {
        BufferedReader h = new BufferedReader(new FileReader("setup.txt"));
        String z = null;
        while ((z = h.readLine()) != null) {

            StringTokenizer g = new StringTokenizer(z, ",");
            for (int i = 0; i < g.countTokens(); i++) {

                this.host = g.nextToken();
                this.user = g.nextToken();
                this.password = g.nextToken();
            }
            this.bd = user + "_proyecto621";
            this.server = "jdbc:mysql://" + this.host + "/" + this.bd;
        }
    }

}
