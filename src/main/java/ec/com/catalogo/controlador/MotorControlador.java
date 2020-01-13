/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.controlador;

import ec.com.catalogo.modelo.Motor;
import ec.com.catalogo.servicio.MotorFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;


@Named("motorBEAN")
@ViewScoped
public class MotorControlador implements Serializable{
    
    @EJB
    private MotorFacadeLocal motorEJB;
    
    private Motor motor;
    
    private List<Motor> listaMotores;
    
    @PostConstruct
    public void init() {
        this.motor = new Motor();
        this.listaMotores = motorEJB.findAll();
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    
    public void reiniciarMotorSeleccionado(){
        motor = new Motor();
    }
    
    public void editListener(RowEditEvent event) {
        try{
            Motor motorEditado = (Motor) event.getObject();
            motorEJB.edit(motorEditado);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Motor editado"
                    + " exitosamente."));
        } 
        catch(Exception ex) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo editar"
                    + " el motor.\nError: " + ex.getMessage()));
        }
    }

    public List<Motor> getListaMotores() {
        return listaMotores;
    }

    public void setListaMotores(List<Motor> listaMotores) {
        this.listaMotores = listaMotores;
    }
    
    public void registrarMotor() {
        try{
            motorEJB.create(this.motor);
            this.motor = null;
            this.init();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Motor agregado"
                    + " exitosamente."));
        }catch(Exception ex){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo agregar"
                    + " el motor.\nError: " + ex.getMessage()));
        }
    }
    
    public void eliminarMotor() {
        try{
            motorEJB.remove(this.motor);
            this.motor = null;
            //actualizamos la lista
            this.init();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Motor eliminado"
                    + " exitosamente."));
        }catch(Exception ex) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo eliminar"
                    + " el motor.\nError: " + ex.getMessage()));
        }
        
    }
}
