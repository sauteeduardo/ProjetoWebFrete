/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByProId", query = "SELECT p FROM Produto p WHERE p.proId = :proId"),
    @NamedQuery(name = "Produto.findByProDescricao", query = "SELECT p FROM Produto p WHERE p.proDescricao = :proDescricao"),
    @NamedQuery(name = "Produto.findByProValorUnitario", query = "SELECT p FROM Produto p WHERE p.proValorUnitario = :proValorUnitario"),
    @NamedQuery(name = "Produto.findByProAtivo", query = "SELECT p FROM Produto p WHERE p.proAtivo = :proAtivo")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pro_descricao")
    private String proDescricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_valor_unitario")
    private BigDecimal proValorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_ativo")
    private boolean proAtivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<Entrega> entregaCollection;

    public Produto() {
    }

    public Produto(Integer proId) {
        this.proId = proId;
    }

    public Produto(Integer proId, String proDescricao, BigDecimal proValorUnitario, boolean proAtivo) {
        this.proId = proId;
        this.proDescricao = proDescricao;
        this.proValorUnitario = proValorUnitario;
        this.proAtivo = proAtivo;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProDescricao() {
        return proDescricao;
    }

    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    public BigDecimal getProValorUnitario() {
        return proValorUnitario;
    }

    public void setProValorUnitario(BigDecimal proValorUnitario) {
        this.proValorUnitario = proValorUnitario;
    }

    public boolean getProAtivo() {
        return proAtivo;
    }

    public void setProAtivo(boolean proAtivo) {
        this.proAtivo = proAtivo;
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
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return proDescricao;
    }
    
}
