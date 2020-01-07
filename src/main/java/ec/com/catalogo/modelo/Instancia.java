/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "instancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instancia.findAll", query = "SELECT i FROM Instancia i"),
    @NamedQuery(name = "Instancia.findByIdinstancia", query = "SELECT i FROM Instancia i WHERE i.idinstancia = :idinstancia"),
    @NamedQuery(name = "Instancia.findByNombre", query = "SELECT i FROM Instancia i WHERE i.nombre = :nombre")})
public class Instancia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinstancia")
    private Integer idinstancia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "idmotor", referencedColumnName = "idmotor")
    @ManyToOne(optional = false)
    private Motor idmotor;

    public Instancia() {
    }

    public Instancia(Integer idinstancia) {
        this.idinstancia = idinstancia;
    }

    public Instancia(Integer idinstancia, String nombre) {
        this.idinstancia = idinstancia;
        this.nombre = nombre;
    }

    public Integer getIdinstancia() {
        return idinstancia;
    }

    public void setIdinstancia(Integer idinstancia) {
        this.idinstancia = idinstancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Motor getIdmotor() {
        return idmotor;
    }

    public void setIdmotor(Motor idmotor) {
        this.idmotor = idmotor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinstancia != null ? idinstancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instancia)) {
            return false;
        }
        Instancia other = (Instancia) object;
        if ((this.idinstancia == null && other.idinstancia != null) || (this.idinstancia != null && !this.idinstancia.equals(other.idinstancia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Instancia[ idinstancia=" + idinstancia + " ]";
    }
    
}
