package com.koalait.demo.Controller;


import com.koalait.demo.Entity.BossConnect;
import com.koalait.demo.Mapper.BossConnectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("bossconnect")
public class BossConnectController {
    @Autowired
    private BossConnectMapper bossConnectMapper;

    /**
     *
     * @param bossConnect 页面接收需要添加预约信息的user_id和boss_id已BossConnect的形式接收
     * @return存在modelMap的形式返回预约页面
     */
    //增加预约关联
    @PostMapping("/orderboss")
    public Map<String, Object> addBossInfo(@RequestBody BossConnect bossConnect
                                           ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", bossConnectMapper.addBossConnect(bossConnect));
        return modelMap;
    }

    /**
     *
     * @param bossConnect 同上，取出修改数据库所需的主键
     * @return 返回语句执行结果（1/0）
     */
    //取消预约
    @GetMapping("/delorder")
    public Map<String, Object> delBossInfo(BossConnect bossConnect){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",bossConnectMapper.delBossConnect(bossConnect));
        return modelMap;
    }

    /**
     *
     * @param user_id 用户ID
     * @return 返回该用户的所有boss预约信息
     */
    @GetMapping("/getorder")
    public Map<String, Object> getResume(Integer user_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<BossConnect> bossConnect = bossConnectMapper.findBossByID(user_id);
        modelMap.put("infoList", bossConnect);
        return modelMap;
    }

    /**
     *
     * @param bossConnect 取出修改boss方对该预约意见所需要的信息
     * @return 返回添加语句的成果
     */
    @PostMapping("/yescheck")
    public Map<String, Object> addCheck(@RequestBody BossConnect bossConnect
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", bossConnectMapper.addCheck(bossConnect));
        return modelMap;
    }

}
