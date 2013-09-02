package com.intuit.controllers;

import com.google.gson.Gson;
import com.intuit.classes.Tweet;
import com.intuit.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 9/1/13
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")

public class UserController {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @GET
    @RequestMapping("twitter/users/listAll")
    @ResponseBody
    public String showAllTweets(@QueryParam("userId") String userId) {

        List<User> users  = this.jdbcTemplate.query("Select user_name,email_id,created_time,updated_time from users" ,
                new BeanPropertyRowMapper(User.class));
        Gson gson = new Gson();
        // convert your list to json
        String jsonList = gson.toJson(users);
        return jsonList;
    }

    @PUT
    @RequestMapping("/twitter/user/follow/{userId}")
    @ResponseBody
    public String addFollower(@PathVariable("userId") String userId , @QueryParam("followerId") String followerId,HttpServletResponse response) {
        //check if the users exist
        int count = this.jdbcTemplate.queryForInt(
                "select count(0) from users where id = ?",
                new Object[]{userId});
        if(count==0){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "FAILURE";
        }
        int row = this.jdbcTemplate.update("INSERT INTO followers (user_id, follower_id) VALUES(?,?)",
                new Object[] { userId, followerId });

        if(row!=0)
            return "SUCCESS";
        else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "FAILURE";
        }


    }

}
