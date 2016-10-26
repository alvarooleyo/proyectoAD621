/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import modelo.Modelo;
import vista.ContabilidadFrame;

/**
 *
 * @author Alejandro
 */
public class ControladorContabilidad implements ActionListener, MouseListener{
    
    int fila = -1;
    int fila1 = -1;
    int fila2 = -1;
    int fila3= -1;
    int fila4= -1;
    ContabilidadFrame vista= new ContabilidadFrame();
    Modelo modelo= new Modelo();

    public enum AccionMVC{
        btnInsertarContabilidad,
        btnModificarContabilidad,
        btnEliminarContabilidad,
        btnInsertarEnlace,
        btnEliminarEnlace
    }
    
    public ControladorContabilidad(ContabilidadFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableContabilidad.setModel(this.modelo.getTablaContabilidad());
            this.vista.jTableEnlacePedido.setModel(this.modelo.getTablaContabilidad());
            this.vista.jTableEnlaceProducto.setModel(this.modelo.getTablaProductos());
            this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoContabilidad());
            
        } catch (Exception e) {
        }
        this.vista.btnInsertarContabilidad.setActionCommand("btnInsertarContabilidad");
        this.vista.btnInsertarContabilidad.addActionListener(this);
        this.vista.btnModificarContabilidad.setActionCommand("btnModificarContabilidad");
        this.vista.btnModificarContabilidad.addActionListener(this);
        this.vista.btnEliminarContabilidad.setActionCommand("btnEliminarContabilidad");
        this.vista.btnEliminarContabilidad.addActionListener(this);
        this.vista.btnInsertarEnlace.setActionCommand("btnInsertarEnlace");
        this.vista.btnInsertarEnlace.addActionListener(this);
        this.vista.btnEliminarEnlace.setActionCommand("btnEliminarEnlace");
        this.vista.btnEliminarEnlace.addActionListener(this);
        
        //----------------------Funciones de click de ratón sobre tablas---------------------
        this.vista.jTableContabilidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContabilidadMouseClicked(evt);
            }
        });        
        this.vista.jTableEnlaceProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnlaceProductoMouseClicked(evt);
            }
        });  
        this.vista.jTableEnlacePedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnlacePedidoMouseClicked(evt);
            }
        });  
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        switch (ControladorContabilidad.AccionMVC.valueOf(e.getActionCommand())) {
            case btnInsertarContabilidad:
                try {
                    int numeroPedido=Integer.parseInt(this.vista.txtNumeroContabilidad.getText());
                    Date fechaPedido= Date.valueOf(this.vista.txtFechaContabilidad.getText());
                    int codigoPedido= Integer.parseInt(this.vista.txtCodigoContabilidad.getText());
                    String nombreProveedor= this.vista.txtProveedorContabilidad.getText();
                    String articulosPedido= this.vista.txtArticuloContabilidad.getText();
                    int cantidadArticulos= Integer.parseInt(this.vista.txtCantidadContabilidad.getText());
                    double precioTotal= Double.parseDouble(this.vista.txtPrecioContabilidad.getText());
                    this.modelo.insertarContabilidad(numeroPedido, fechaPedido, codigoPedido, nombreProveedor, articulosPedido, cantidadArticulos, precioTotal);
                    this.vista.jTableContabilidad.setModel(this.modelo.getTablaContabilidad());
                    LimpiarCotabilidad();
                    
                } catch (Exception ex) {
                }
                break;
                
            case btnModificarContabilidad:
                try {
                    int numeroPedido=Integer.parseInt(this.vista.txtNumeroContabilidad.getText());
                    Date fechaPedido= Date.valueOf(this.vista.txtFechaContabilidad.getText());
                    int codigoPedido= Integer.parseInt(this.vista.txtCodigoContabilidad.getText());
                    String nombreProveedor= this.vista.txtProveedorContabilidad.getText();
                    String articulosPedido= this.vista.txtArticuloContabilidad.getText();
                    int cantidadArticulos= Integer.parseInt(this.vista.txtCantidadContabilidad.getText());
                    double precioTotal= Double.parseDouble(this.vista.txtPrecioContabilidad.getText());
                    this.modelo.modificarContabilidad(numeroPedido, fechaPedido, codigoPedido, nombreProveedor, articulosPedido, cantidadArticulos, precioTotal);
                    this.vista.jTableContabilidad.setModel(this.modelo.getTablaContabilidad());
                    LimpiarCotabilidad();
                } catch (Exception ex) {
                }
                break;
            
            case btnEliminarContabilidad:
                try {
                    int numeroPedido=Integer.parseInt(this.vista.txtNumeroContabilidad.getText());
                    this.modelo.eliminarContabilidad(numeroPedido);
                    this.vista.jTableContabilidad.setModel(this.modelo.getTablaContabilidad());
                    LimpiarCotabilidad();
                } catch (Exception ex) {
                }
                break;
            
            case btnInsertarEnlace:
                try {
                    int producto= Integer.parseInt(this.vista.txtProductoEnlace.getText());
                    int pedido= Integer.parseInt(this.vista.txtPedidoEnlace.getText());        
                    this.modelo.insertarGenera(producto, pedido);
                    this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoContabilidad());
                    LimpiarEnlace();
                    
                } catch (Exception ex) {
                }
                break;
                
            case btnEliminarEnlace:
                try {
                    int producto= Integer.parseInt(this.vista.txtProductoEnlace.getText());
                    int pedido= Integer.parseInt(this.vista.txtPedidoEnlace.getText());        
                    this.modelo.eliminarGenera(producto, pedido);
                    this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoContabilidad());
                    LimpiarEnlace();
                } catch (Exception ex) {
                }
                break;
        
        }
    }
    
    public void LimpiarCotabilidad(){
        this.vista.txtNumeroContabilidad.setText("");
        this.vista.txtFechaContabilidad.setText("");
        this.vista.txtCodigoContabilidad.setText("");
        this.vista.txtProveedorContabilidad.setText("");
        this.vista.txtArticuloContabilidad.setText("");
        this.vista.txtCantidadContabilidad.setText("");
        this.vista.txtPrecioContabilidad.setText("");
    }
    
    public void LimpiarEnlace(){
        this.vista.txtProductoEnlace.setText("");
        this.vista.txtPedidoEnlace.setText("");
    }
    
    private void jTableContabilidadMouseClicked(java.awt.event.MouseEvent evt) {

        fila = this.vista.jTableContabilidad.getSelectedRow();
        String numeroPedido = (String) this.vista.jTableContabilidad.getValueAt(fila, 0);
        String[] Relleno = this.modelo.rellenarInventario(numeroPedido);
        this.vista.txtNumeroContabilidad.setText(numeroPedido);
        this.vista.txtFechaContabilidad.setText(Relleno[0]);
        this.vista.txtCodigoContabilidad.setText(Relleno[1]);
        this.vista.txtProveedorContabilidad.setText(Relleno[2]);
        this.vista.txtArticuloContabilidad.setText(Relleno[3]);
        this.vista.txtCantidadContabilidad.setText(Relleno[4]);
        this.vista.txtPrecioContabilidad.setText(Relleno[5]);
    }
    
    private void jTableEnlaceProductoMouseClicked(java.awt.event.MouseEvent evt) {

        fila3 = this.vista.jTableEnlaceProducto.getSelectedRow();
        String producto = (String) this.vista.jTableEnlaceProducto.getValueAt(fila3, 0);
        this.vista.txtProductoEnlace.setText(producto);
    }
    
    private void jTableEnlacePedidoMouseClicked(java.awt.event.MouseEvent evt) {

        fila4 = this.vista.jTableEnlacePedido.getSelectedRow();
        String pedido = (String) this.vista.jTableEnlacePedido.getValueAt(fila4, 0);
        this.vista.txtPedidoEnlace.setText(pedido);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

