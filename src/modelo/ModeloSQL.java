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
            CallableStatement st= cn.prepareCall("{call consultaBar()}");
            
            st.executeQuery();
            ResultSet res = st.getResultSet();
            res.first();
            Object[] fila= new Object[3];
            while(!res.isAfterLast()){
                fila[0]= res.getString("licenciaFiscal");
                fila[1]= res.getString("nombreBar");
                fila[2]= res.getString("domicilioBar");
                
                tablemodel.addRow(fila);
                res.next();
            }
            
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
         return tablemodel;
    }
    
    public DefaultTableModel getTablaInfoBar() throws SQLException {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"DNI", "Licencia", "Empleo"}; 
         try {
            Connection cn= this.getConexion();
            CallableStatement st= cn.prepareCall("{call consultaBar()}");
            
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
    
    public DefaultTableModel getTablaTitular() throws SQLException {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"DNI", "Nombre", "Domicilio"}; 
         try {
            Connection cn= this.getConexion();
            CallableStatement st= cn.prepareCall("{call consultaBar()}");
            
            st.executeQuery();
            ResultSet res = st.getResultSet();
            res.first();
            Object[] fila= new Object[3];
            while(!res.isAfterLast()){
                fila[0]= res.getString("dniTitular");
                fila[1]= res.getString("nombreTitular");
                fila[2]= res.getString("domicilioTitular");
                
                tablemodel.addRow(fila);
                res.next();
            }
            
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
         return tablemodel;
    }
    
    public DefaultTableModel getTablaEmpleados() throws SQLException {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"DNI", "Nombre", "Domicilio"}; 
         try {
            Connection cn= this.getConexion();
            CallableStatement st= cn.prepareCall("{call consultaPersona()}");
            
            st.executeQuery();
            ResultSet res = st.getResultSet();
            res.first();
            Object[] fila= new Object[3];
            while(!res.isAfterLast()){
                fila[0]= res.getString("dniEmpleado");
                fila[1]= res.getString("nombreEmpleado");
                fila[2]= res.getString("domicilioEmpleado");
                
                tablemodel.addRow(fila);
                res.next();
            }
            
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
         return tablemodel;
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
    
    public DefaultTableModel getTablaProductos() throws SQLException {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Código", "Nombre", "Cantidad","Precio"}; 
         try {
            Connection cn= this.getConexion();
            CallableStatement st= cn.prepareCall("{call consultaProducto()}");
            
            st.executeQuery();
            ResultSet res = st.getResultSet();
            res.first();
            Object[] fila= new Object[3];
            while(!res.isAfterLast()){
                fila[0]= res.getString("codigoProducto");
                fila[1]= res.getString("nombreArticulo");
                fila[2]= res.getString("cantidadProducto");
                fila[3]= res.getString("precioCoste");
                
                tablemodel.addRow(fila);
                res.next();
            }
            
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
         return tablemodel;
    }
    
    public DefaultTableModel getTablaContabilidad() throws SQLException {
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Número", "Fecha", "Codigo", "Nombre", "Artículos", "Cantidad", "Precio"}; 
         try {
            Connection cn= this.getConexion();
            CallableStatement st= cn.prepareCall("{call consultaPedido()}");
            
            st.executeQuery();
            ResultSet res = st.getResultSet();
            res.first();
            Object[] fila= new Object[7];
            while(!res.isAfterLast()){
                fila[0] = res.getString("numeroPedido");
                fila[1] = res.getString("fechaPedido");
                fila[2] = res.getString("codigoPedido");
                fila[3] = res.getString("nombreProveedor");
                fila[4] = res.getString("articulosPedido");
                fila[5] = res.getString("cantidadArticulos");
                fila[6] = res.getString("precioTotal");
                
                tablemodel.addRow(fila);
                res.next();
            }
            
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
         return tablemodel;
    }
    
    public int insertarBar(String licenciaFiscal, String nombreBar,String domicilioBar,Date fechaApertura, String horario, String diasApertura){
        int aux=0;
        try {
            String sql="?= call insertarPersona(?,?,?,?,?,?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,licenciaFiscal);
            cStmt.setString(3, nombreBar);
            cStmt.setString(4, domicilioBar);
            cStmt.setDate(5, fechaApertura);
            cStmt.setString(6, horario);
            cStmt.setString(7, diasApertura);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int insertarPersona(String dniPersona, String nombrePersona, String domicilioPersona){
        int aux=0;
        try {
            String sql="?= call insertPersona(?,?,?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,dniPersona);
            cStmt.setString(3, nombrePersona);
            cStmt.setString(4, domicilioPersona);
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
    
    public int modificarBar(String licenciaFiscal,String nombreBar,String domicilioBar,Date fechaApertura, String horario, String diasApertura){
        int resultado=-1;
        try {
        String sql="?= call updateBar(?,?,?,?,?,?)";
        CallableStatement cStmt= this.getConexion().prepareCall(sql);
        cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
        cStmt.setString(2,licenciaFiscal);
        cStmt.setString(3, nombreBar);
        cStmt.setString(4, domicilioBar);
        cStmt.setDate(5, fechaApertura);
        cStmt.setString(6, horario);
        cStmt.setString(7, diasApertura);
        cStmt.execute();
        resultado= cStmt.getInt(1);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }
    
    public int modificarPersona(String dniPersona, String nombrePersona, String domicilioPersona){
        int aux=0;
        try {
            String sql="?= call updatePersona(?,?,?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,dniPersona);
            cStmt.setString(3, nombrePersona);
            cStmt.setString(4, domicilioPersona);
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
    
    public int eliminarBar(String licenciaFiscal){
        int resultado=-1;
        try {
        String sql="?= call deleteBar(?)";
        CallableStatement cStmt= this.getConexion().prepareCall(sql);
        cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
        cStmt.setString(2,licenciaFiscal);
        cStmt.execute();
        resultado= cStmt.getInt(1);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }
    
    public int eliminarPersona(String dniPersona){
        int aux=0;
        try {
            String sql="?= call deletePersona(?)";
            CallableStatement cStmt= this.getConexion().prepareCall(sql);
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,dniPersona);
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
}
