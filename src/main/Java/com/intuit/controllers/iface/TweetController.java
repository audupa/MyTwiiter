package com.intuit.controllers.iface;

import com.intuit.dao.iface.TweetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
/*import javax.ws.rs.*;
import javax.ws.rs.core.Response;*/
import java.util.List;

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

public interface TweetController {

    //use of only spring framework Jackson mapper to help map directly to JSON
    @RequestMapping(value="/twitter/users/showTweets",method=RequestMethod.GET)
    @ResponseBody
    public List<Tweet> handleShowAllTweetsRequest(@QueryParam("userId") int userId,HttpServletResponse response);

    @RequestMapping(value="/twitter/addTweet",method=RequestMethod.POST)
    @ResponseBody
    public List<Tweet> handleAddTweetRequest(@QueryParam("userId")int userId,@QueryParam("message")String message);

}
