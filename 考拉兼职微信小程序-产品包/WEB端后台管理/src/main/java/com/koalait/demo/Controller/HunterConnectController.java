package com.koalait.demo.Controller;

import com.koalait.demo.Entity.BossConnect;
import com.koalait.demo.Entity.HunterConnect;
import com.koalait.demo.Mapper.HunterConnectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hunterconnect")
public class HunterConnectController {
    @Autowired
    private HunterConnectMapper hunterConnectMapper;

    /**
     *
     * @param hunterConnect 取得数据库二表连接所需要的信息
     * @return  返回增加预约语句执行结果
     */
    //增加预约关联
    @PostMapping("/orderhunter")
    public Map<String, Object> addHunterInfo(@RequestBody HunterConnect hunterConnect
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", hunterConnectMapper.addHunterConnect(hunterConnect));
        return modelMap;
    }

    /**
     *
     * @param hunterConnect 取得修改预约表中需要的信息
     * @return  返回语句执行结果
     */
    //取消预约
    @GetMapping("/delorder")
    public Map<String, Object> delHunterInfo(HunterConnect hunterConnect){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",hunterConnectMapper.delHunterConnect(hunterConnect));
        return modelMap;
    }

    /**
     *
     * @param user_id 用户ID
     * @return 返回用户预约信息（hunter）
     */
    @GetMapping("/getorder")
    public Map<String, Object> getResume(Integer user_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<HunterConnect> hunterConnect = hunterConnectMapper.findHunterByID(user_id);
        modelMap.put("hunterlist", hunterConnect);
        return modelMap;
    }

    /**
     *
     * @param hunterConnect 取得hunter执行审核需要的信息
     * @return  返回审核语句执行结果
     */
    @PostMapping("/yescheck")
    public Map<String, Object> addCheck(@RequestBody HunterConnect hunterConnect
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", hunterConnectMapper.addCheck(hunterConnect));
        return modelMap;
    }

}
