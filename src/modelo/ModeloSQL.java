/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class ModeloSQL extends DatabaseSQL{
    
    public DefaultTableModel getTablaBar() {
        DefaultTableModel tabla = new DefaultTableModel();
        Object[] columName = null;
        Object[][] data = null;
        int registros = 0;
        try {
            //llamamos a la funcion almacenada en la base de datos
            CallableStatement pstm = this.getConexion().prepareCall("{?=call totalBar}");
            //detallamos que la variable de salida va a ser de tipo Integer
            pstm.registerOutParameter(1, Types.INTEGER);
            //ejecutamos la llamada a la funcion
            pstm.executeUpdate();
            //recuperamos el resultado y lo asignamos a una variable 
            registros = pstm.getInt(1);
        } catch (SQLException ex) {

        }

        try {
            //Preparas la llamada al procedimiento que te devuelve la consulta
            CallableStatement cstm = this.getConexion().prepareCall("{call consultaBar()}");
            //Ejecutas el procedimiento
            ResultSet re = cstm.executeQuery();
            //Recoges los metadatos que te devuelve la consulta
            ResultSetMetaData rsp = re.getMetaData();

            int col = rsp.getColumnCount();
            columName = new String[col];

            for (int i = 1; i <= col; i++) {
                columName[i - 1] = rsp.getColumnName(i);
            }
            data = new String[registros][col];

            int j = 0;
            while (re.next()) {
                for (int h = 0; h < col; h++) {
                    data[j][h] = re.getString(columName[h].toString());
                }
                j++;
            }

        } catch (SQLException ex) {

        }

        tabla.setDataVector(data, columName);
        return tabla;
    }
    
    public DefaultTableModel getTablaInfoBar() {
        DefaultTableModel tabla = new DefaultTableModel();
        Object[] columName = null;
        Object[][] data = null;
        int registros = 0;
        try {
            //llamamos a la funcion almacenada en la base de datos
            CallableStatement pstm = this.getConexion().prepareCall("{?=call totalFunciones}");
            //detallamos que la variable de salida va a ser de tipo Integer
            pstm.registerOutParameter(1, Types.INTEGER);
            //ejecutamos la llamada a la funcion
            pstm.executeUpdate();
            //recuperamos el resultado y lo asignamos a una variable 
            registros = pstm.getInt(1);
        } catch (SQLException ex) {

        }

        try {
            //Preparas la llamada al procedimiento que te devuelve la consulta
            CallableStatement cstm = this.getConexion().prepareCall("{call consultaFunciones()}");
            //Ejecutas el procedimiento
            ResultSet re = cstm.executeQuery();
            //Recoges los metadatos que te devuelve la consulta
            ResultSetMetaData rsp = re.getMetaData();

            int col = rsp.getColumnCount();
            columName = new String[col];

            for (int i = 1; i <= col; i++) {
                columName[i - 1] = rsp.getColumnName(i);
            }
            data = new String[registros][col];

            int j = 0;
            while (re.next()) {
                for (int h = 0; h < col; h++) {
                    data[j][h] = re.getString(columName[h].toString());
                }
                j++;
            }

        } catch (SQLException ex) {

        }

        tabla.setDataVector(data, columName);
        return tabla;
    }
    
    public DefaultTableModel getTablaPersona() {
        DefaultTableModel tabla = new DefaultTableModel();
        Object[] columName = null;
        Object[][] data = null;
        int registros = 0;
        try {
            //llamamos a la funcion almacenada en la base de datos
            CallableStatement pstm = this.getConexion().prepareCall("{?=call totalPersona}");
            //detallamos que la variable de salida va a ser de tipo Integer
            pstm.registerOutParameter(1, Types.INTEGER);
            //ejecutamos la llamada a la funcion
            pstm.executeUpdate();
            //recuperamos el resultado y lo asignamos a una variable 
            registros = pstm.getInt(1);
        } catch (SQLException ex) {

        }

        try {
            //Preparas la llamada al procedimiento que te devuelve la consulta
            CallableStatement cstm = this.getConexion().prepareCall("{call consultaPersona()}");
            //Ejecutas el procedimiento
            ResultSet re = cstm.executeQuery();
            //Recoges los metadatos que te devuelve la consulta
            ResultSetMetaData rsp = re.getMetaData();

            int col = rsp.getColumnCount();
            columName = new String[col];

            for (int i = 1; i <= col; i++) {
                columName[i - 1] = rsp.getColumnName(i);
            }
            data = new String[registros][col];

            int j = 0;
            while (re.next()) {
                for (int h = 0; h < col; h++) {
                    data[j][h] = re.getString(columName[h].toString());
                }
                j++;
            }

        } catch (SQLException ex) {

        }

        tabla.setDataVector(data, columName);
        return tabla;
    }
    
    public DefaultTableModel getTablaProductos() {
        DefaultTableModel tabla = new DefaultTableModel();
        Object[] columName = null;
        Object[][] data = null;
        int registros = 0;
        try {
            //llamamos a la funcion almacenada en la base de datos
            CallableStatement pstm = this.getConexion().prepareCall("{?=call totalProductos}");
            //detallamos que la variable de salida va a ser de tipo Integer
            pstm.registerOutParameter(1, Types.INTEGER);
            //ejecutamos la llamada a la funcion
            pstm.executeUpdate();
            //recuperamos el resultado y lo asignamos a una variable 
            registros = pstm.getInt(1);
        } catch (SQLException ex) {

        }

        try {
            //Preparas la llamada al procedimiento que te devuelve la consulta
            CallableStatement cstm = this.getConexion().prepareCall("{call consultaProducto()}");
            //Ejecutas el procedimiento
            ResultSet re = cstm.executeQuery();
            //Recoges los metadatos que te devuelve la consulta
            ResultSetMetaData rsp = re.getMetaData();

            int col = rsp.getColumnCount();
            columName = new String[col];

            for (int i = 1; i <= col; i++) {
                columName[i - 1] = rsp.getColumnName(i);
            }
            data = new String[registros][col];

            int j = 0;
            while (re.next()) {
                for (int h = 0; h < col; h++) {
                    data[j][h] = re.getString(columName[h].toString());
                }
                j++;
            }

        } catch (SQLException ex) {

        }

        tabla.setDataVector(data, columName);
        return tabla;
    }
    
    public DefaultTableModel getTablaInfoEmpleados() throws SQLException {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"DNI", "Licencia", "Empleo"}; 
         try {
            Connection cn= this.getConexion();
            CallableStatement st= cn.prepareCall("");
            
            st.executeQuery();
            ResultSet res = st.getResultSet();
            res.first();
            Object[] fila= new Object[3];
            while(!res.isAfterLast()){
                fila[0]= res.getString("dniPersona");
                fila[1]= res.getString("bar");
                fila[2]= res.getString("funcion");
                
                tablemodel.addRow(fila);
                res.next();
            }
            
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
         return tablemodel;
    }
    public DefaultTableModel getTablaContabilidad() {
        DefaultTableModel tabla = new DefaultTableModel();
        Object[] columName = null;
        Object[][] data = null;
        int registros = 0;
        try {
            //llamamos a la funcion almacenada en la base de datos
            CallableStatement pstm = this.getConexion().prepareCall("{?=call totalPedidos}");
            //detallamos que la variable de salida va a ser de tipo Integer
            pstm.registerOutParameter(1, Types.INTEGER);
            //ejecutamos la llamada a la funcion
            pstm.executeUpdate();
            //recuperamos el resultado y lo asignamos a una variable 
            registros = pstm.getInt(1);
        } catch (SQLException ex) {

        }

        try {
            //Preparas la llamada al procedimiento que te devuelve la consulta
            CallableStatement cstm = this.getConexion().prepareCall("{call consultaPedido()}");
            //Ejecutas el procedimiento
            ResultSet re = cstm.executeQuery();
            //Recoges los metadatos que te devuelve la consulta
            ResultSetMetaData rsp = re.getMetaData();

            int col = rsp.getColumnCount();
            columName = new String[col];

            for (int i = 1; i <= col; i++) {
                columName[i - 1] = rsp.getColumnName(i);
            }
            data = new String[registros][col];

            int j = 0;
            while (re.next()) {
                for (int h = 0; h < col; h++) {
                    data[j][h] = re.getString(columName[h].toString());
                }
                j++;
            }

        } catch (SQLException ex) {

        }

        tabla.setDataVector(data, columName);
        return tabla;
    }
    
    public int insertarBar(String licenciaF, String nombreB,String domicilioB,Date fechaA, String horarioA, String diasA){
        int aux=0;
        try {
            CallableStatement cStmt= this.getConexion().prepareCall("{?= call insertBar(?,?,?,?,?,?)}");
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,licenciaF);
            cStmt.setString(3, nombreB);
            cStmt.setString(4, domicilioB);
            cStmt.setDate(5, fechaA);
            cStmt.setString(6, horarioA);
            cStmt.setString(7, diasA);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int insertarInfoBar(String dniPer, String LicenciaFis, boolean esTit, String funcionTra){
        int aux=0;
        try {
            
            CallableStatement cStmt= this.getConexion().prepareCall("{?= call insertNuevoPuesto(?,?,?,?)}");
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,dniPer);
            cStmt.setString(3, LicenciaFis);
            cStmt.setBoolean(4, esTit);
            cStmt.setString(5, funcionTra);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int insertarPersona(String dniP, String nombreP, String domicilioP){
        int aux=1;
        try {
            CallableStatement cStmt= this.getConexion().prepareCall("{?=call insertPersona(?,?,?)}");
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,dniP);
            cStmt.setString(3, nombreP);
            cStmt.setString(4, domicilioP);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int insertarProducto(String nombreProducto, int cantidad, double precioCoste){
        int aux=0;
        try {
            String sql="?= call insertProducto(?,?,?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,nombreProducto);
            cStmt.setInt(3, cantidad);
            cStmt.setDouble(4, precioCoste);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int insertarPedido(String nombreProducto, int cantidad, double precioCoste){
        int aux=0;
        try {
            String sql="?= call insertProducto(?,?,?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,nombreProducto);
            cStmt.setInt(3, cantidad);
            cStmt.setDouble(4, precioCoste);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int insertarRecaudacion(String idBar, double cantidadRecaudacion, Date fechaRecaudacion){
        int aux=0;
        try {
            String sql="?= call insertRecaudacion(?,?,?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,idBar);
            cStmt.setDouble(3, cantidadRecaudacion);
            cStmt.setDate(4, fechaRecaudacion);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int modificarBar(String licenciaF,String nombreB,String domicilioB,Date fechaA, String horarioA, String diasA){
        int resultado=-1;
        try {
        CallableStatement cStmt= this.getConexion().prepareCall("{?= call updateBar(?,?,?,?,?,?)}");
        cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
        cStmt.setString(2,licenciaF);
        cStmt.setString(3, nombreB);
        cStmt.setString(4, domicilioB);
        cStmt.setDate(5, fechaA);
        cStmt.setString(6, horarioA);
        cStmt.setString(7, diasA);
        cStmt.execute();
        resultado= cStmt.getInt(1);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }
    
    public int modificarPersona(String dniP, String nombreP, String domicilioP){
        int aux=0;
        try {
            CallableStatement cStmt= this.getConexion().prepareCall("{?= call updatePersona(?,?,?)}");
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,dniP);
            cStmt.setString(3, nombreP);
            cStmt.setString(4, domicilioP);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int modificarProducto(String nombreProducto, int cantidad, double precioCoste){
        int aux=0;
        try {
            String sql="?= call updateProducto(?,?,?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,nombreProducto);
            cStmt.setInt(3, cantidad);
            cStmt.setDouble(4, precioCoste);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int modificarPedido(String nombreProducto, int cantidad, double precioCoste){
        int aux=0;
        try {
            String sql="?= call updateProducto(?,?,?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,nombreProducto);
            cStmt.setInt(3, cantidad);
            cStmt.setDouble(4, precioCoste);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int modificarRecaudacion(String idBar, double cantidadRecaudacion, Date fechaRecaudacion){
        int aux=0;
        try {
            String sql="?= call updateRecaudacion(?,?,?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,idBar);
            cStmt.setDouble(3, cantidadRecaudacion);
            cStmt.setDate(4, fechaRecaudacion);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int eliminarBar(String licenciaF){
        int resultado=-1;
        try {
        CallableStatement cStmt= this.getConexion().prepareCall("{?= call deleteBar(?)}");
        cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
        cStmt.setString(2,licenciaF);
        cStmt.execute();
        resultado= cStmt.getInt(1);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }
    
    public int eliminarPersona(String dniP){
        int aux=0;
        try {
            CallableStatement cStmt= this.getConexion().prepareCall("{?= call deletePersona(?)}");
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,dniP);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int eliminarProducto(String codProducto){
        int aux=0;
        try {
            String sql="?= call deleteProducto(?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,codProducto);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int eliminarPedido(String numeroPed){
        int aux=0;
        try {
            String sql="?= call deleteProducto(?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,numeroPed);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int eliminarRecaudacion(String idB, Date fechaRec){
        int aux=0;
        try {
            String sql="?= call deleteRecaudacion(?,?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,idB);
            cStmt.setDate(3, fechaRec);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int eliminarInfoBar(String dniPer, String licenciaFis){
        int aux=0;
        try {
            String sql="?= call deleteFuncion(?,?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,dniPer);
            cStmt.setString(3, licenciaFis);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
}
