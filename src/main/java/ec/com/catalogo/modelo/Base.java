/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Base.findAll", query = "SELECT b FROM Base b"),
    @NamedQuery(name = "Base.findByIdbase", query = "SELECT b FROM Base b WHERE b.idbase = :idbase"),
    @NamedQuery(name = "Base.findByNombre", query = "SELECT b FROM Base b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Base.findByTamanio", query = "SELECT b FROM Base b WHERE b.tamanio = :tamanio"),
    @NamedQuery(name = "Base.findByUsoDisco", query = "SELECT b FROM Base b WHERE b.usoDisco = :usoDisco"),
    @NamedQuery(name = "Base.findByEstado", query = "SELECT b FROM Base b WHERE b.estado = :estado"),
    @NamedQuery(name = "Base.findByIp", query = "SELECT b FROM Base b WHERE b.ip = :ip"),
    @NamedQuery(name = "Base.findByIdAdmin", query = "SELECT b FROM Base b WHERE b.idAdmin = :idAdmin"),
    @NamedQuery(name = "Base.findByIdAdminUser", query = "SELECT b FROM Base b WHERE b.idAdminUser = :idAdminUser"),
    @NamedQuery(name = "Base.findByIdOperador", query = "SELECT b FROM Base b WHERE b.idOperador = :idOperador"),
    @NamedQuery(name = "Base.findByIdOperadorUser", query = "SELECT b FROM Base b WHERE b.idOperadorUser = :idOperadorUser"),
    @NamedQuery(name = "Base.findByIdDba", query = "SELECT b FROM Base b WHERE b.idDba = :idDba")})
public class Base implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbase")
    private Integer idbase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tamanio")
    private BigDecimal tamanio;
    @Column(name = "uso_disco")
    private BigDecimal usoDisco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ip")
    private String ip;
    @Column(name = "id_admin")
    private Integer idAdmin;
    @Column(name = "id_admin_user")
    private Integer idAdminUser;
    @Column(name = "id_operador")
    private Integer idOperador;
    @Column(name = "id_operador_user")
    private Integer idOperadorUser;
    @Column(name = "id_dba")
    private Integer idDba;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBase")
    private List<Respaldo> respaldoList;
    @JoinColumn(name = "id_servicio", referencedColumnName = "idservicio")
    @ManyToOne(optional = false)
    private Servicio idServicio;

    public Base() {
    }

    public Base(Integer idbase) {
        this.idbase = idbase;
    }

    public Base(Integer idbase, String nombre, boolean estado, String ip) {
        this.idbase = idbase;
        this.nombre = nombre;
        this.estado = estado;
        this.ip = ip;
    }

    public Integer getIdbase() {
        return idbase;
    }

    public void setIdbase(Integer idbase) {
        this.idbase = idbase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getTamanio() {
        return tamanio;
    }

    public void setTamanio(BigDecimal tamanio) {
        this.tamanio = tamanio;
    }

    public BigDecimal getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(BigDecimal usoDisco) {
        this.usoDisco = usoDisco;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdAdminUser() {
        return idAdminUser;
    }

    public void setIdAdminUser(Integer idAdminUser) {
        this.idAdminUser = idAdminUser;
    }

    public Integer getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
    }

    public Integer getIdOperadorUser() {
        return idOperadorUser;
    }

    public void setIdOperadorUser(Integer idOperadorUser) {
        this.idOperadorUser = idOperadorUser;
    }

    public Integer getIdDba() {
        return idDba;
    }

    public void setIdDba(Integer idDba) {
        this.idDba = idDba;
    }

    @XmlTransient
    public List<Respaldo> getRespaldoList() {
        return respaldoList;
    }

    public void setRespaldoList(List<Respaldo> respaldoList) {
        this.respaldoList = respaldoList;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbase != null ? idbase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Base)) {
            return false;
        }
        Base other = (Base) object;
        if ((this.idbase == null && other.idbase != null) || (this.idbase != null && !this.idbase.equals(other.idbase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Base[ idbase=" + idbase + " ]";
    }
    
}
