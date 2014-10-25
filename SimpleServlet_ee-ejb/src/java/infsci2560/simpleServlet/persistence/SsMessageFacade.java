/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infsci2560.simpleServlet.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kolowitzbj
 */
@Stateless
public class SsMessageFacade extends AbstractFacade<SsMessage> implements SsMessageFacadeLocal {
    @PersistenceContext(unitName = "SimpleServlet_ee-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SsMessageFacade() {
        super(SsMessage.class);
    }
    
}
