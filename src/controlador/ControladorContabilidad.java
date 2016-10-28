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
        btnLimpiar,
        btnLimpiarRecaudaciones1,
        btnInsertarRecaudaciones1,
        btnModificarRecaudaciones1,
        btnEliminarRecaudaciones1
    }
    
    public ControladorContabilidad(ContabilidadFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableContabilidad.setModel(this.modelo.getTablaContabilidad());
            this.vista.jTableRecaudaciones1.setModel(this.modelo.getTablaRecaudaciones());
            
        } catch (Exception e) {
        }
        this.vista.btnInsertarContabilidad.setActionCommand("btnInsertarContabilidad");
        this.vista.btnInsertarContabilidad.addActionListener(this);
        
        this.vista.btnModificarContabilidad.setActionCommand("btnModificarContabilidad");
        this.vista.btnModificarContabilidad.addActionListener(this);
        
        this.vista.btnEliminarContabilidad.setActionCommand("btnEliminarContabilidad");
        this.vista.btnEliminarContabilidad.addActionListener(this);
        
        this.vista.btnLimpiarContablidad.setActionCommand("btnLimpiar");
        this.vista.btnLimpiarContablidad.addActionListener(this);
        
        this.vista.btnLimpiarRecaudaciones1.setActionCommand("btnLimpiarRecaudaciones1");
        this.vista.btnLimpiarRecaudaciones1.addActionListener(this);
        
        this.vista.btnInsertarRecaudaciones1.setActionCommand("btnInsertarRecaudaciones1");
        this.vista.btnInsertarRecaudaciones1.addActionListener(this);
        
        this.vista.btnModificarRecaudaciones1.setActionCommand("btnModificarRecaudaciones1");
        this.vista.btnModificarRecaudaciones1.addActionListener(this);
        
        this.vista.btnEliminarRecaudaciones1.setActionCommand("btnEliminarRecaudaciones1");
        this.vista.btnEliminarRecaudaciones1.addActionListener(this);
        
        
        
        //----------------------Funciones de click de ratón sobre tablas---------------------
        this.vista.jTableContabilidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContabilidadMouseClicked(evt);
            }
        });    
        
        this.vista.jTableRecaudaciones1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRecaudacionesMouseClicked(evt);
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
                
            case btnLimpiar:
                
                LimpiarCotabilidad();
                
                break;
                
            case btnLimpiarRecaudaciones1:
                
                LimpiarRecaudaciones();
                
                break;
            
            case btnInsertarRecaudaciones1: 
                try {
                    String bar= this.vista.txtRecaudacionesBar.getText();
                    Date fechaRecaudacion= Date.valueOf(this.vista.txtRecaudacionesFecha.getText());
                    double cantidadRecaudacion= Double.parseDouble(this.vista.txtRecaudacionesRecaudacion.getText());
                    this.modelo.insertarRecaudacion(bar, fechaRecaudacion, cantidadRecaudacion);
                    this.vista.jTableRecaudaciones1.setModel(this.modelo.getTablaRecaudaciones());
                    LimpiarRecaudaciones();
                } catch (Exception ex) {
                }                    
                break;
                
            case btnModificarRecaudaciones1: 
                try {
                    String bar= this.vista.txtRecaudacionesBar.getText();
                    Date fechaRecaudacion= Date.valueOf(this.vista.txtRecaudacionesFecha.getText());
                    double cantidadRecaudacion= Double.parseDouble(this.vista.txtRecaudacionesRecaudacion.getText());
                    this.modelo.modificarRecaudacion(bar, fechaRecaudacion, cantidadRecaudacion);
                    this.vista.jTableRecaudaciones1.setModel(this.modelo.getTablaRecaudaciones());
                    LimpiarRecaudaciones();
                } catch (Exception ex) {
                }
                break;
                
            case btnEliminarRecaudaciones1: 
                try {
                    String bar= this.vista.txtRecaudacionesBar.getText();
                    Date fechaRecaudacion= Date.valueOf(this.vista.txtRecaudacionesFecha.getText());
                    double cantidadRecaudacion= Double.parseDouble(this.vista.txtRecaudacionesRecaudacion.getText());
                    this.modelo.eliminarRecaudacion(bar);
                    this.vista.jTableRecaudaciones1.setModel(this.modelo.getTablaRecaudaciones());
                    LimpiarRecaudaciones();
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
    
    public void LimpiarRecaudaciones(){
        this.vista.txtRecaudacionesBar.setText("");
        this.vista.txtRecaudacionesRecaudacion.setText("");
        this.vista.txtRecaudacionesFecha.setText("");
        this.vista.txtCodigoContabilidad.setEnabled(true);
    }
    
    private void jTableContabilidadMouseClicked(java.awt.event.MouseEvent evt) {

        fila = this.vista.jTableContabilidad.getSelectedRow();

        String auxiliar = String.valueOf(this.vista.jTableContabilidad.getValueAt(fila, 0));
        int numeroPedido = Integer.parseInt(auxiliar);      
        this.vista.txtCodigoContabilidad.setEnabled(false);
        String[] Relleno = this.modelo.rellenarContabilidad(numeroPedido);
        this.vista.txtNumeroContabilidad.setText((String)this.vista.jTableContabilidad.getValueAt(fila, 0));
        this.vista.txtFechaContabilidad.setText(Relleno[0]);
        this.vista.txtCodigoContabilidad.setText(Relleno[1]);
        this.vista.txtProveedorContabilidad.setText(Relleno[2]);
        this.vista.txtArticuloContabilidad.setText(Relleno[3]);
        this.vista.txtCantidadContabilidad.setText(Relleno[4]);
        this.vista.txtPrecioContabilidad.setText(Relleno[5]);
    }
    
    private void jTableRecaudacionesMouseClicked(java.awt.event.MouseEvent evt) {
        fila2 = this.vista.jTableRecaudaciones1.getSelectedRow();
        this.vista.txtRecaudacionesBar.setText((String)this.vista.jTableRecaudaciones1.getValueAt(fila2, 0));
        this.vista.txtRecaudacionesRecaudacion.setText((String)this.vista.jTableRecaudaciones1.getValueAt(fila2, 2));
        this.vista.txtRecaudacionesFecha.setText((String)this.vista.jTableRecaudaciones1.getValueAt(fila2, 1));
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

