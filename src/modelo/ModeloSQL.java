/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class ModeloSQL extends DatabaseSQL{
    
    public DefaultTableModel getTablaBar() throws SQLException {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Licencia", "Nombre", "Domicilio"}; 
         try {
            Connection cn= this.getConexion();
            CallableStatement st= cn.prepareCall("");
            
            st.executeQuery();
            ResultSet res = st.getResultSet();
            res.first();
            Object[] fila= new Object[3];
            while(!res.isAfterLast()){
                fila[0]= res.getString("licenciaFiscal");
                fila[0]= res.getString("nombreBar");
                fila[0]= res.getString("domicilioBar");
                
                tablemodel.addRow(fila);
                res.next();
            }
            
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
         return tablemodel;
    }
    
}
