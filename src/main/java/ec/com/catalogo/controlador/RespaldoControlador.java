/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.controlador;

import ec.com.catalogo.modelo.Respaldo;
import ec.com.catalogo.servicio.RespaldoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;


@Named("respaldoBEAN")
@ViewScoped 
public class RespaldoControlador implements Serializable{
    
    @EJB
    private RespaldoFacadeLocal respaldoEJB;
    
    private Respaldo respaldo;
    
    private List<Respaldo> listaRespaldos;
    
    @PostConstruct
    public void init() {
        this.respaldo = new Respaldo();
        this.listaRespaldos = respaldoEJB.findAll();
    }

    public Respaldo getRespaldo() {
        return this.respaldo;
    }

    public void setRespaldo(Respaldo respaldo) {
        this.respaldo = respaldo;
    }
    
    public void reiniciarRespaldoSeleccionado(){
        this.respaldo = new Respaldo();
    }
    
    public void editListener(RowEditEvent event) {
        try{
            Respaldo respaldoEditado = (Respaldo) event.getObject();
            respaldoEJB.edit(respaldoEditado);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Respaldo editado"
                    + " exitosamente."));
        } 
        catch(Exception ex) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo editar"
                    + " el Respaldo.\nError: " + ex.getMessage()));
        }
    }

    public List<Respaldo> getListaRespaldos() {
        return listaRespaldos;
    }

    public void setListaRespaldos(List<Respaldo> listaRespaldos) {
        this.listaRespaldos = listaRespaldos;
    }
    
    public void registrarRespaldo() {
        try{
            respaldoEJB.create(this.respaldo);
            this.respaldo = null;
            this.init();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Respaldo agregado"
                    + " exitosamente."));
        }catch(Exception ex){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo agregar"
                    + " el respaldo.\nError: " + ex.getMessage()));
        }
    }
    
    public void eliminarRespaldo() {
        try{
            respaldoEJB.remove(this.respaldo);
            this.respaldo = null;
            //actualizamos la lista
            this.init();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Respaldo eliminado"
                    + " exitosamente."));
        }catch(Exception ex) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo eliminar"
                    + " el respaldo.\nError: " + ex.getMessage()));
        }
        
    }
}
