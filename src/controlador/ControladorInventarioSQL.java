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
import modelo.ModeloSQL;
import vista.InventarioFrame;

/**
 *
 * @author Alejandro
 */
public class ControladorInventarioSQL implements ActionListener, MouseListener{
    
    int fila = -1;
    int fila1 = -1;
    int fila2 = -1;
    int fila3= -1;
    int fila4= -1;
    InventarioFrame vista= new InventarioFrame();
    ModeloSQL modelo= new ModeloSQL();

    public enum AccionMVC{
        btnInsertarProducto,
        btnModificarProducto,
        btnEliminarProducto,
        btnInsertarEnlace,
        btnEliminarEnlace
    }
    
    public ControladorInventarioSQL(InventarioFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableInventario.setModel(this.modelo.getTablaProductos());
                    
        } catch (Exception e) {
        }
            this.vista.btnInsertarProducto.setActionCommand("btnInsertarProducto");
            this.vista.btnInsertarProducto.addActionListener(this);
            this.vista.btnModificarProducto.setActionCommand("btnModificarProducto");
            this.vista.btnModificarProducto.addActionListener(this);
            this.vista.btnEliminarProducto.setActionCommand("btnEliminarProducto");
            this.vista.btnEliminarProducto.addActionListener(this);
            
            //----------------------Funciones de click de ratón sobre tablas---------------------
        this.vista.jTableInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInventarioMouseClicked(evt);
            }
        });
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        switch (ControladorInventarioSQL.AccionMVC.valueOf(e.getActionCommand())) {
            case btnInsertarProducto:
                try {
                    
                    String nombreProducto= this.vista.txtNombreProducto.getText();
                    int cantidad= Integer.parseInt(this.vista.txtCantidadProducto.getText());
                    Double precioCoste= Double.parseDouble(this.vista.txtPrecioProducto.getText());
                    this.modelo.insertarProducto(nombreProducto, cantidad, precioCoste);
                    this.vista.jTableInventario.setModel(this.modelo.getTablaProductos());
                    LimpiarInventario();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case btnModificarProducto:
                try {
                    String nombreProd= this.vista.txtNombreProducto.getText();
                    int cantidadProd= Integer.parseInt(this.vista.txtCantidadProducto.getText());
                    Double precioProd= Double.parseDouble(this.vista.txtPrecioProducto.getText());
                    this.modelo.modificarProducto(nombreProd, cantidadProd, precioProd);
                    this.vista.jTableInventario.setModel(this.modelo.getTablaProductos());
                    LimpiarInventario();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case btnEliminarProducto:
                try {
                    String codProducto= this.vista.txtCodigoProducto.getText();
                    this.modelo.eliminarProducto(codProducto);
                    this.vista.jTableInventario.setModel(this.modelo.getTablaProductos());
                    LimpiarInventario();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
    }
    }
    public void LimpiarInventario(){
        this.vista.txtCantidadProducto.setText("");
        this.vista.txtCodigoProducto.setText("");
        this.vista.txtNombreProducto.setText("");
        this.vista.txtPrecioProducto.setText("");
    }
    
    //----------------------Permite la selección de elementos dentro de tablas---------------------------
    private void jTableInventarioMouseClicked(java.awt.event.MouseEvent evt) {

        fila = this.vista.jTableInventario.getSelectedRow();
        String codigoProducto = (String) this.vista.jTableInventario.getValueAt(fila, 0);
        /*String[] Relleno = this.modelo.rellenarInventario(codigoProducto);
        this.vista.txtCodigoProducto.setText(codigoProducto);
        this.vista.txtNombreProducto.setText(Relleno[0]);
        this.vista.txtCantidadProducto.setText(Relleno[1]);
        this.vista.txtPrecioProducto.setText(Relleno[2]);*/
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
