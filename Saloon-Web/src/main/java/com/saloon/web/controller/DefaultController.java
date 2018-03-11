/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saloon.web.controller;

import com.saloon.web.dao.ColorDAO;
import com.saloon.web.dao.UnitDAO;
import com.saloon.web.entity.Unit;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {
    @Autowired
    private ColorDAO colorDAO;
    @Autowired
    private UnitDAO unitDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        try{
        model.addAttribute("colors",colorDAO.getAll());
        return "index";
        }catch(ClassNotFoundException | SQLException se){
            System.out.println(se.getMessage());
            return null;
        }
    }
    
    @RequestMapping(value="/save",method = RequestMethod.GET)
    public @ResponseBody String save(){
        int result = unitDAO.insert(new Unit(0,"Mili Gram", "mg", true));
        String content="";
        for(Unit u : unitDAO.getAll()){
            content +="<h1>"+u.getName()+"</h1>";
        }
        return result + "<br/>"+content;
    }
}
