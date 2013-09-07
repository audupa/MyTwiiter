package com.intuit.controllers.iface;

import com.intuit.classes.ErrorResponse;
import com.intuit.classes.User;
import com.intuit.dao.iface.UserDAO;
import com.intuit.util.RenderErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Date: 9/1/13
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")

public interface UserController {

    @RequestMapping(value="twitter/users/listAll",method = RequestMethod.GET )
    @ResponseBody
    public List<User> handleShowAllUsersRequest();

    @RequestMapping(value="/twitter/user/follow/{userId}",method = RequestMethod.PUT)
    @ResponseBody
    public ErrorResponse handleAddFollowerRequest(@PathVariable("userId") int userId , @QueryParam("followerId") int followerId,HttpServletResponse response);
}
