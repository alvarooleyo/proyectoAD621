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
import vista.EmpleadosFrame;

/**
 *
 * @author Alejandro
 */
public class ControladorEmpleadosSQL implements ActionListener, MouseListener{
    
    int fila = -1;
    int fila1 = -1;
    int fila2 = -1;
    int fila3= -1;
    int fila4= -1;
    EmpleadosFrame vista= new EmpleadosFrame();
    ModeloSQL modelo= new ModeloSQL();

    public enum AccionMVC{        
        btnInsertarEmpleados,
        btnModificarEmpleados,
        btnEliminarEmpleados,
        btnInsertarEnlace,
        btnEliminarEnlace
    }
    
    public ControladorEmpleadosSQL(EmpleadosFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableEmpleados.setModel(this.modelo.getTablaPersona());
            this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoEmpleados());
            this.vista.jTableEnlaceEmpleados.setModel(this.modelo.getTablaPersona());
            this.vista.jTableEnlaceBar.setModel(this.modelo.getTablaBar());
            //this.vista.jTableInfoEmpleados.setModel(this.modelo.getTablaInfoEmpleados());
            
        } catch (Exception e) {
        }
        
        this.vista.btnInsertarEmpleados.setActionCommand("btnInsertarEmpleados");
        this.vista.btnInsertarEmpleados.addActionListener(this);
        this.vista.btnModificarEmpleados.setActionCommand("btnModificarEmpleados");
        this.vista.btnModificarEmpleados.addActionListener(this);
        this.vista.btnEliminarEmpleados.setActionCommand("btnEliminarEmpleados");
        this.vista.btnEliminarEmpleados.addActionListener(this);
        this.vista.btnInsertarEnlace.setActionCommand("btnInsertarEnlace");
        this.vista.btnInsertarEnlace.addActionListener(this);
        this.vista.btnEliminarEnlace.setActionCommand("btnEliminarEnlace");
        this.vista.btnEliminarEnlace.addActionListener(this);
        
        //----------------------Funciones de click de ratón sobre tablas---------------------
        this.vista.jTableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadosMouseClicked(evt);
            }
        });
        
        this.vista.jTableEnlaceBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnlaceBarMouseClicked(evt);
            }
        });
        
        this.vista.jTableEnlaceEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnlaceEmpleadosMouseClicked(evt);
            }
        });
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        switch (ControladorEmpleadosSQL.AccionMVC.valueOf(e.getActionCommand())) {
            case btnInsertarEmpleados:
                try {                
                    String dniP= this.vista.txtDNIEmpleados.getText();
                    String nombreP= this.vista.txtNombreEmpleados.getText();
                    String domicilioP= this.vista.txtDomicilioEmpleados.getText();
                    this.modelo.insertarPersona(dniP, nombreP, domicilioP);
                    this.vista.jTableEmpleados.setModel(this.modelo.getTablaPersona());
                    LimpiarEmpleados();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }               
                break;
                
            case btnModificarEmpleados:
                try {
                    String dniP= this.vista.txtDNIEmpleados.getText();
                    String nombreP= this.vista.txtNombreEmpleados.getText();
                    String domicilioP= this.vista.txtDomicilioEmpleados.getText();
                    this.modelo.modificarPersona(dniP, nombreP, domicilioP);
                    this.vista.jTableEmpleados.setModel(this.modelo.getTablaPersona());
                    LimpiarEmpleados();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case btnEliminarEmpleados:
                try {     
                    String dniP= this.vista.txtDNIEmpleados.getText();
                    this.modelo.eliminarPersona(dniP);
                    this.vista.jTableEmpleados.setModel(this.modelo.getTablaPersona());
                    LimpiarEmpleados();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            
            case btnInsertarEnlace:
                try {
                    String dniPer= this.vista.txtEmpleadoEnlace.getText();
                    String funcionTra= this.vista.txtOcupacionEnlace.getText();
                    String LicenciaFis= this.vista.txtLicenciaEnlace.getText();
                    boolean esTit = false;
                    this.modelo.insertarInfoBar(dniPer, LicenciaFis, esTit, funcionTra);
                    this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoEmpleados());
                    LimpiarEnlace();
                    
                } catch (Exception ex) {
                }
                break;
                
            case btnEliminarEnlace:
                try {
                    String dniPer= this.vista.txtEmpleadoEnlace.getText();
                    String licenciaFis= this.vista.txtLicenciaEnlace.getText();
                    this.modelo.eliminarInfoBar(dniPer, licenciaFis);
                    this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoEmpleados());
                    LimpiarEnlace();
                } catch (Exception ex) {
                }
                break;
        }
    }

    public void LimpiarEmpleados(){
        this.vista.txtDNIEmpleados.setText("");
        this.vista.txtNombreEmpleados.setText("");
        this.vista.txtDomicilioEmpleados.setText("");
    }
    
    public void LimpiarEnlace(){
        this.vista.txtEmpleadoEnlace.setText("");
        this.vista.txtOcupacionEnlace.setText("");
        this.vista.txtLicenciaEnlace.setText("");
    }
    
    //----------------------Permite la selección de elementos dentro de tablas---------------------------
    private void jTableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {

        fila = this.vista.jTableEmpleados.getSelectedRow();
        String dniEmpleado = (String) this.vista.jTableEmpleados.getValueAt(fila, 0);
        /*String[] Relleno = this.modelo.rellenarEmpleados(dniEmpleado);
        this.vista.txtDNIEmpleados.setText(dniEmpleado);
        this.vista.txtNombreEmpleados.setText(Relleno[0]);
        this.vista.txtDomicilioEmpleados.setText(Relleno[1]);*/
    }
    
    private void jTableEnlaceBarMouseClicked(java.awt.event.MouseEvent evt) {

        fila3 = this.vista.jTableEnlaceBar.getSelectedRow();
        String licenciaFiscal = (String) this.vista.jTableEnlaceBar.getValueAt(fila3, 0);
        this.vista.txtLicenciaEnlace.setText(licenciaFiscal);
    }
    
    private void jTableEnlaceEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {

        fila4 = this.vista.jTableEnlaceEmpleados.getSelectedRow();
        String dniPersona = (String) this.vista.jTableEnlaceEmpleados.getValueAt(fila4, 0);
        this.vista.txtEmpleadoEnlace.setText(dniPersona);
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