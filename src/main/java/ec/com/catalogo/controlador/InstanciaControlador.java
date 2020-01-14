/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.controlador;

import ec.com.catalogo.modelo.Instancia;
import ec.com.catalogo.modelo.Motor;
import ec.com.catalogo.servicio.InstanciaFacadeLocal;
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


@Named("instanciaBean")
@ViewScoped
public class InstanciaControlador implements Serializable{
    
    @EJB
    private InstanciaFacadeLocal instanciaEJB;
    
    @EJB
    private MotorFacadeLocal motorEJB;
    
    private Instancia instancia;
    
    private List<Instancia> listaInstancias;
    
    private List<Motor> listaMotores;
    
    @PostConstruct
    public void init() {
        this.instancia = new Instancia();
        this.listaInstancias = instanciaEJB.findAll();
        this.listaMotores = motorEJB.findAll();
    }

    public Instancia getInstancia() {
        return instancia;
    }

    public void setInstancia(Instancia instancia) {
        this.instancia = instancia;
    }

    public List<Instancia> getListaInstancias() {
        return listaInstancias;
    }

    public void setListaInstancias(List<Instancia> listaInstancias) {
        this.listaInstancias = listaInstancias;
    }

    public List<Motor> getListaMotores() {
        return listaMotores;
    }

    public void setListaMotores(List<Motor> listaMotores) {
        this.listaMotores = listaMotores;
    }
    
    public void reiniciarInstanciaSeleccionada(){
        this.instancia = new Instancia();
    }
    
    public void editListener(RowEditEvent event) {
        try{
            Instancia instanciaEditada = (Instancia) event.getObject();
            instanciaEJB.edit(instanciaEditada);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Instancia editada"
                    + " exitosamente."));
        } 
        catch(Exception ex) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo editar"
                    + " la Instancia.\nError: " + ex.getMessage()));
        }
    }
    
    public void registrarInstancia() {
        try{
            instanciaEJB.create(this.instancia);
            this.instancia = null;
            this.init();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Instancia agregada"
                    + " exitosamente."));
        }catch(Exception ex){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo agregar"
                    + " la instancia.\nError: " + ex.getMessage()));
        }
    }
    
    public void eliminarInstancia() {
        try{
            instanciaEJB.remove(this.instancia);
            this.instancia = null;
            //actualizamos la lista
            this.init();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Instancia eliminada"
                    + " exitosamente."));
        }catch(Exception ex) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo eliminar"
                    + " la instancia.\nError: " + ex.getMessage()));
        }
        
    }
}
