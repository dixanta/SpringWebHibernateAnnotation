/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saloon.web.dao.impl;

import com.saloon.web.dao.ColorDAO;
import com.saloon.web.entity.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository(value = "colorDAO")
public class ColorDAOImpl implements ColorDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Color> getAll() throws ClassNotFoundException, SQLException {
        return jdbcTemplate.query("select * from mst_colors",
                new RowMapper<Color>() {

            @Override
            public Color mapRow(ResultSet rs, int i) throws SQLException {
                Color color=new Color();
                color.setId(rs.getInt("id"));
                color.setName(rs.getString("name"));
                color.setCode(rs.getString("code"));
                color.setStatus(rs.getBoolean("status"));
                return color;
            }
        });
    }
    
}
