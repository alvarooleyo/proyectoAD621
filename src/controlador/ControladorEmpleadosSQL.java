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
        btnEliminarEnlace,
        btnLimpiarEmpleado,
        btnLimpiarEnlaceEmpleado
    }
    
    public ControladorEmpleadosSQL(EmpleadosFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableEmpleados.setModel(this.modelo.getTablaPersona());
            this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoBar());
            this.vista.jTableEnlaceEmpleados.setModel(this.modelo.getTablaPersona());
            this.vista.jTableEnlaceBar.setModel(this.modelo.getTablaBar());
            this.vista.jTableInfoEmpleados.setModel(this.modelo.getTablaInfoBar());
            this.vista.txtEmpleadoEnlace.setEnabled(false);
            this.vista.txtLicenciaEnlace.setEnabled(false);
            
            
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
        
        this.vista.btnLimpiarEmpleado.setActionCommand("btnLimpiarEmpleado");
        this.vista.btnLimpiarEmpleado.addActionListener(this);
        
        this.vista.btnLimpiarEnlaceEmpleado.setActionCommand("btnLimpiarEnlaceEmpleado");
        this.vista.btnLimpiarEnlaceEmpleado.addActionListener(this);
        
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
        
        this.vista.jTableEnlaceInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnlaceInfoMouseClicked(evt);
            }
        });      
        
        this.vista.jTableInfoEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInfoEmpleadosMouseClicked(evt);
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
                    this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoBar());
                    LimpiarEnlace();
                    
                } catch (Exception ex) {
                }
                break;
                
            case btnEliminarEnlace:
                try {
                    String dniPer= this.vista.txtEmpleadoEnlace.getText();
                    String licenciaFis= this.vista.txtLicenciaEnlace.getText();
                    this.modelo.eliminarInfoBar(dniPer, licenciaFis);
                    this.vista.jTableEnlaceInfo.setModel(this.modelo.getTablaInfoBar());
                    LimpiarEnlace();
                } catch (Exception ex) {
                }
                break;
                
            case btnLimpiarEmpleado:
                
                LimpiarEmpleados();
                
                break;
                
            case btnLimpiarEnlaceEmpleado:
                
                LimpiarEnlace();
                
                break;
                         
        }
    }

    public void LimpiarEmpleados(){
        this.vista.txtDNIEmpleados.setText("");
        this.vista.txtNombreEmpleados.setText("");
        this.vista.txtDomicilioEmpleados.setText("");
        this.vista.txtDNIEmpleados.setEnabled(true);
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
        String nombreEmpleados = (String) this.vista.jTableEmpleados.getValueAt(fila, 1);
        String domicilioEmpleados = (String) this.vista.jTableEmpleados.getValueAt(fila, 2);
        this.vista.txtDNIEmpleados.setText(dniEmpleado);
        this.vista.txtDNIEmpleados.setEnabled(false);
        this.vista.txtNombreEmpleados.setText(nombreEmpleados);
        this.vista.txtDomicilioEmpleados.setText(domicilioEmpleados);
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
    
    private void jTableEnlaceInfoMouseClicked(java.awt.event.MouseEvent evt) {
        
        fila2 = this.vista.jTableEnlaceInfo.getSelectedRow();
        String dniPersona = (String) this.vista.jTableEnlaceInfo.getValueAt(fila2, 0);
        String licenciaFiscal = (String) this.vista.jTableEnlaceInfo.getValueAt(fila2, 1);
        String ocupacion = (String) this.vista.jTableEnlaceInfo.getValueAt(fila2, 2);
        this.vista.txtEmpleadoEnlace.setText(dniPersona);
        this.vista.txtOcupacionEnlace.setText(ocupacion);
        this.vista.txtLicenciaEnlace.setText(licenciaFiscal);
        
    }
    
    private void jTableInfoEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {
        
        fila1 = this.vista.jTableInfoEmpleados.getSelectedRow();
        String dniPersona = (String) this.vista.jTableInfoEmpleados.getValueAt(fila1, 0);
        String licenciaFiscal = (String) this.vista.jTableInfoEmpleados.getValueAt(fila1, 1);
        String ocupacion = (String) this.vista.jTableInfoEmpleados.getValueAt(fila1, 3);
        this.vista.txtInfoDNI.setText(dniPersona);
        this.vista.txtInfoEstablecimiento.setText(ocupacion);
        this.vista.txtInfoOcupacion.setText(licenciaFiscal);
        
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
