package com.intuit.controllers;

import com.intuit.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 12/14/12
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    public  LoginController(){

    }
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @RequestMapping("/login")
    public ModelAndView showLoginPage(@RequestParam("login") String userName, @RequestParam("password") String password) {

       /* String sql = "select * from users where user_name = ? and password = ? ";
        if(jdbcTemplate.queryForInt(sql, new Object[] { username,password } ,User.class)==1)
            return "loginsuccess";
        else
            return "loginFailure";*/


        try {
            User user = (User) this.jdbcTemplate.queryForObject(
                    "select * from users where user_name=? and password=?",
                    new Object[] { userName, password },
                    new BeanPropertyRowMapper(User.class));
            if(user!=null)
                //return "loginsuccess";
                return new ModelAndView("loginsuccess","user",user);
            else
                return new ModelAndView("loginFailure");
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }




   /* @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld(){

        ModelAndView model = new ModelAndView("HelloWorldPage");
        model.addObject("msg", "hello world");

        return model;
    }*/


}
