/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Item;
import entity.ItemType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pupil
 */
public class ItemTypeFacade extends AbstractFacade<ItemType>{
    @PersistenceContext(unitName = "JPTVR19ClothesShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ItemTypeFacade(){
        super(ItemType.class);
    }    

}
