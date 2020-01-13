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
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;


@Named
@ViewScoped
public class MotorControlador implements Serializable{
    
    @EJB
    private MotorFacadeLocal motorEJB;
    
    private Motor motor;
    
    private List<Motor> listaMotores;
    
    @PostConstruct
    public void init() {
        motor = new Motor();
        listaMotores = motorEJB.findAll();
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    
    public List<Motor> listarMotores() {
        return motorEJB.findAll();
    }
    
    public void reiniciarMotorSeleccionado(){
        motor = new Motor();
    }
    
    public void editListener(CellEditEvent event) {
        try{
            Motor motorEditado = motorEJB.find(Integer.parseInt(event.getRowKey()));
            String column_name=event.getColumn().getHeaderText();
            if(column_name.equals("Nombre")){
                motorEditado.setNombre(event.getNewValue().toString());
            }
            else
            {
                motorEditado.setVersion(event.getNewValue().toString());
            }
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
