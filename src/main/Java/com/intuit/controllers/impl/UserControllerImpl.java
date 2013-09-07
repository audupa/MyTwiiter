package com.intuit.controllers.impl;

import com.intuit.classes.User;
import com.intuit.controllers.iface.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import com.intuit.dao.iface.UserDAO;
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
public class UserControllerImpl implements UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    RenderErrorResponse renderErrorResponse;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value="twitter/users/listAll",method = RequestMethod.GET )
    @ResponseBody
    public List<User> handleShowAllUsersRequest() {
        List<User> users = userDAO.showAllUsers();
        if(users!=null)
            return users;
        else
            return null;
    }


    @RequestMapping(value="/twitter/user/follow/{userId}",method = RequestMethod.PUT)
    @ResponseBody
    public ErrorResponse handleAddFollowerRequest(@PathVariable("userId") int userId , @QueryParam("followerId") int followerId,HttpServletResponse response) {

        boolean result = userDAO.addFollowerToAUser(userId,followerId);
        if(!result)  {
            errorResponse = renderErrorResponse.renderError(HttpServletResponse.SC_BAD_REQUEST,"User not found ! Couldn't add the follower",response);
            return errorResponse;
        }
        return null;
    }
}
