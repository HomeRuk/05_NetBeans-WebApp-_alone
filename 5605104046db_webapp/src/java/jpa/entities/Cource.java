/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author p3a_ruk
 */
@Entity
@Table(name = "cource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cource.findAll", query = "SELECT c FROM Cource c"),
    @NamedQuery(name = "Cource.findByCoid", query = "SELECT c FROM Cource c WHERE c.coid = :coid"),
    @NamedQuery(name = "Cource.findByCocredit", query = "SELECT c FROM Cource c WHERE c.cocredit = :cocredit"),
    @NamedQuery(name = "Cource.findByCohours", query = "SELECT c FROM Cource c WHERE c.cohours = :cohours")})
public class Cource implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Co_id")
    private Integer coid;
    @Column(name = "Co_credit")
    private Integer cocredit;
    @Size(max = 3)
    @Column(name = "Co_hours")
    private String cohours;
    @OneToMany(mappedBy = "coid")
    private Collection<RegisterDetails> registerDetailsCollection;

    public Cource() {
    }

    public Cource(Integer coid) {
        this.coid = coid;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public Integer getCocredit() {
        return cocredit;
    }

    public void setCocredit(Integer cocredit) {
        this.cocredit = cocredit;
    }

    public String getCohours() {
        return cohours;
    }

    public void setCohours(String cohours) {
        this.cohours = cohours;
    }

    @XmlTransient
    public Collection<RegisterDetails> getRegisterDetailsCollection() {
        return registerDetailsCollection;
    }

    public void setRegisterDetailsCollection(Collection<RegisterDetails> registerDetailsCollection) {
        this.registerDetailsCollection = registerDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coid != null ? coid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cource)) {
            return false;
        }
        Cource other = (Cource) object;
        if ((this.coid == null && other.coid != null) || (this.coid != null && !this.coid.equals(other.coid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return coid + "" ;
    }
    
}
