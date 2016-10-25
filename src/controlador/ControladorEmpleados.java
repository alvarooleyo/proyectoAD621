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
import modelo.Modelo;
import vista.EmpleadosFrame;

/**
 *
 * @author Alejandro
 */
public class ControladorEmpleados implements ActionListener, MouseListener{
    
    int fila = -1;
    EmpleadosFrame vista= new EmpleadosFrame();
    Modelo modelo= new Modelo();

    public enum AccionMVC{
        
        btnInsertarEmpleados,
        btnModificarEmpleados,
        btnEliminarEmpleados
    }
    
    public ControladorEmpleados(EmpleadosFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableEmpleados.setModel(this.modelo.getTablaEmpleados());
            
        } catch (Exception e) {
        }
        
        this.vista.btnInsertarEmpleados.setActionCommand("btnInsertarEmpleados");
        this.vista.btnInsertarEmpleados.addActionListener(this);
        this.vista.btnModificarEmpleados.setActionCommand("btnModificarEmpleados");
        this.vista.btnModificarEmpleados.addActionListener(this);
        this.vista.btnEliminarEmpleados.setActionCommand("btnEliminarEmpleados");
        this.vista.btnEliminarEmpleados.addActionListener(this);
        
        //----------------------Funciones de click de ratón sobre tablas---------------------
        this.vista.jTableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadosMouseClicked(evt);
            }
        });
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        switch (ControladorEmpleados.AccionMVC.valueOf(e.getActionCommand())) {
            case btnInsertarEmpleados:
                try {                
                    String dniEmpleado= this.vista.txtDNIEmpleados.getText();
                    String nombreEmpleado= this.vista.txtNombreEmpleados.getText();
                    String domicilioEmpleado= this.vista.txtDomicilioEmpleados.getText();
                    this.modelo.insertarEmpleado(dniEmpleado, nombreEmpleado, domicilioEmpleado);
                    this.vista.jTableEmpleados.setModel(this.modelo.getTablaEmpleados());
                    LimpiarEmpleados();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }               
                break;
                
            case btnModificarEmpleados:
                try {
                    String dniEmpleado= this.vista.txtDNIEmpleados.getText();
                    String nombreEmpleado= this.vista.txtNombreEmpleados.getText();
                    String domicilioEmpleado= this.vista.txtDomicilioEmpleados.getText();
                    this.modelo.modificarEmpleado(nombreEmpleado, domicilioEmpleado, dniEmpleado);
                    this.vista.jTableEmpleados.setModel(this.modelo.getTablaEmpleados());
                    LimpiarEmpleados();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case btnEliminarEmpleados:
                try {     
                    String dniEmpleado= this.vista.txtDNIEmpleados.getText();
                    this.modelo.eliminarEmpleado(dniEmpleado);
                    this.vista.jTableEmpleados.setModel(this.modelo.getTablaEmpleados());
                    LimpiarEmpleados();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }

    public void LimpiarEmpleados(){
        this.vista.txtDNIEmpleados.setText("");
        this.vista.txtNombreEmpleados.setText("");
        this.vista.txtDomicilioEmpleados.setText("");
    }
    
    //----------------------Permite la selección de elementos dentro de tablas---------------------------
    private void jTableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {

        fila = this.vista.jTableEmpleados.getSelectedRow();
        String dniEmpleado = (String) this.vista.jTableEmpleados.getValueAt(fila, 0);
        String[] Relleno = this.modelo.rellenarEmpleados(dniEmpleado);
        this.vista.txtDNIEmpleados.setText(dniEmpleado);
        this.vista.txtNombreEmpleados.setText(Relleno[0]);
        this.vista.txtDomicilioEmpleados.setText(Relleno[1]);
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
