/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.RegisterDetails;

/**
 *
 * @author p3a_ruk
 */
@Stateless
public class RegisterDetailsFacade extends AbstractFacade<RegisterDetails> {
    @PersistenceContext(unitName = "06JavawebappPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegisterDetailsFacade() {
        super(RegisterDetails.class);
    }
    
}
