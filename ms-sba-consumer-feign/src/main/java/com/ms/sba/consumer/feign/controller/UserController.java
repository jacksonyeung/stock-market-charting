package com.ms.sba.consumer.feign.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.sba.consumer.feign.feign.UserApiFeign;
import com.ms.sba.consumer.feign.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserApiFeign userApiFeign;

    @GetMapping(value = "/login")
    public String login(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }

    @PostMapping(value = "/dashboard")
    public String signIn(HttpServletRequest request, Model model, User user) {

        if(!user.getUsername().isEmpty() && !user.getPassword().isEmpty()) {
            ResponseEntity<Map<String, Object>> responseEntity = userApiFeign.signIn(user);
            Map<String, Object> resultMap = responseEntity.getBody();

            String resultCode = (String) resultMap.get("code");
            model.addAttribute("errorCode", resultCode);

            if (StringUtils.equals("0000", resultCode)) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

                User currentUser = mapper.convertValue(resultMap.get("data"), User.class);
                request.getSession().setAttribute("currentUser", currentUser);
                model.addAttribute("username", currentUser.getUsername());

                return "sba/dashboard";
            }
        }

        return "login";
    }

    @PostMapping(value = "/signup")
    @ResponseBody
    public Map<String, Object> signUp(Model model, User newUser) {

        if (newUser != null)
            newUser.setUserType("user");

        ResponseEntity<Map<String, Object>> responseEntity = userApiFeign.signUp(newUser);
        Map<String, Object> resultMap = responseEntity.getBody();

        String resultCode = (String) resultMap.get("code");
        if (StringUtils.equals("0000", resultCode))
            resultMap.put("viewName", "login");

        return resultMap;
    }
}
