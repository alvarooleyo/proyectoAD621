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
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

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
            CallableStatement pstm = this.getConexion().prepareCall("{?=call totalProducto}");
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
            CallableStatement pstm = this.getConexion().prepareCall("{?=call totalPedido}");
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
        int aux=1;
        try {
            
            CallableStatement cStmt= this.getConexion().prepareCall("{?=call insertNuevoPuesto(?,?,?,?)}");
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
            CallableStatement cStmt= this.getConexion().prepareCall("{?= call insertProducto(?,?,?)}");
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
    
    public int insertarPedido(String fechaPed, int codigoPed, String nombreProv, String nombreArt, int cantidadArt, double precioTot, int codProd){
        int aux=0;
        try {
            CallableStatement cStmt= this.getConexion().prepareCall("{?= call insertPedido(?,?,?,?,?,?,?)}");
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,fechaPed);
            cStmt.setInt(3, codigoPed);
            cStmt.setString(4, nombreProv);
            cStmt.setString(5,nombreArt);
            cStmt.setInt(6, cantidadArt);
            cStmt.setDouble(7, precioTot);
            cStmt.setInt(8, codProd);
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
    
    public int modificarProducto(String nombreProd, int cantidadProd, double precioProd){
        int aux=0;
        try {
            CallableStatement cStmt= this.getConexion().prepareCall("{?= call updateProducto(?,?,?)}");
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,nombreProd);
            cStmt.setInt(3, cantidadProd);
            cStmt.setDouble(4, precioProd);
            cStmt.execute();
            aux= cStmt.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aux;
    }
    
    public int modificarPedido(String fechaPed, int codigoPed, String nombreProv, String nombreArt, int cantidadArt, double precioTot){
        int aux=0;
        try {
            CallableStatement cStmt= this.getConexion().prepareCall("{?= call updatePedido(?,?,?,?,?,?)}");
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setString(2,fechaPed);
            cStmt.setInt(3, codigoPed);
            cStmt.setString(4, nombreProv);
            cStmt.setString(5,nombreArt);
            cStmt.setInt(6, cantidadArt);
            cStmt.setDouble(7, precioTot);
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
    
    public int eliminarPedido(int numeroPed){
        int aux=0;
        try {
            CallableStatement cStmt= this.getConexion().prepareCall("{?= call deletePedido(?)}");
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cStmt.setInt(2,numeroPed);
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
            CallableStatement cStmt= this.getConexion().prepareCall("{?= call deleteFuncion(?,?)}");
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
    
    public void generarInformeRecaudaciones(String cif) {
    //Escoge la ruta en el que se encuentra el documento
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.split("build")[0] + "src/informes/reportRecaudaciones.jrxml";
        Map param = new HashMap<String, Object>();
        param.put("Licencia Fiscal", cif);
        try {
    //Escoge el informe listado Facturas para imprimirlo
            JasperReport contenido = JasperCompileManager.compileReport(path);
            JasperPrint mostrar = new JasperPrint();
            mostrar = JasperFillManager.fillReport(contenido, param, getConexion());
             JasperViewer view= new JasperViewer(mostrar, false);
            view.setVisible(true);
        } catch (JRException ex) {
        }
    }
    
    public void generarInformeStock(String cif) {
    //Escoge la ruta en el que se encuentra el documento
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.split("build")[0] + "src/informes/reportStock.jrxml";
        Map param = new HashMap<String, Object>();
        param.put("Licencia Fiscal", cif);
        try {
    //Escoge el informe listado Facturas para imprimirlo
            JasperReport contenido = JasperCompileManager.compileReport(path);
            JasperPrint mostrar = new JasperPrint();
            mostrar = JasperFillManager.fillReport(contenido, param, getConexion());
             JasperViewer view= new JasperViewer(mostrar, false);
            view.setVisible(true);
        } catch (JRException ex) {
        }
    }
}
