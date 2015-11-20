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
@Table(name = "officer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Officer.findAll", query = "SELECT o FROM Officer o"),
    @NamedQuery(name = "Officer.findByOffid", query = "SELECT o FROM Officer o WHERE o.offid = :offid"),
    @NamedQuery(name = "Officer.findByOffname", query = "SELECT o FROM Officer o WHERE o.offname = :offname"),
    @NamedQuery(name = "Officer.findByOffpass", query = "SELECT o FROM Officer o WHERE o.offpass = :offpass"),
    @NamedQuery(name = "Officer.findByOffage", query = "SELECT o FROM Officer o WHERE o.offage = :offage"),
    @NamedQuery(name = "Officer.findByOffaddress", query = "SELECT o FROM Officer o WHERE o.offaddress = :offaddress")})
public class Officer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Off_id")
    private Integer offid;
    @Size(max = 40)
    @Column(name = "Off_name")
    private String offname;
    @Size(max = 40)
    @Column(name = "Off_pass")
    private String offpass;
    @Column(name = "Off_age")
    private Integer offage;
    @Size(max = 200)
    @Column(name = "Off_address")
    private String offaddress;
    @OneToMany(mappedBy = "offid")
    private Collection<Registers> registersCollection;

    public Officer() {
    }

    public Officer(Integer offid) {
        this.offid = offid;
    }

    public Integer getOffid() {
        return offid;
    }

    public void setOffid(Integer offid) {
        this.offid = offid;
    }

    public String getOffname() {
        return offname;
    }

    public void setOffname(String offname) {
        this.offname = offname;
    }

    public String getOffpass() {
        return offpass;
    }

    public void setOffpass(String offpass) {
        this.offpass = offpass;
    }

    public Integer getOffage() {
        return offage;
    }

    public void setOffage(Integer offage) {
        this.offage = offage;
    }

    public String getOffaddress() {
        return offaddress;
    }

    public void setOffaddress(String offaddress) {
        this.offaddress = offaddress;
    }

    @XmlTransient
    public Collection<Registers> getRegistersCollection() {
        return registersCollection;
    }

    public void setRegistersCollection(Collection<Registers> registersCollection) {
        this.registersCollection = registersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (offid != null ? offid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Officer)) {
            return false;
        }
        Officer other = (Officer) object;
        if ((this.offid == null && other.offid != null) || (this.offid != null && !this.offid.equals(other.offid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return offid + ""  ;
    }
    
}
