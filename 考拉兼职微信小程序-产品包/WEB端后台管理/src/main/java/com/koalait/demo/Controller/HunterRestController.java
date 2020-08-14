package com.koalait.demo.Controller;

import com.koalait.demo.Entity.HunterInfo;
import com.koalait.demo.Mapper.HunterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("koalahunter")
public class HunterRestController {
    @Autowired
    private HunterMapper hunterMapper;

    /**
     *
     * @return返回查询hunter表的所有信息
     */
    //查询
    @GetMapping("/findhunter")
    public Map<String, Object> getHunterInfo(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<HunterInfo> hunterInfo = hunterMapper.findHunterInfo();
        modelMap.put("areaHunterList", hunterInfo);
        return modelMap;
    }

    /**
     *
     * @param hunterInfo 获得增加hunter的有关信息
     * @return  返回增加语句执行结果
     */
    //增加
    @PostMapping("/addhunter")
    public Map<String, Object> addHunterInfo(@RequestBody HunterInfo hunterInfo
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", hunterMapper.addHunterInfo(hunterInfo));
        return modelMap;
    }

    /**
     *
     * @param hunter_id 获得查询需修改信息的条件
     * @return 返回需修改信息
     */
    //修改
    @GetMapping("/gethunter")
    public Map<String, Object> getHunterInfoById(Integer hunter_id) {
        Map<String,Object> modelMap = new HashMap<String, Object>();
        HunterInfo hunterInfo = hunterMapper.findHunterInfoByID(hunter_id);
        modelMap.put("areaHunterList", hunterInfo);
        return modelMap;
    }

    /**
     *
     * @param hunterInfo 传来修改信息
     * @return  返回修改语句执行结果
     */
    @PostMapping("/updatehunter")
    public Map<String, Object> updateHunterInfo(@RequestBody HunterInfo hunterInfo
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", hunterMapper.updateHunterInfoByID(hunterInfo));
        return modelMap;
    }

    /**
     *
     * @param hunter_id 取得删除语句执行条件
     * @return 返回删除语句执行结果
     */
    //删除
    @GetMapping("/delhunter")
    public Map<String, Object> delBossInfo(Integer hunter_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        //删除信息
        modelMap.put("success",hunterMapper.delHunterInfoByID(hunter_id));
        return modelMap;
    }

    /**
     *
     * @param hunterInfo 前端取得预约需要的有关信息
     * @return 返回预约语句执行结果
     */
    //预约
    @PostMapping("/order")
    public Map<String, Object> orderHunterInfo(@RequestBody HunterInfo hunterInfo
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", hunterMapper.orderHunterInfoByID(hunterInfo));
        return modelMap;
    }

    /**
     *
     * @param user_id 查找用户标识ID
     * @return 返回我发布的信息列表
     */
    @GetMapping("/publish") //我发布的
    public Map<String, Object> getHunter(Integer user_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<HunterInfo> hunterInfo = hunterMapper.getHunterByUser(user_id);
        modelMap.put("areaHunterList", hunterInfo);
        return modelMap;
    }

    /**
     *
     * @param user_id 用户标识ID
     * @return  返回我预约的信息列表
     */
    @GetMapping("/orderboss") //我预约的
    public Map<String, Object> findHunterByOrder(Integer user_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<HunterInfo> hunterInfo = hunterMapper.findHunterInfoByOrder(user_id);
        modelMap.put("areaHunterList", hunterInfo);
        return modelMap;
    }

    /**
     *
     * @param user_id 用户标识ID
     * @return 返回预约我的信息列表
     */
    @GetMapping("/orderedboss") //预约我的
    public Map<String, Object> getHunterByOrder(Integer user_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<HunterInfo> hunterInfo = hunterMapper.getHunterInfoByOrder(user_id);
        modelMap.put("areaHunterList", hunterInfo);
        return modelMap;
    }

}
