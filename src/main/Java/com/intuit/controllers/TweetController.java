package com.intuit.controllers;

import com.google.gson.Gson;
import com.intuit.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.intuit.classes.Tweet;

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

    @GET
    @RequestMapping("/twitter/users/showTweets")
    @ResponseBody
    public String showAllTweets(@QueryParam("userId") String userId) {

        List<Tweet> tweets  = this.jdbcTemplate.query("Select * from tweets where user_id="+userId ,
                new BeanPropertyRowMapper(Tweet.class));
        Gson gson = new Gson();
        // convert your list to json
        String jsonList = gson.toJson(tweets);
        return jsonList;
    }

    @POST
    @Transactional (propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
    @RequestMapping("/twitter/addTweet")
    @Produces("application/json")
    @ResponseBody
    public String addTweet(@QueryParam("userId")String userId,@QueryParam("message")String message){
        int row = this.jdbcTemplate.update("INSERT INTO tweets (user_id, tweet_message) VALUES(?,?)",
                new Object[] { userId, message });
        Gson gson = new Gson();
        if(row!=0){
            List<Tweet> tweets  = this.jdbcTemplate.query("Select * from tweets where user_id="+userId ,
                new BeanPropertyRowMapper(Tweet.class));

            // convert your list to json
            String jsonList = gson.toJson(tweets);
            return jsonList;
        }

        return null;

    }

}
