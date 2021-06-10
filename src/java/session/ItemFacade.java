/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Item;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alebro
 */
@Stateless
public class ItemFacade extends AbstractFacade<Item>{
   
    @PersistenceContext(unitName = "JPTVR19WebBakeryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ItemFacade(){
        super(Item.class);
    }    

}