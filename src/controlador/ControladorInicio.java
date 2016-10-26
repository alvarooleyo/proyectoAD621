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
import vista.Inicio;
import vista.Interface;

/**
 *
 * @author Alejandro
 */
public class ControladorInicio implements ActionListener, MouseListener {

    Inicio vista;
    
    public enum AccionMVC {
        btnSQLite,
        btnSQL
    }
    
    public ControladorInicio(Inicio vista) {
        this.vista = vista;
    }
    
    public void iniciar() {
        
            this.vista.setVisible(true);
            this.vista.btnSQL.setActionCommand("btnSQL");
            this.vista.btnSQL.addActionListener(this);
            this.vista.btnSQLite.setActionCommand("btnSQLite");
            this.vista.btnSQLite.addActionListener(this);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (ControladorInicio.AccionMVC.valueOf(e.getActionCommand())) {
            case btnSQL:
                try {
                     //new ControladorSQL(new Interface()).iniciar();
                } catch (Exception ex) {
                }
                break;
            case btnSQLite:
                try {
                    new Controlador(new Interface()).iniciar();
                    this.vista.setVisible(false);
                } catch (Exception ex) {
                }
                break;
        }           
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
