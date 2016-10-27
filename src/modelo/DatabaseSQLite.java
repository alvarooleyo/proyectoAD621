/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class DatabaseSQLite {
 Connection conexion;
    
    public DatabaseSQLite(){
        /**
         * Asignamos el conector y los datos de la conexión. Estableciendo un control de errores para comprobar
         * el estado de la conexión.
         */
        try{
            Class.forName("org.sqlite.JDBC");
            conexion=DriverManager.getConnection("jdbc:sqlite:db/Database.db3");
       }catch(SQLException ex){
            System.err.println("No se ha conectado"+ex.getMessage());
       }catch(ClassNotFoundException e){
            System.err.println("No se encuentra la clase" +e.getMessage());
       }
    }
    
    public Connection getConnection(){
            return this.conexion;
        }
    
    
    }   