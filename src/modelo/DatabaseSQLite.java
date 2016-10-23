/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alejandro
 */
public class DatabaseSQLite {
 Connection conexion;
    
    public DatabaseSQLite(){
        
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