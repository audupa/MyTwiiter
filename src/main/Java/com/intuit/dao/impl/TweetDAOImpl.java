package com.intuit.dao.impl;

import java.util.List;
import com.intuit.classes.*;
import com.intuit.dao.iface.TweetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 9/7/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class TweetDAOImpl extends BaseDAOImpl implements TweetDAO {

    /*@Autowired
    Tweet tweet;*/

    @Autowired
    DataSource dataSource;

    //to show all tweets
    public List<Tweet> showAllTweets(int userId) {
        List<Tweet> tweets;
        try{
            tweets  = this.jdbcTemplate.query("Select * from tweets where user_id="+userId ,
                    new BeanPropertyRowMapper(Tweet.class));
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
        return tweets;
    }

    //to add a tweet
    public List<Tweet> insertTweet(int userId,String message) {

        List<Tweet> returnTweet;
        //to return id of the added row 's id

        Tweet tweet = new Tweet();

        tweet.setUserId(userId);
        tweet.setTweetMessage(message);
        tweet.setCreatedDate(null);
        tweet.setUpdatedDate(null);

        long id = new SimpleJdbcInsert(dataSource).
                withTableName("tweets").
                usingColumns("user_id", "tweet_message").
                usingGeneratedKeyColumns("id").
                executeAndReturnKey(new BeanPropertySqlParameterSource(tweet)).longValue();

        System.out.println("************************"+id);

        try {
            returnTweet  = this.jdbcTemplate.query("Select * from tweets where id="+id ,
                    new BeanPropertyRowMapper(Tweet.class));
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
        return returnTweet;

    }

}
