/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author OWS-NEWHP
 */
@Entity
@Table(name = "entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e"),
    @NamedQuery(name = "Entrega.findByEntId", query = "SELECT e FROM Entrega e WHERE e.entId = :entId"),
    @NamedQuery(name = "Entrega.findByEntDataEntrega", query = "SELECT e FROM Entrega e WHERE e.entDataEntrega = :entDataEntrega")})
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ent_id")
    private Integer entId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ent_data_entrega")
    @Temporal(TemporalType.DATE)
    private Date entDataEntrega;
    @JoinColumn(name = "cam_id", referencedColumnName = "cam_id")
    @ManyToOne(optional = false)
    private Caminhao camId;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne(optional = false)
    private Produto proId;

    public Entrega() {
    }

    public Entrega(Integer entId) {
        this.entId = entId;
    }

    public Entrega(Integer entId, Date entDataEntrega) {
        this.entId = entId;
        this.entDataEntrega = entDataEntrega;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public Date getEntDataEntrega() {
        return entDataEntrega;
    }

    public void setEntDataEntrega(Date entDataEntrega) {
        this.entDataEntrega = entDataEntrega;
    }

    public Caminhao getCamId() {
        return camId;
    }

    public void setCamId(Caminhao camId) {
        this.camId = camId;
    }

    public Produto getProId() {
        return proId;
    }

    public void setProId(Produto proId) {
        this.proId = proId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entId != null ? entId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.entId == null && other.entId != null) || (this.entId != null && !this.entId.equals(other.entId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entrega: "+entId;
    }
    
}
