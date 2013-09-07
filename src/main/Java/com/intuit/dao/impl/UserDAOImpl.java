package com.intuit.dao.impl;

import com.intuit.classes.User;
import com.intuit.dao.iface.UserDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 9/7/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl  extends BaseDAOImpl implements UserDAO {

        public boolean userLogin(String userName,String password){
            User user;
            try{
                user = (User) this.jdbcTemplate.queryForObject(
                        "select * from users where user_name=? and password=?",
                        new Object[] { userName, password },
                        new BeanPropertyRowMapper(User.class));
            }
            catch (EmptyResultDataAccessException e) {
                return false;
            }
            return true;

        }


        //to show user's tweets
        public List<User> showAllUsers() {
            List<User> users  = this.jdbcTemplate.query("Select user_name,email_id,created_time,updated_time from users" ,
                    new BeanPropertyRowMapper(User.class));
            if(users.size()>0) {
                return users;
            }
            else
                return null;

        }

        // add a follower to a user
        public boolean addFollowerToAUser(int userId, int followerId)
        {
            //check if the users exist
            int count = this.jdbcTemplate.queryForInt(
                    "select count(0) from users where id = ?",
                    new Object[]{userId});

            if(count==0){
                return false;
            }
            int row = this.jdbcTemplate.update("INSERT INTO followers (user_id, follower_id) VALUES(?,?)",
                    new Object[] { userId, followerId });

            if(row!=0)
                return true;
            else {

                return false;
            }

        }

 }

