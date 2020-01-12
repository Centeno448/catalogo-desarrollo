/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.controlador;

import ec.com.catalogo.modelo.Motor;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class MotorControlador implements Serializable{
    
    private Motor motor;
    
    @PostConstruct
    public void init() {
        motor = new Motor();
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
