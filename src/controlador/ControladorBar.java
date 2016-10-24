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
import vista.TitularFrame;

/**
 *
 * @author Alejandro
 */
public class ControladorBar implements ActionListener, MouseListener{
    
    TitularFrame vista= new TitularFrame();
    Modelo modelo= new Modelo();

    public enum AccionMVC{
        btnInsertarBar,
        btnInsertarTitular,
        btnModificarBar,
        btnModificarTitular,
        btnEliminarBar,
        btnEliminarTitular
    }
    
    public ControladorBar(TitularFrame vista){
        this.vista=vista;
    }
    
    public void iniciar() {
        try {

            this.vista.jTableBar.setModel(this.modelo.getTablaBar());
            this.vista.jTableTitular.setModel(this.modelo.getTablaTitular());
            
            
        } catch (Exception e) {
        }
            this.vista.btnInsertarBar.setActionCommand("btnInsertarBar");
            this.vista.btnInsertarBar.addActionListener(this);
            this.vista.btnInsertarTitular.setActionCommand("btnInsertarTitular");
            this.vista.btnInsertarTitular.addActionListener(this);
            this.vista.btnModificarBar.setActionCommand("btnModificarBar");
            this.vista.btnModificarBar.addActionListener(this);
            this.vista.btnModificarTitular.setActionCommand("btnModificarTitular");
            this.vista.btnModificarTitular.addActionListener(this);
            this.vista.btnEliminarBar.setActionCommand("btnEliminarBar");
            this.vista.btnEliminarBar.addActionListener(this);
            this.vista.btnEliminarTitular.setActionCommand("btnEliminarTitular");
            this.vista.btnEliminarTitular.addActionListener(this);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())) {
            case btnInsertarBar:
                try {
                    String licenciaFiscal= this.vista.txtLicenciaBar.getText();
                    String nombreBar= this.vista.txtNombreBar.getText();
                    String domicilioBar= this.vista.txtDomicilioBar.getText();
                    String fechaApertura= this.vista.txtFechaBar.getText();
                    String horario= this.vista.txtHorarioBar.getText(); 
                    String diasApertura= this.vista.txtHorarioBar.getText();                   
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                break;
                
            case btnInsertarTitular:
                
                break;
                
            case btnModificarBar:
                try {
                    String licenciaFiscal= this.vista.txtLicenciaBar.getText();
                    String nombreBar= this.vista.txtNombreBar.getText();
                    String domicilioBar= this.vista.txtDomicilioBar.getText();
                    String fechaApertura= this.vista.txtFechaBar.getText();
                    String horario= this.vista.txtHorarioBar.getText(); 
                    String diasApertura= this.vista.txtHorarioBar.getText();                   
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case btnModificarTitular:
                
                break;
                
            case btnEliminarBar:
                try {
                    String licenciaFiscal= this.vista.txtLicenciaBar.getText();
                    String nombreBar= this.vista.txtNombreBar.getText();
                    String domicilioBar= this.vista.txtDomicilioBar.getText();
                    String fechaApertura= this.vista.txtFechaBar.getText();
                    String horario= this.vista.txtHorarioBar.getText(); 
                    String diasApertura= this.vista.txtHorarioBar.getText();                   
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case btnEliminarTitular:
                
                break;                
        }
    }
    
    public void LimpiarBar(){
        
    }
    
    public void LimpiarTitular(){
        
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
