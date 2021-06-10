/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;


import entity.History;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pupil
 */

@Stateless
public class HistoryFacade extends AbstractFacade<History>{
    
    @PersistenceContext(unitName = "JPTVR19WebBakeryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public HistoryFacade(){
        super(History.class);
    }    
    
    
    public List<History> findAllById(double login) {
        return (List<History>) em.createQuery("SELECT * FROM User u WHERE u.USER_ID = :login")
                .setParameter("login", login)
                .getSingleResult();

    }
}


