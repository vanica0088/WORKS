package com.koalait.demo.Controller;

import com.koalait.demo.Entity.Resume;
import com.koalait.demo.Entity.UserInfo;
import com.koalait.demo.Mapper.ResumeMapper;
import com.koalait.demo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("koalaresume")
public class ResumeRestController {
    @Autowired
    private ResumeMapper resumeMapper;

    /**
     *
     * @param resume_id 简历标识ID
     * @return 返回用户简历信息
     */
    //查询我的信息
    @GetMapping("/getresume")
    public Map<String, Object> getResume(Integer resume_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Resume resume = resumeMapper.findResumeByID(resume_id);
        modelMap.put("resumeList", resume);
        return modelMap;
    }

    /**
     *
     * @param resume 取得修改的简历信息
     * @return 返回修改语句执行结果
     */
    //更改我的信息
    @PostMapping("/updresume")
    public Map<String, Object> updateResume(@RequestBody Resume resume){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", resumeMapper.updResumeByID(resume));
        return modelMap;
    }

    /**
     *
     * @param resume 取得新增简历的信息
     * @return 返回执行结果
     */
    //新增简历
    @PostMapping("/addresume")
    public Map<String, Object> addResume(@RequestBody Resume resume
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", resumeMapper.addResumeInfo(resume));
        return modelMap;
    }

    /**
     *
     * @param user_name 取得关联简历信息所需要的值
     * @return  返回三表合并有关结果
     */
    @GetMapping("/orderresume")
    public Map<String, Object> orderResume(String user_name){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Resume resume = resumeMapper.findResumeByName(user_name);
        modelMap.put("resumeList", resume);
        return modelMap;
    }
}
