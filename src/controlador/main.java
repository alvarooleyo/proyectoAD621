/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vista.Inicio;
import vista.Interface;

/**
 *
 * @author Alejandro
 */
public class main {
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
           
            //new Controlador(new Interface()).iniciar();
        } catch (ClassNotFoundException ex) {
            
        }
           
        
         new ControladorInicio(new Inicio()).iniciar();
    }
}
