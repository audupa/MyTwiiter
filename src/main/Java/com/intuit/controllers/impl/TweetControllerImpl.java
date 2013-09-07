package com.intuit.controllers.impl;

import com.intuit.classes.Tweet;
import com.intuit.controllers.iface.TweetController;
import org.springframework.beans.factory.annotation.Autowired;
import com.intuit.dao.iface.TweetDAO;
import com.intuit.util.RenderErrorResponse;
import com.intuit.classes.ErrorResponse;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 9/7/13
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class TweetControllerImpl implements TweetController{

    @Autowired
    private TweetDAO tweetDAO;

    //use of only spring framework Jackson mapper to help map directly to JSON
    @RequestMapping(value="/twitter/users/showTweets",method=RequestMethod.GET)
    @ResponseBody
    public List<Tweet> handleShowAllTweetsRequest(@QueryParam("userId") int userId,HttpServletResponse response) {

        List<Tweet> allTweets = tweetDAO.showAllTweets(userId);
        if(allTweets!=null)
            return allTweets;
        else
            return null;

    }

    //sample : use of javax rs annotations  and use of GSONTOJSON

 /*   @POST
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

    }*/


    @RequestMapping(value="/twitter/addTweet",method=RequestMethod.POST)
    @ResponseBody
    public List<Tweet> handleAddTweetRequest(@QueryParam("userId")int userId,@QueryParam("message")String message){

        return (tweetDAO.insertTweet(userId,message));

    }

}
