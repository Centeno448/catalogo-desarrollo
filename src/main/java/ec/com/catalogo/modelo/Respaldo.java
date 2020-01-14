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
@Table(name = "respaldo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respaldo.findAll", query = "SELECT r FROM Respaldo r"),
    @NamedQuery(name = "Respaldo.findByIdrespaldo", query = "SELECT r FROM Respaldo r WHERE r.idrespaldo = :idrespaldo"),
    @NamedQuery(name = "Respaldo.findByTipo", query = "SELECT r FROM Respaldo r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "Respaldo.findByPeriodicidad", query = "SELECT r FROM Respaldo r WHERE r.periodicidad = :periodicidad"),
    @NamedQuery(name = "Respaldo.findByTiempoHistorico", query = "SELECT r FROM Respaldo r WHERE r.tiempoHistorico = :tiempoHistorico"),
    @NamedQuery(name = "Respaldo.findByLugar", query = "SELECT r FROM Respaldo r WHERE r.lugar = :lugar"),
    @NamedQuery(name = "Respaldo.findByObservacion", query = "SELECT r FROM Respaldo r WHERE r.observacion = :observacion")})
public class Respaldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrespaldo")
    private Integer idrespaldo;
    @Size(max = 100)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 100)
    @Column(name = "periodicidad")
    private String periodicidad;
    @Size(max = 100)
    @Column(name = "tiempo_historico")
    private String tiempoHistorico;
    @Size(max = 100)
    @Column(name = "lugar")
    private String lugar;
    @Size(max = 45)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_base", referencedColumnName = "idbase")
    @ManyToOne(optional = true)
    private Base idBase;

    public Respaldo() {
    }

    public Respaldo(Integer idrespaldo) {
        this.idrespaldo = idrespaldo;
    }

    public Integer getIdrespaldo() {
        return idrespaldo;
    }

    public void setIdrespaldo(Integer idrespaldo) {
        this.idrespaldo = idrespaldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getTiempoHistorico() {
        return tiempoHistorico;
    }

    public void setTiempoHistorico(String tiempoHistorico) {
        this.tiempoHistorico = tiempoHistorico;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Base getIdBase() {
        return idBase;
    }

    public void setIdBase(Base idBase) {
        this.idBase = idBase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrespaldo != null ? idrespaldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respaldo)) {
            return false;
        }
        Respaldo other = (Respaldo) object;
        if ((this.idrespaldo == null && other.idrespaldo != null) || (this.idrespaldo != null && !this.idrespaldo.equals(other.idrespaldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Respaldo[ idrespaldo=" + idrespaldo + " ]";
    }
    
}
