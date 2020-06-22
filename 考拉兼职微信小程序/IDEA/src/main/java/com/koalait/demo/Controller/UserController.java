package com.koalait.demo.Controller;

import com.koalait.demo.Entity.UserInfo;
import com.koalait.demo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("check")
//@RequestMapping("koalait")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    //以下为审核user的功能，无用可删除
//    @GetMapping("/user")
//    public String getCB(Model model) {
//        List<UserInfo> lists = userMapper.getAllUser();
//        model.addAttribute("user", lists);
//        return "checkuser";
//    }
//
//    @RequestMapping("/newuser/{UserInfo.user_id}")
//    public String updateUserInfo(@PathVariable("UserInfo.user_id") Integer user_id, Model model) {
//        UserInfo newuser = userMapper.getUserByid(user_id);
//        model.addAttribute("newuser", newuser);
//        userMapper.updateUserByID(newuser);
//        return "redirect:/check/user";
//    }
//
//    @RequestMapping("/olduser/{UserInfo.user_id}")
//    public String updateUser(@PathVariable("UserInfo.user_id") Integer user_id, Model model) {
//        UserInfo olduser = userMapper.getUserByid(user_id);
//        model.addAttribute("olduser", olduser);
//        userMapper.updateUser(olduser);
//        return "redirect:/check/user";
//    }
}
