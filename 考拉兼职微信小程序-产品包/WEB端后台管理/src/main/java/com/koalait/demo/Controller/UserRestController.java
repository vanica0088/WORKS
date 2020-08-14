package com.koalait.demo.Controller;


import com.koalait.demo.Entity.UserInfo;
import com.koalait.demo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("koalauser")
public class UserRestController {

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param userInfo 取得登入信息
     * @return 返回登入结果
     */
    //登入
    @PostMapping("/login")
    public Map<String, Object> UserLogin(@RequestBody UserInfo userInfo) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Integer user = userMapper.userLogin(userInfo.getPassword(), userInfo.getUser_name());
        if (user != null) {
            //session.setAttribute("user", user)
            modelMap.put("success", user);
        }
        return modelMap;
    }

    /**
     *
     * @param user_id 用户标识ID
     * @return 返回个人信息
     */
    //查询我的信息
    @GetMapping("/myinfo")
    public Map<String, Object> getUserInfo(Integer user_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        UserInfo userInfo = userMapper.findUserByID(user_id);
        modelMap.put("userList", userInfo);
        return modelMap;
    }

    /**
     *
     * @param userInfo 取得修改的个人信息
     * @return  返回修改语句结果
     */
    //更改我的信息
    @PostMapping("/updmyinfo")
    public Map<String, Object> updateUserInfo(@RequestBody UserInfo userInfo
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userMapper.updUserInfo(userInfo));
        return modelMap;
    }

    /**
     *
     * @param userInfo 取得修改简历的有关信息
     * @return 返回修改简历的执行结果
     */
    @PostMapping("/updresume")
    public Map<String, Object> updresume(@RequestBody UserInfo userInfo
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userMapper.updresumeInfo(userInfo));
        return modelMap;
    }

    /**
     *
     * @param userInfo 取得注册用户的信息
     * @return 返回注册信息执行结果
     */
    //注册
    @PostMapping("/register")
    public Map<String, Object> registerUserInfo(@RequestBody UserInfo userInfo
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userMapper.register(userInfo));
        return modelMap;
    }



}
