/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.repo;

import com.kelaskoding.entity.Product;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;

/**
 *
 * @author jarvis
 */
@ApplicationScoped
public class ProductRepo {

    @PersistenceContext(unitName = "dbitems_pu")
    private EntityManager em;

    @Transactional(REQUIRED)
    public void create(Product product) {
        em.persist(product);
    }

    public List<Product> findAll() {
        return em.createQuery("SELECT x FROM Product x").getResultList();
    }
    
    public List<Product> findByCategoryId(Long id){
         return em.createQuery("SELECT x FROM Product x WHERE x.category.id="+id).getResultList();
    }
    
    
    public Long findByCode(String code){
        Query query = em.createQuery("SELECT COUNT(x.id) FROM Product x WHERE x.code = :code").setParameter("code", code);
        Long count = (Long) query.getSingleResult();
        return count;
    }
    
    public Product findOne(Long id){
        return em.find(Product.class, id);
    }
    
    @Transactional(REQUIRED)
    public void removeOne(Long id){
        em.remove(em.find(Product.class, id));
    }
    
    @Transactional(REQUIRED)
    public Product update(Product product){
        return em.merge(product);
    }

}
