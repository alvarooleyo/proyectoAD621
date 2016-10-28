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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
        btnLimpiarRecaudaciones1,
        btnGenerarInformeRecaudaciones,
        btnInsertarRecaudaciones1,
        btnModificarRecaudaciones1,
        btnEliminarRecaudaciones1,
        btnInformeRecaudaciones
    }
    
    public ControladorContabilidadSQL(ContabilidadFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableContabilidad.setModel(this.modelo.getTablaContabilidad());
            this.vista.txtNumeroContabilidad.setEditable(false);
            this.vista.jTableRecaudaciones1.setModel(this.modelo.getTablaRecaudaciones());
            
            
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
        
        this.vista.btnInsertarRecaudaciones1.setActionCommand("btnInsertarRecaudaciones1");
        this.vista.btnInsertarRecaudaciones1.addActionListener(this);
        
        this.vista.btnModificarRecaudaciones1.setActionCommand("btnModificarRecaudaciones1");
        this.vista.btnModificarRecaudaciones1.addActionListener(this);
        
        this.vista.btnEliminarRecaudaciones1.setActionCommand("btnEliminarRecaudaciones1");
        this.vista.btnEliminarRecaudaciones1.addActionListener(this);
        
        this.vista.btnInformeRecaudaciones.setActionCommand("btnInformeRecaudaciones");
        this.vista.btnInformeRecaudaciones.addActionListener(this);
        
        
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
                    int cantidadPed= Integer.parseInt(this.vista.txtCantidadContabilidad.getText());
                    double precioTot= Double.parseDouble(this.vista.txtPrecioContabilidad.getText());
                    int codProd = Integer.parseInt(this.vista.txtCodProd.getText());
                    this.modelo.insertarPedido(fechaPed, codigoPed, nombreProv, nombreArt, cantidadPed, precioTot, codProd);
                    this.vista.jTableContabilidad.setModel(this.modelo.getTablaContabilidad());
                    LimpiarCotabilidad();
                    
                } catch (Exception ex) {
                }
                break;
                
            case btnModificarContabilidad:
                try {
                    
                    String fechaPed= this.vista.txtFechaContabilidad.getText();
                    int codProd=Integer.parseInt(this.vista.txtNumeroContabilidad.getText());
                    int codigoPed= Integer.parseInt(this.vista.txtCodigoContabilidad.getText());
                    String nombreProv= this.vista.txtProveedorContabilidad.getText();
                    String nombreArt= this.vista.txtArticuloContabilidad.getText();
                    int cantidadPed= Integer.parseInt(this.vista.txtCantidadContabilidad.getText());
                    double precioTot= Double.parseDouble(this.vista.txtPrecioContabilidad.getText());
                    
                    this.modelo.modificarPedido2(fechaPed, codigoPed, nombreProv, nombreArt, cantidadPed, precioTot, codProd);
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
            
            case btnGenerarInformeRecaudaciones:
                
                DefaultTableModel model = (DefaultTableModel) this.vista.jTableRecaudaciones1.getModel();
                int a = this.vista.jTableRecaudaciones1.getSelectedRow();
                if (a < 0) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
                } else {
                    String cif = this.vista.jTableRecaudaciones1.getValueAt(this.vista.jTableRecaudaciones1.getSelectedRow(), 0).toString();
                    this.modelo.generarInformeRecaudaciones(cif);
                }
                break;
            case btnInsertarRecaudaciones1: 
                try {
                    String licenciaFis= this.vista.txtRecaudacionesBar.getText();
                    String fechaRec= this.vista.txtRecaudacionesFecha.getText();
                    double cantidadRec= Double.parseDouble(this.vista.txtRecaudacionesRecaudacion.getText());
                    this.modelo.insertarRecaudacion(licenciaFis, cantidadRec, fechaRec);
                    this.vista.jTableRecaudaciones1.setModel(this.modelo.getTablaRecaudaciones());
                    LimpiarRecaudaciones();
                } catch (Exception ex) {
                }                    
                break;
                
            case btnModificarRecaudaciones1: 
                try {
                    String licenciaFis= this.vista.txtRecaudacionesBar.getText();
                    String fechaRec= this.vista.txtRecaudacionesFecha.getText();
                    double cantidadRec= Double.parseDouble(this.vista.txtRecaudacionesRecaudacion.getText());
                    this.modelo.modificarRecaudacion(licenciaFis, cantidadRec, fechaRec);
                    this.vista.jTableRecaudaciones1.setModel(this.modelo.getTablaRecaudaciones());
                    LimpiarRecaudaciones();
                } catch (Exception ex) {
                }
                break;
                
            case btnEliminarRecaudaciones1: 
                try {
                    String licenciaFis= this.vista.txtRecaudacionesBar.getText();
                    String fechaRec= this.vista.txtRecaudacionesFecha.getText();
                    this.modelo.eliminarRecaudacion(licenciaFis, fechaRec);
                    this.vista.jTableRecaudaciones1.setModel(this.modelo.getTablaRecaudaciones());
                    LimpiarRecaudaciones();
                } catch (Exception ex) {
                }
                break;
            case btnInformeRecaudaciones: 
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
        this.vista.txtCodigoContabilidad.setEnabled(true);
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
        this.vista.txtCodigoContabilidad.setEnabled(false);
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

