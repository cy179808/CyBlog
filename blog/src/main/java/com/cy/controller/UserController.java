package com.cy.controller;


import com.cy.common.lang.Result;
import com.cy.entity.User;
import com.cy.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cy
 * @since 2021-03-24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Result index(){
        User user = userService.getById(1L);
        return Result.success(user);
    }

}
