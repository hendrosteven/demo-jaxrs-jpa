/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.repo;

import com.kelaskoding.entity.Category;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;

/**
 *
 * @author jarvis
 */
@ApplicationScoped
public class CategoryRepo {
    
    @PersistenceContext(unitName = "dbitems_pu")
    private EntityManager em;
    
    @Transactional(REQUIRED)
    public void create(Category category){
        em.persist(category);
    }
    
    public List<Category> findAll(){
        return em.createQuery("SELECT x FROM Category x").getResultList();
    }
    
    public Category findOne(Long id){
        return em.find(Category.class, id);
    }
    
    @Transactional(REQUIRED)
    public void removeOne(Long id){
        em.remove(em.find(Category.class, id));
    }
    
    @Transactional(REQUIRED)
    public Category update(Category category){
        return em.merge(category);
    }
    
}
