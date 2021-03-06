/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class Modelo extends DatabaseSQLite{
    
    /**
     * Creamos métodos para que nos carguen las tablas donde están almacenados los datos de los bares
     */
    
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
        }
        //se crea una matriz con tantas filas y columnas como necesite
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
    
    public DefaultTableModel getTablaRecaudaciones(){
        
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0; // Indica la cantidad de filas de la tabla.
      String[] columNames = {"Licencia", "Fecha", "Cantidad"}; 
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as Total FROM Recaudaciones");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
        }catch(SQLException e){
           System.err.println( e.getMessage() );
        }
        //se crea una matriz con tantas filas y columnas como necesite
        Object[][] data = new String[registros][3];
        try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT bar, fechaRecaudacion, cantidadRecaudacion FROM Recaudaciones");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString("bar");
                data[i][1] = res.getString("fechaRecaudacion");
                data[i][2] = res.getString("cantidadRecaudacion");
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
    
    public DefaultTableModel getTablaTitular(){
        
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0; // Indica la cantidad de filas de la tabla.
      String[] columNames = {"DNI", "Nombre", "Domicilio"}; 
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as Total FROM Titulares");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
        }catch(SQLException e){
           System.err.println( e.getMessage() );
        }
        //se crea una matriz con tantas filas y columnas como necesite
        Object[][] data = new String[registros][3];
        try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT dniTitular, nombreTitular, domicilioTitular FROM Titulares");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString("dniTitular");
                data[i][1] = res.getString("nombreTitular");
                data[i][2] = res.getString("domicilioTitular");
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
    
    public DefaultTableModel getTablaEmpleados(){
        
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0; // Indica la cantidad de filas de la tabla.
      String[] columNames = {"DNI", "Nombre", "Domicilio"}; 
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as Total FROM Empleados");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
        }catch(SQLException e){
           System.err.println( e.getMessage() );
        }
        //se crea una matriz con tantas filas y columnas como necesite
        Object[][] data = new String[registros][3];
        try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT dniEmpleado, nombreEmpleado, domicilioEmpleado FROM Empleados");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString("dniEmpleado");
                data[i][1] = res.getString("nombreEmpleado");
                data[i][2] = res.getString("domicilioEmpleado");
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
    
    public DefaultTableModel getTablaProductos(){
        
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0; // Indica la cantidad de filas de la tabla.
      String[] columNames = {"Código", "Nombre", "Cantidad","Precio"}; 
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as Total FROM Producto");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
        }catch(SQLException e){
           System.err.println( e.getMessage() );
        }
        //se crea una matriz con tantas filas y columnas como necesite
        Object[][] data = new String[registros][4];
        try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT codigoProducto, nombreArticulo, cantidadProducto, precioCoste FROM Producto");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString("codigoProducto");
                data[i][1] = res.getString("nombreArticulo");
                data[i][2] = res.getString("cantidadProducto");
                data[i][3] = res.getString("precioCoste");
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
    
    public DefaultTableModel getTablaContabilidad(){
        
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0; // Indica la cantidad de filas de la tabla.
      String[] columNames = {"Número", "Fecha", "Codigo", "Nombre", "Artículos", "Cantidad", "Precio"}; 
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as Total FROM Pedido");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
        }catch(SQLException e){
           System.err.println( e.getMessage() );
        }
        //se crea una matriz con tantas filas y columnas como necesite
        Object[][] data = new String[registros][7];
        try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT numeroPedido, fechaPedido, codigoPedido, nombreProveedor, articulosPedido, cantidadArticulos, precioTotal FROM Pedido");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString("numeroPedido");
                data[i][1] = res.getString("fechaPedido");
                data[i][2] = res.getString("codigoPedido");
                data[i][3] = res.getString("nombreProveedor");
                data[i][4] = res.getString("articulosPedido");
                data[i][5] = res.getString("cantidadArticulos");
                data[i][6] = res.getString("precioTotal");
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
     
    public DefaultTableModel getTablaInfoBar(){
        
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0; // Indica la cantidad de filas de la tabla.
      String[] columNames = {"DNI", "Licencia", "Empleo"}; 
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as Total FROM TieneTitular");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
        }catch(SQLException e){
           System.err.println( e.getMessage() );
        }
        //se crea una matriz con tantas filas y columnas como necesite
        Object[][] data = new String[registros][3];
        try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT dniPersona, bar, funcion FROM TieneTitular");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString("dniPersona");
                data[i][1] = res.getString("bar");
                data[i][2] = res.getString("funcion");
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
    
    public DefaultTableModel getTablaInfoEmpleados(){
        
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0; // Indica la cantidad de filas de la tabla.
      String[] columNames = {"DNI", "Licencia", "Empleo"}; 
      try{
         PreparedStatement pstm = this.getConnection().prepareStatement( "SELECT count(*) as Total FROM TieneEmpleados");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
        }catch(SQLException e){
           System.err.println( e.getMessage() );
        }
        //se crea una matriz con tantas filas y columnas como necesite
        Object[][] data = new String[registros][3];
        try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT dniPersona, bar, funcion FROM TieneEmpleados");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString("dniPersona");
                data[i][1] = res.getString("bar");
                data[i][2] = res.getString("funcion");
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
    public String[] rellenarBar(String licenciaFiscal){     
        String[] Relleno= new String[5];
      try{
         
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT nombreBar, domicilioBar, fechaApertura, horario, diasApertura from Bar WHERE licenciaFiscal like '%"+licenciaFiscal+"%'");
         ResultSet res = pstm.executeQuery();
         
         while(res.next()){ 
            Relleno[0]= res.getString("nombreBar");
            Relleno[1] = res.getString("domicilioBar");
            Relleno[2]= res.getString("fechaApertura");
            Relleno[3]= res.getString("horario");
            Relleno[4]= res.getString("diasApertura");
            
            
          
         }           
         res.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return Relleno; 
    }
    
   
    public String[] rellenarTitular(String dniTitular){     
        String[] Relleno= new String[2];
      try{
         
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT nombreTitular, domicilioTitular from Titulares WHERE dniTitular like '%"+dniTitular+"%'");
         ResultSet res = pstm.executeQuery();
         
         while(res.next()){ 
            Relleno[0]= res.getString("nombreTitular");
            Relleno[1] = res.getString("domicilioTitular");          
          
         }           
         res.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return Relleno; 
    }
    
    public String[] rellenarEmpleados(String dniEmpleado){     
        String[] Relleno= new String[2];
      try{
         
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT nombreEmpleado, domicilioEmpleado from Empleados WHERE dniEmpleado like '%"+dniEmpleado+"%'");
         ResultSet res = pstm.executeQuery();
         
         while(res.next()){ 
            Relleno[0]= res.getString("nombreEmpleado");
            Relleno[1] = res.getString("domicilioEmpleado");          
          
         }           
         res.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return Relleno; 
    }
    
    public String[] rellenarInventario(String codigoProducto){     
        String[] Relleno= new String[3];
      try{
         
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT nombreArticulo, cantidadProducto, precioCoste from Producto WHERE codigoProducto like '%"+codigoProducto+"%'");
         ResultSet res = pstm.executeQuery();
         
         while(res.next()){ 
            Relleno[0]= res.getString("nombreArticulo");
            Relleno[1] = res.getString("cantidadProducto");  
            Relleno[2] = res.getString("precioCoste");          
          
         }           
         res.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return Relleno; 
    }
    
    public String[] rellenarContabilidad(int numeroPedido){     
        String[] Relleno= new String[6];
      try{
         
         PreparedStatement pstm = this.getConnection().prepareStatement("SELECT fechaPedido, codigoPedido, nombreProveedor, articulosPedido, cantidadArticulos, precioTotal from Pedido WHERE numeroPedido like '%"+numeroPedido+"%'");
         ResultSet res = pstm.executeQuery();
         
         while(res.next()){ 
            Relleno[0]= res.getString("fechaPedido");
            Relleno[1] = res.getString("codigoPedido");  
            Relleno[2] = res.getString("nombreProveedor");       
            Relleno[3]= res.getString("articulosPedido");
            Relleno[4] = res.getString("cantidadArticulos");  
            Relleno[5] = res.getString("precioTotal");    
          
         }           
         res.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return Relleno; 
    }
    
    /**
     * Creamos los métodos para realizar los distintos CRUD
     */
   
    public void insertarBar(String licenciaFiscal, String nombreBar,String domicilioBar,Date fechaApertura, String horario, String diasApertura){
          String z="insert into Bar values ('"+licenciaFiscal+"','"+nombreBar+"','"+domicilioBar+"','"+fechaApertura+"','"+horario+"','"+diasApertura+"')";
                     System.out.println(z);

          try{
             PreparedStatement pstm = this.getConnection().prepareStatement(z);             
             pstm.execute();                           
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
      }
    
    public void eliminarBar(String licenciaFiscal){
        String q="delete from Bar where licenciaFiscal='"+licenciaFiscal+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void modificarBar(String licenciaFiscal,String nombreBar,String domicilioBar,Date fechaApertura, String horario, String diasApertura){
        String q="update Bar set nombreBar='"+nombreBar+"', domicilioBar='"+domicilioBar+"',fechaApertura='"+fechaApertura+"',horario='"+horario+"',diasApertura='"+diasApertura+"' where licenciaFiscal='"+licenciaFiscal+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
        
    }

    public void insertarContabilidad(int numeroPedido, Date fechaPedido, int codigoPedido, String nombreProveedor, String articuloPedido, int cantidadArticulos, double precioTotal){
          String z="insert into Pedido values ('"+numeroPedido+"','"+fechaPedido+"','"+codigoPedido+"','"+nombreProveedor+"','"+articuloPedido+"','"+cantidadArticulos+"','"+precioTotal+"')";
                     System.out.println(z);

          try{
             PreparedStatement pstm = this.getConnection().prepareStatement(z);             
             pstm.execute();                           
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
      }
    
    public void modificarContabilidad(int numeroPedido, Date fechaPedido, int codigoPedido, String nombreProveedor, String articuloPedido, int cantidadArticulos, double precioTotal){
        String q="update Pedido set fechaPedido='"+fechaPedido+"', codigoPedido='"+codigoPedido+"',nombreProveedor='"+nombreProveedor+"',articuloPedido='"+articuloPedido+"',cantidadArticulos='"+cantidadArticulos+"', precioTotal='"+precioTotal+"' where numeroPedido='"+numeroPedido+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
        
    }
    
     public void eliminarContabilidad(int numeroPedido ){
        String q="delete from Pedido where numeroPedido='"+numeroPedido+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void insertarPersona(String dniPersona,String nombrePersona,String domicilioPersona, String idBar){
          String z="insert into Persona values ('"+dniPersona+"','"+nombrePersona+"','"+domicilioPersona+"','"+idBar+"')";
                     System.out.println(z);

          try{
             PreparedStatement pstm = this.getConnection().prepareStatement(z);             
             pstm.execute();                           
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
      }
    
    public void eliminarPersona(String dniPersona){
        String q="delete from Persona where dniPersona='"+dniPersona+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void modificarPersona(String nombrePersona,String domicilioPersona, String idBar, String dniPersona){
        String q="update Persona set nombrePersona='"+nombrePersona+"', domicilioPersona='"+domicilioPersona+"',idBar='"+idBar+"' where dniPersona='"+dniPersona+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
        
    }
    
    
    public void insertarEmpleado(String dniEmpleado,String nombreEmpleado,String domicilioEmpleado){
          String z="insert into Empleados values ('"+dniEmpleado+"','"+nombreEmpleado+"','"+domicilioEmpleado+"')";
                     System.out.println(z);

          try{
             PreparedStatement pstm = this.getConnection().prepareStatement(z);             
             pstm.execute();                           
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
      }
    
    public void eliminarEmpleado(String dniEmpleado){
        String q="delete from Empleados where dniEmpleado='"+dniEmpleado+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void modificarEmpleado(String nombreEmpleado,String domicilioEmpleado, String dniEmpleado){
        String q="update Empleados set nombreEmpleado='"+nombreEmpleado+"', domicilioEmpleado='"+domicilioEmpleado+"' where dniEmpleado='"+dniEmpleado+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
         
    }
   
    
    public void insertarTitulares(String dniTitular,String nombreTitular,String domicilioTitular){
          String z="insert into Titulares values ('"+dniTitular+"','"+nombreTitular+"','"+domicilioTitular+"')";
                     System.out.println(z);

          try{
             PreparedStatement pstm = this.getConnection().prepareStatement(z);             
             pstm.execute();                           
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
      }
    
    public void eliminarTitulares(String dniTitular){
        String q="delete from Titulares where dniTitular='"+dniTitular+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void modificarTitulares(String nombreTitular,String domicilioTitular, String dniTitular){
        String q="update Titulares set nombreTitular='"+nombreTitular+"', domicilioTitular='"+domicilioTitular+"' where dniTitular='"+dniTitular+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
         
    }    
    
 
    
    public void insertarProducto(String codigoProducto,String nombreArticulo,String cantidadProducto, String precioCoste){
          String z="insert into Producto values ('"+codigoProducto+"','"+nombreArticulo+"','"+cantidadProducto+"','"+precioCoste+"')";
                     System.out.println(z);

          try{
             PreparedStatement pstm = this.getConnection().prepareStatement(z);             
             pstm.execute();                           
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void eliminarProducto(String codigoProducto){
        String q="delete from Producto where codigoProducto='"+codigoProducto+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void modificarProducto(String codigoProducto,String nombreArticulo,String cantidadProducto, String precioCoste){
        String q="update Producto set nombreArticulo='"+nombreArticulo+"', cantidadProducto='"+cantidadProducto+"', precioCoste='"+precioCoste+"' where codigoProducto='"+codigoProducto+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
         
    }   
    
    public void insertarTieneTitular(String dniPersona,String bar, String funcion){
          String z="insert into TieneTitular values ('"+dniPersona+"','"+bar+"','"+funcion+"')";
                     System.out.println(z);

          try{
             PreparedStatement pstm = this.getConnection().prepareStatement(z);             
             pstm.execute();                           
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void eliminarTieneTitular(String dniPersona, String bar){
        String q="delete from TieneTitular where dniPersona='"+dniPersona+"'and bar='"+bar+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void insertarTieneEmpleados(String dniPersona,String bar, String funcion){
          String z="insert into TieneEmpleados values ('"+dniPersona+"','"+bar+"','"+funcion+"')";
                     System.out.println(z);

          try{
             PreparedStatement pstm = this.getConnection().prepareStatement(z);             
             pstm.execute();                           
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void eliminarTieneEmpleados(String dniPersona, String bar){
        String q="delete from TieneEmpleados where dniPersona='"+dniPersona+"'and bar='"+bar+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void insertarVende(int producto, String bar){
          String z="insert into Vende values ('"+producto+"','"+bar+"')";
                     System.out.println(z);

          try{
             PreparedStatement pstm = this.getConnection().prepareStatement(z);             
             pstm.execute();                           
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void eliminarVende(int producto, String bar){
        String q="delete from Vende where producto='"+producto+"'and bar='"+bar+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void insertarGenera(int producto, int pedido){
          String z="insert into Genera values ('"+producto+"','"+pedido+"')";
                     System.out.println(z);

          try{
             PreparedStatement pstm = this.getConnection().prepareStatement(z);             
             pstm.execute();                           
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void eliminarGenera(int producto, int pedido){
        String q="delete from Genera where producto='"+producto+"'and pedido='"+pedido+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 }
    }
    
    public void insertarRecaudacion(String bar, Date fechaRecaudacion, double cantidadRecaudacion){
          String z="insert into Recaudaciones values ('"+bar+"','"+fechaRecaudacion+"','"+cantidadRecaudacion+"')";
                     System.out.println(z);

          try{
             PreparedStatement pstm = this.getConnection().prepareStatement(z);             
             pstm.execute();                           
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
      }
    
    public void modificarRecaudacion(String bar, Date fechaRecaudacion, double cantidadRecaudacion){
        String q="update Recaudaciones set bar='"+bar+"', fechaRecaudacion='"+fechaRecaudacion+"', cantidadRecaudacion='"+cantidadRecaudacion+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
        
    }
    
     public void eliminarRecaudacion(String bar ){
        String q="delete from Recaudaciones where bar='"+bar+"'";
         try{
             PreparedStatement pstm = this.getConnection().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 }
    }
}

