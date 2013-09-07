package com.intuit.dao.iface;

import com.intuit.classes.ErrorResponse;
import com.intuit.classes.User;
import com.intuit.util.RenderErrorResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.net.HttpURLConnection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 9/3/13
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */

public interface UserDAO {

    public boolean userLogin(String userName,String password);
    //to show user's tweets
    public List<User> showAllUsers();
    // add a follower to a user
    public boolean addFollowerToAUser(int userId, int followerId);
}
