/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entity;

import java.io.Serializable;
import java.util.Collection;
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
 * @author OWS-NEWHP
 */
@Entity
@Table(name = "caminhao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caminhao.findAll", query = "SELECT c FROM Caminhao c"),
    @NamedQuery(name = "Caminhao.findByCamId", query = "SELECT c FROM Caminhao c WHERE c.camId = :camId"),
    @NamedQuery(name = "Caminhao.findByCamPlaca", query = "SELECT c FROM Caminhao c WHERE c.camPlaca = :camPlaca"),
    @NamedQuery(name = "Caminhao.findByCamTipo", query = "SELECT c FROM Caminhao c WHERE c.camTipo = :camTipo")})
public class Caminhao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cam_id")
    private Integer camId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cam_placa")
    private String camPlaca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cam_tipo")
    private String camTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camId")
    private Collection<Entrega> entregaCollection;

    public Caminhao() {
    }

    public Caminhao(Integer camId) {
        this.camId = camId;
    }

    public Caminhao(Integer camId, String camPlaca, String camTipo) {
        this.camId = camId;
        this.camPlaca = camPlaca;
        this.camTipo = camTipo;
    }

    public Integer getCamId() {
        return camId;
    }

    public void setCamId(Integer camId) {
        this.camId = camId;
    }

    public String getCamPlaca() {
        return camPlaca;
    }

    public void setCamPlaca(String camPlaca) {
        this.camPlaca = camPlaca;
    }

    public String getCamTipo() {
        return camTipo;
    }

    public void setCamTipo(String camTipo) {
        this.camTipo = camTipo;
    }

    @XmlTransient
    public Collection<Entrega> getEntregaCollection() {
        return entregaCollection;
    }

    public void setEntregaCollection(Collection<Entrega> entregaCollection) {
        this.entregaCollection = entregaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (camId != null ? camId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caminhao)) {
            return false;
        }
        Caminhao other = (Caminhao) object;
        if ((this.camId == null && other.camId != null) || (this.camId != null && !this.camId.equals(other.camId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return camPlaca;
    }
    
}
