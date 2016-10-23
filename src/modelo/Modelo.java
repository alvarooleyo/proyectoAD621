/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class Modelo extends DatabaseSQLite{
    
    public DefaultTableModel getTablaBar(){
        
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0; // Indica la cantidad de filas de la tabla.
      String[] columNames = {"Licencia", "Nombre", "Domicilio"}; 
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as Total FROM Bar");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
        }catch(SQLException e){
           System.err.println( e.getMessage() );
           System.err.println("No entra aqui");
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][3];
        try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT licenciaFiscal, nombreBar, domicilioBar FROM Bar");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString("licenciaFiscal");
                data[i][1] = res.getString("nombreBar");
                data[i][2] = res.getString("domicilioBar");
            i++;
         }
         res.close();
         //se añade la matriz de datos en el DefaultTableModel
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    }
}

