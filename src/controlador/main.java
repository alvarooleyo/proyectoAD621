/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.Interface;

/**
 *
 * @author Alejandro
 */
public class main {
    
    public static void main(String[] args) {
        
        new Controlador(new Interface()).iniciar();
    }
}
