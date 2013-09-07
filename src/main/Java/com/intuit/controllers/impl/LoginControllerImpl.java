package com.intuit.controllers.impl;

import com.intuit.controllers.iface.LoginController;
import com.intuit.dao.iface.UserDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 9/7/13
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class LoginControllerImpl implements LoginController {

    @Autowired
    private UserDAO userDAO;
    private static final Logger log = Logger.getLogger(LoginController.class);

    @RequestMapping("login")
    public ModelAndView showLoginPage(@RequestParam("userName") String userName, @RequestParam("password") String password) {


        boolean result = userDAO.userLogin(userName, password);
        if(result) {
            log.debug("login Success");
            return new ModelAndView("loginsuccess");
        }
        else
        {
            log.info("Login Failed");
            return new ModelAndView("loginFailure");
        }

    }
}
