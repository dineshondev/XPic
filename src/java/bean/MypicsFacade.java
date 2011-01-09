/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dinesh
 */
@Stateless
public class MypicsFacade extends AbstractFacade<Mypics> {
    @PersistenceContext(unitName = "xpicPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MypicsFacade() {
        super(Mypics.class);
    }

}
