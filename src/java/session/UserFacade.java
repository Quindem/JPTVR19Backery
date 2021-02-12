/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alebro
 */
@Stateless
public class UserFacade extends AbstractFacade<User>{
   
    @PersistenceContext(unitName = "JPTVR19ClothesShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public UserFacade(){
        super(User.class);
    }    
    
    public User findByLogin(String login) {
        try {
            return (User) em.createQuery("SELECT u FROM User u WHERE u.login = :login")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean isRole(long roleID, User user) {
        if (user.getRoleID() == roleID)
            return true;
        return false;
    }

}