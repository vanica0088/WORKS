package com.koalait.demo.Controller;

import com.koalait.demo.Entity.BossInfo;
import com.koalait.demo.Entity.UserInfo;
import com.koalait.demo.Mapper.BossMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("koalaboss")
public class BossRestController {
    @Autowired
    private BossMapper bossMapper;

    /**
     *
     * @return 返回查询结果
     */
    //查询
    @GetMapping("/findboss")
    public Map<String, Object> getBossInfo(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<BossInfo> bossInfo = bossMapper.findBossInfo();
        modelMap.put("areaBossList", bossInfo);
        return modelMap;
    }

    /**
     *
     * @param boss_title 页面取得关键字查询条件
     * @return 返回关键字条件查询结果
     */
    //条件查询
    @GetMapping("/searchboss")
    public Map<String, Object> searchBossInfo(String boss_title){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<BossInfo> boss = bossMapper.searchBossInfo(boss_title);
        modelMap.put("areaBossList", boss);
        return modelMap;
    }

    /**
     *
     * @param bossInfo 取得增加boss表所需要的信息
     * @return 返回语句执行结果
     */
    //增加
    @PostMapping("/addboss")
    public Map<String, Object> addBossInfo(@RequestBody BossInfo bossInfo
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", bossMapper.addBossInfo(bossInfo));
        return modelMap;
    }

    /**
     *
     * @param boss_id 取得需要修改的boss信息的条件
     * @return  返回该信息
     */
    //修改
    @GetMapping("/getboss")
    public Map<String, Object> getBossInfoById(Integer boss_id) {
        Map<String,Object> modelMap = new HashMap<String, Object>();
        BossInfo bossInfo = bossMapper.findBossInfoByID(boss_id);
        modelMap.put("areaBossList", bossInfo);
        return modelMap;
    }

    /**
     *
     * @param bossInfo 取得修改后的信息
     * @return  返回修改是否成功
     */
    @PostMapping("/updateboss")
    public Map<String, Object> updateBossInfo(@RequestBody BossInfo bossInfo
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", bossMapper.updateBossInfoByID(bossInfo));
        return modelMap;
    }

    /**
     *
     * @param boss_id 取得删除信息需要的主键
     * @return  返回删除信息是否成功
     */
    //删除信息
    @GetMapping("/delboss")
    public Map<String, Object> delBossInfo(Integer boss_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",bossMapper.delBossInfoByID(boss_id));
        return modelMap;
    }

    /**
     *
     * @param bossInfo 取得预约信息的条件
     * @return  返回执行预约信息是否成功
     */
    //预约
    @PostMapping("/order")
    public Map<String, Object> orderHunterInfo(@RequestBody BossInfo bossInfo
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", bossMapper.orderBossInfoByID(bossInfo));
        return modelMap;
    }

    /**
     *
     * @param user_id 取得用户id查询他预约的信息
     * @return  返回预约信息列表
     */
    @GetMapping("/publish") //我发布的
    public Map<String, Object> getBoss(Integer user_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<BossInfo> bossInfo = bossMapper.getBossByUser(user_id);
        modelMap.put("areaBossList", bossInfo);
        return modelMap;
    }

    /**
     *
     * @param user_id 取得该用户标识ID
     * @return 返回该用户预约的信息
     */
    @GetMapping("/orderhunter") //我预约的
    public Map<String, Object> findBossByOrder(Integer user_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<BossInfo> bossInfo = bossMapper.findBossInfoByOrder(user_id);
        modelMap.put("areaBossList", bossInfo);
        return modelMap;
    }

    /**
     *
     * @param user_id 取得该用户标识ID
     * @return 返回该用户被预约信息
     */
    @GetMapping("/orderedhunter") //预约我的
    public Map<String, Object> getBossByOrder(Integer user_id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<BossInfo> bossInfo = bossMapper.getBossInfoByOrder(user_id);
        modelMap.put("areaBossList", bossInfo);
        return modelMap;
    }
}
