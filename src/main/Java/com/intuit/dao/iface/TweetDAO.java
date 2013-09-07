package com.intuit.dao.iface;

import com.intuit.classes.Tweet;
import com.intuit.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 6/28/13
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */

public interface TweetDAO {

    //show all the tweets for a user
    public List<Tweet> showAllTweets(int userId);
    //to add a tweet
    public List<Tweet> insertTweet(int userId,String message);

}

