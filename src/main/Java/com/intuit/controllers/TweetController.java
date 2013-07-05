package com.intuit.controllers;

import com.intuit.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 6/28/13
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class TweetController {

    public TweetController(){

    }

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Path("twitter/users/showTweets")
    @GET
    @Produces("application/json")
    public Response showAllTweets(@QueryParam("userId") int userId) {
        String result = "UserId in the request : " + userId;
        return Response.status(201).entity(result).build();
    }

}
