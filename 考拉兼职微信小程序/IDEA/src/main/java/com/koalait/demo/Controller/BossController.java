package com.koalait.demo.Controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.koalait.demo.Entity.BossInfo;
import com.koalait.demo.Entity.ManagerInfo;
import com.koalait.demo.Mapper.BossMapper;
import com.koalait.demo.Mapper.HunterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("koalabao")
public class BossController<pages> {
    @Autowired
    private BossMapper bossMapper;

    /**招聘者的boss页面，主要用于显示招聘信息，进行查询和详情查看
     * @param pageIndex  分页页数  id
     * @param pageSize   每页有多少条数据
     * @param boss_id    招聘者的id
     * @param model      调用model传值
     * @return           返回招聘boss页面，显示boss的信息
     */
    @RequestMapping("/jo")
    public String getBo(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                        @RequestParam(value = "pageSize",defaultValue = "8")Integer  pageSize,
                        @RequestParam(value="boss_id",defaultValue ="0")Integer boss_id,
                        Model model) {
        PageHelper.startPage(pageIndex,pageSize);
        PageInfo<BossInfo> pages=null;
        List<BossInfo> lists=null;
        if(boss_id==0){
            lists =bossMapper.getBoss(pageIndex,pageSize);//创建列表
            pages=new PageInfo<>(lists);
        }
        else {
            lists =bossMapper.getbossByID(pageIndex,pageSize,boss_id);//创建列表
            pages=new PageInfo<>(lists);}
        model.addAttribute("boss", pages);
        model.addAttribute("boss_id",boss_id);
        return "boss";        //boss.html页面
    }

    /**根据id删除招聘者信息功能，并返回当前页面
     * @param boss_id   招聘者id
     * @return          返回hunter页面
     */
    @GetMapping("/del/{id}")  //删除个人信息
    public String del(@PathVariable("id") Integer boss_id){
        Integer i= bossMapper.delbossByID(boss_id);
        return "redirect:/koalabao/jo";
    }

    /**命名bossdetail方法，通过PathVariable获取相应id的详细信息。
     * @param boss_id   招聘者id
     * @param model     调用model方法
     * @return          返回某个招聘者详细信息页面
     */
    @GetMapping("/det/{id}")     //查看详情页
    public String bossdetail(@PathVariable("id")Integer boss_id,Model model){
        BossInfo bossInfo =bossMapper.getboByID(boss_id);
        model.addAttribute("boss",bossInfo);
        return "bossdetail.html";
    }

    /**
     * @return  返回boos招聘者页面
     */
    @PostMapping("/det")   //详情页
    public String bossdetail(){
        return "redirect:/koalabao/jo";
    }


//以下为审核boss招聘者信息功能的实现

    /**命令getCB方法，发出请求，用于checkboss页面，调用model传值到前端，显示待审核的招聘者信息
     * @param model  调用model方法
     * @return       返回checkbboss页面
     */
    @GetMapping("/boss")
    public String getCB(Model model){
        List<BossInfo> lists=bossMapper.getAllboss();
        model.addAttribute("boss",lists);
        return "checkboss";
    }

    /**用于checkboss页面功能，用于招聘信息的审核，同意。
     * @param boss_id   招聘id
     * @param model     调用model方法
     * @return          返回checkboss页面
     */
    @RequestMapping("/newboss/{BossInfo.boss_id}")
    public String updateBossInfo(@PathVariable("BossInfo.boss_id")Integer boss_id,Model model){
        BossInfo newboss=bossMapper.getBossByid(boss_id);
        model.addAttribute("newboss",newboss);
        bossMapper.updateBossByID(newboss);
        return "redirect:/koalabao/boss";
    }

    /**用于checkboss页面功能，用于招聘信息的审核，拒绝。
     * @param boss_id  招聘id
     * @param model    调用model方法
     * @return         返回checkboss页面
     */
    @RequestMapping("/oldboss/{BossInfo.boss_id}")
    public String updateBoss(@PathVariable("BossInfo.boss_id")Integer boss_id,Model model) {
        BossInfo oldboss=bossMapper.getBossByid(boss_id);
        model.addAttribute("oldboss",oldboss);
        bossMapper.updateBoss(oldboss);
        return "redirect:/koalabao/boss";
    }
}
