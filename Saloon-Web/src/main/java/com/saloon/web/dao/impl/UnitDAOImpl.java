/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saloon.web.dao.impl;

import com.saloon.web.dao.UnitDAO;
import com.saloon.web.entity.Unit;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author USER
 */
@Repository(value = "unitDAO")
@Transactional
public class UnitDAOImpl implements UnitDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    private Transaction transaction;

    
    

    @Override
    
    public List<Unit> getAll() {
        session=sessionFactory.openSession();
        return session.createCriteria(Unit.class)
                .list();
    }

    @Override
    public int insert(Unit unit) {
        session=sessionFactory.openSession();
        int result=(int)session.save(unit);
        return result;
    }
    
}
