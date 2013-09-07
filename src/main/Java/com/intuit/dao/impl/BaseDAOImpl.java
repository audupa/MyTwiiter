package com.intuit.dao.impl;

import com.intuit.dao.iface.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 9/7/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseDAOImpl implements BaseDAO {

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   @Autowired
    protected JdbcTemplate jdbcTemplate;
}
