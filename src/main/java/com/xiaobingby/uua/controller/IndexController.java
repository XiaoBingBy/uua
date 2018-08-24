package com.xiaobingby.uua.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiaoBingBy
 * @date 2018-08-24 11:32
 * @since 1.0
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PreAuthorize("@pms.hasPermission('sys_super_admin')")
    @GetMapping("/admin-user")
    public String adminUser() {
        return "/admin-user";
    }

    @GetMapping("/authentication")
    public Object authentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

}
