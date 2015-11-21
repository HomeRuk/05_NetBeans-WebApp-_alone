/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author p3a_ruk
 */
@Entity
@Table(name = "register_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegisterDetails.findAll", query = "SELECT r FROM RegisterDetails r"),
    @NamedQuery(name = "RegisterDetails.findByRegid", query = "SELECT r FROM RegisterDetails r WHERE r.regid = :regid"),
    @NamedQuery(name = "RegisterDetails.findByRDRoom", query = "SELECT r FROM RegisterDetails r WHERE r.rDRoom = :rDRoom")})
public class RegisterDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Reg_id")
    private Integer regid;
    @Size(max = 10)
    @Column(name = "RD_Room")
    private String rDRoom;
    @JoinColumn(name = "Co_id", referencedColumnName = "Co_id")
    @ManyToOne
    private Course coid;
    @JoinColumn(name = "Reg_id", referencedColumnName = "Reg_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Registers registers;

    public RegisterDetails() {
    }

    public RegisterDetails(Integer regid) {
        this.regid = regid;
    }

    public Integer getRegid() {
        return regid;
    }

    public void setRegid(Integer regid) {
        this.regid = regid;
    }

    public String getRDRoom() {
        return rDRoom;
    }

    public void setRDRoom(String rDRoom) {
        this.rDRoom = rDRoom;
    }

    public Course getCoid() {
        return coid;
    }

    public void setCoid(Course coid) {
        this.coid = coid;
    }

    public Registers getRegisters() {
        return registers;
    }

    public void setRegisters(Registers registers) {
        this.registers = registers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regid != null ? regid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegisterDetails)) {
            return false;
        }
        RegisterDetails other = (RegisterDetails) object;
        if ((this.regid == null && other.regid != null) || (this.regid != null && !this.regid.equals(other.regid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.RegisterDetails[ regid=" + regid + " ]";
    }
    
}
