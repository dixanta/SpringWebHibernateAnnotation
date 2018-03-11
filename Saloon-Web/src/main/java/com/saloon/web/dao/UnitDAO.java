/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saloon.web.dao;

import com.saloon.web.entity.Unit;
import java.util.List;

/**
 *
 * @author USER
 */
public interface UnitDAO {
    List<Unit> getAll();
    int insert(Unit unit);
}
