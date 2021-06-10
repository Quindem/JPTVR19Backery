/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Role;
import entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pupil
 */

@Stateless
public class RoleFacade extends AbstractFacade<Role>{
    
    @PersistenceContext(unitName = "JPTVR19WebBakeryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public RoleFacade(){
        super(Role.class);
    }    
    
    
    public boolean isRole(long roleID, User user) {
        try {
            User a = (User) em.createQuery("SELECT user FROM User user WHERE user.roleID = :roleID AND user.id = :userID")
                    .setParameter("roleID", roleID)
                    .setParameter("user", user.getId())
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
