/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Registers;

/**
 *
 * @author p3a_ruk
 */
@Stateless
public class RegistersFacade extends AbstractFacade<Registers> {
    @PersistenceContext(unitName = "06JavawebappPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistersFacade() {
        super(Registers.class);
    }
    
}
