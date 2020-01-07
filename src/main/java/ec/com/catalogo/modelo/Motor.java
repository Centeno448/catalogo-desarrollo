/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "motor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motor.findAll", query = "SELECT m FROM Motor m"),
    @NamedQuery(name = "Motor.findByIdmotor", query = "SELECT m FROM Motor m WHERE m.idmotor = :idmotor"),
    @NamedQuery(name = "Motor.findByNombre", query = "SELECT m FROM Motor m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Motor.findByVersion", query = "SELECT m FROM Motor m WHERE m.version = :version")})
public class Motor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmotor")
    private Integer idmotor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "version")
    private String version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmotor")
    private List<Instancia> instanciaList;

    public Motor() {
    }

    public Motor(Integer idmotor) {
        this.idmotor = idmotor;
    }

    public Motor(Integer idmotor, String nombre, String version) {
        this.idmotor = idmotor;
        this.nombre = nombre;
        this.version = version;
    }

    public Integer getIdmotor() {
        return idmotor;
    }

    public void setIdmotor(Integer idmotor) {
        this.idmotor = idmotor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlTransient
    public List<Instancia> getInstanciaList() {
        return instanciaList;
    }

    public void setInstanciaList(List<Instancia> instanciaList) {
        this.instanciaList = instanciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmotor != null ? idmotor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motor)) {
            return false;
        }
        Motor other = (Motor) object;
        if ((this.idmotor == null && other.idmotor != null) || (this.idmotor != null && !this.idmotor.equals(other.idmotor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Motor[ idmotor=" + idmotor + " ]";
    }
    
}
