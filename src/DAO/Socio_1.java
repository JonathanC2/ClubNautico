/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "socio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socio_1.findAll", query = "SELECT s FROM Socio_1 s")
    , @NamedQuery(name = "Socio_1.findByIdSocio", query = "SELECT s FROM Socio_1 s WHERE s.idSocio = :idSocio")
    , @NamedQuery(name = "Socio_1.findByNombre", query = "SELECT s FROM Socio_1 s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Socio_1.findByDireccion", query = "SELECT s FROM Socio_1 s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Socio_1.findByTelefono", query = "SELECT s FROM Socio_1 s WHERE s.telefono = :telefono")})
public class Socio_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSocio")
    private Integer idSocio;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Telefono")
    private String telefono;

    public Socio_1() {
    }

    public Socio_1(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public Socio_1(Integer idSocio, String nombre) {
        this.idSocio = idSocio;
        this.nombre = nombre;
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSocio != null ? idSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio_1)) {
            return false;
        }
        Socio_1 other = (Socio_1) object;
        if ((this.idSocio == null && other.idSocio != null) || (this.idSocio != null && !this.idSocio.equals(other.idSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Socio_1[ idSocio=" + idSocio + " ]";
    }
    
}
