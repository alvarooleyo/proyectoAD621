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
import modelo.ModeloSQL;
import vista.ContabilidadFrame;

/**
 *
 * @author Alejandro
 */
public class ControladorContabilidadSQL implements ActionListener, MouseListener{
    
    int fila = -1;
    int fila1 = -1;
    int fila2 = -1;
    int fila3= -1;
    int fila4= -1;
    ContabilidadFrame vista= new ContabilidadFrame();
    ModeloSQL modelo= new ModeloSQL();

    public enum AccionMVC{
        btnInsertarContabilidad,
        btnModificarContabilidad,
        btnEliminarContabilidad,
        btnLimpiarContablidad,
        btnLimpiarRecaudaciones1
    }
    
    public ControladorContabilidadSQL(ContabilidadFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableContabilidad.setModel(this.modelo.getTablaContabilidad());
            this.vista.txtNumeroContabilidad.setEditable(false);
            
            
        } catch (Exception e) {
        }
        this.vista.btnInsertarContabilidad.setActionCommand("btnInsertarContabilidad");
        this.vista.btnInsertarContabilidad.addActionListener(this);
        
        this.vista.btnModificarContabilidad.setActionCommand("btnModificarContabilidad");
        this.vista.btnModificarContabilidad.addActionListener(this);
        
        this.vista.btnEliminarContabilidad.setActionCommand("btnEliminarContabilidad");
        this.vista.btnEliminarContabilidad.addActionListener(this);
        
        this.vista.btnLimpiarContablidad.setActionCommand("btnLimpiarContablidad");
        this.vista.btnLimpiarContablidad.addActionListener(this);
        
        this.vista.btnLimpiarRecaudaciones1.setActionCommand("btnLimpiarRecaudaciones1");
        this.vista.btnLimpiarRecaudaciones1.addActionListener(this);
        
        
        
        //----------------------Funciones de click de ratón sobre tablas---------------------
        this.vista.jTableContabilidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContabilidadMouseClicked(evt);
            }
        });               
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        switch (ControladorContabilidadSQL.AccionMVC.valueOf(e.getActionCommand())) {
            case btnInsertarContabilidad:
                try {
                    String fechaPed= this.vista.txtFechaContabilidad.getText();
                    int codigoPed= Integer.parseInt(this.vista.txtCodigoContabilidad.getText());
                    String nombreProv= this.vista.txtProveedorContabilidad.getText();
                    String nombreArt= this.vista.txtArticuloContabilidad.getText();
                    int cantidadArt= Integer.parseInt(this.vista.txtCantidadContabilidad.getText());
                    double precioTot= Double.parseDouble(this.vista.txtPrecioContabilidad.getText());
                    int codProd = Integer.parseInt(this.vista.txtCodProd.getText());
                    this.modelo.insertarPedido(fechaPed, codigoPed, nombreProv, nombreArt, cantidadArt, precioTot, codProd);
                    this.vista.jTableContabilidad.setModel(this.modelo.getTablaContabilidad());
                    LimpiarCotabilidad();
                    
                } catch (Exception ex) {
                }
                break;
                
            case btnModificarContabilidad:
                try {
                    int numeroPedido=Integer.parseInt(this.vista.txtNumeroContabilidad.getText());
                    String fechaPed= this.vista.txtFechaContabilidad.getText();
                    int codigoPed= Integer.parseInt(this.vista.txtCodigoContabilidad.getText());
                    String nombreProv= this.vista.txtProveedorContabilidad.getText();
                    String nombreArt= this.vista.txtArticuloContabilidad.getText();
                    int cantidadArt= Integer.parseInt(this.vista.txtCantidadContabilidad.getText());
                    double precioTot= Double.parseDouble(this.vista.txtPrecioContabilidad.getText());
                    this.modelo.modificarPedido(fechaPed, codigoPed, nombreProv, nombreArt, cantidadArt, precioTot);
                    this.vista.jTableContabilidad.setModel(this.modelo.getTablaContabilidad());
                    LimpiarCotabilidad();
                } catch (Exception ex) {
                }
                break;
            
            case btnEliminarContabilidad:
                try {
                    int numeroPed=Integer.parseInt(this.vista.txtNumeroContabilidad.getText());
                    this.modelo.eliminarPedido(numeroPed);
                    this.vista.jTableContabilidad.setModel(this.modelo.getTablaContabilidad());
                    LimpiarCotabilidad();
                } catch (Exception ex) {
                }
                break; 
                
            case btnLimpiarContablidad:
                
                LimpiarCotabilidad();
                
                break;
            
            case btnLimpiarRecaudaciones1:
                
                LimpiarRecaudaciones();
                
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
        this.vista.txtCodProd.setText("");
    }
    
    public void LimpiarRecaudaciones(){
        this.vista.txtRecaudacionesBar.setText("");
        this.vista.txtRecaudacionesRecaudacion.setText("");
        this.vista.txtRecaudacionesFecha.setText("");
    }
    private void jTableContabilidadMouseClicked(java.awt.event.MouseEvent evt) {

        fila = this.vista.jTableContabilidad.getSelectedRow();
        this.vista.txtNumeroContabilidad.setText((String)this.vista.jTableContabilidad.getValueAt(fila, 0));
        this.vista.txtFechaContabilidad.setText((String)this.vista.jTableContabilidad.getValueAt(fila, 1));
        this.vista.txtCodigoContabilidad.setText((String)this.vista.jTableContabilidad.getValueAt(fila, 2));
        this.vista.txtProveedorContabilidad.setText((String)this.vista.jTableContabilidad.getValueAt(fila, 3));
        this.vista.txtArticuloContabilidad.setText((String)this.vista.jTableContabilidad.getValueAt(fila, 4));
        this.vista.txtCantidadContabilidad.setText((String)this.vista.jTableContabilidad.getValueAt(fila, 5));
        this.vista.txtPrecioContabilidad.setText((String)this.vista.jTableContabilidad.getValueAt(fila, 6));
        this.vista.txtCodProd.setText((String)this.vista.jTableContabilidad.getValueAt(fila, 7));
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

