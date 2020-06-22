package com.koalait.demo.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.koalait.demo.Entity.HunterInfo;
import com.koalait.demo.Entity.ManagerInfo;
import com.koalait.demo.Mapper.HunterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("koala")
public class HunterController {
    @Autowired
    private HunterMapper hunterMapper;

    /**求职者的hunter页面，主要用于显示求职信息，进行查询和详情查看
     * @param pageIndex   分页页数  id
     * @param pageSize    每页有多少条数据
     * @param hunter_id   求职者的id
     * @param model       调用model传值
     * @return            返回求职hunter页面，显示hunter的信息
     */
    @RequestMapping("/jh")
    public String  gethu( @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                          @RequestParam(value = "pageSize",defaultValue = "10")Integer  pageSize,
                          @RequestParam(value="hunter_id",defaultValue ="0")Integer hunter_id,
                          Model model) {
        PageHelper.startPage(pageIndex,pageSize);
        PageInfo<HunterInfo> pages=null;
        List<HunterInfo> lists=null;
        if(hunter_id==0){
            lists =hunterMapper.getHunter(pageIndex,pageSize);//创建列表
            pages=new PageInfo<>(lists);
        }
        else {
            lists =hunterMapper.getHunterByID(pageIndex,pageSize,hunter_id);//创建列表
            pages=new PageInfo<>(lists);}
        model.addAttribute("hunter", pages);
        model.addAttribute("hunter_id",hunter_id);
        return "hunter";
    }

    /**根据id删除求职者信息功能，并返回当前页面
     * @param hunter_id  求职者id
     * @return           返回hunter页面
     */
    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") Integer hunter_id) {
        Integer i = hunterMapper.delhunterByID(hunter_id);
        return "redirect:/koala/jh";
    }

    /**命名hunterdetail方法，通过PathVariable获取相应id的求职者详细信息。
     * @param hunter_id  求职者id
     * @param model      调用model方法
     * @return           返回某个求职者详细信息页面
     */
    @GetMapping("/hdet/{id}")
    public String hunterdetail(@PathVariable("id")Integer hunter_id,Model model){
        HunterInfo hunterInfo =hunterMapper.gethuByID(hunter_id);
        model.addAttribute("hunter",hunterInfo);
        return "hunterdetail.html";
    }

    /**
     * @return   返回hunter求职者页面
     */
    @PostMapping("/hdet")
    public String hunterdetail(){
        return "redirect:/koala/jh";
    }

       //审核hunter

    /**命令getCB方法，发出请求，用于checkhunter页面，调用model传值到前端，显示待审核的求职者信息
     * @param model  调用model方法
     * @return       返回checkhunter求职者信息审核页面
     */
    @GetMapping("/hunter")
    public String getCB(Model model){
        List<HunterInfo> lists=hunterMapper.getAllHunter();
        model.addAttribute("hunter",lists);
        return "checkhunter";
    }

    /**用于checkhunter页面功能，用于求职信息的审核，同意。
     * @param hunter_id  求职者id
     * @param model      调用model方法
     * @return           返回checkhuunter页面
     */
    @RequestMapping("/newhunter/{HunterInfo.hunter_id}")
    public String updateHunterInfo(@PathVariable("HunterInfo.hunter_id") Integer hunter_id,Model model){
        HunterInfo newhunter=hunterMapper.getHunterByid(hunter_id);
        model.addAttribute("newhunter",newhunter);
        hunterMapper.updateHunterByID(newhunter);
        return "redirect:/koala/hunter";
    }

    /**用于checkhunter页面功能，用于求职信息的审核，拒绝。
     * @param hunter_id  求职者id
     * @param model      调用model方法
     * @return           返回checkhuunter页面
     */
    @RequestMapping("/oldhunter/{HunterInfo.hunter_id}")
    public String updateHunter(@PathVariable("HunterInfo.hunter_id") Integer hunter_id,Model model){
        HunterInfo oldhunter=hunterMapper.getHunterByid(hunter_id);
        model.addAttribute("oldhunter",oldhunter);
        hunterMapper.updateHunter(oldhunter);
        return "redirect:/koala/hunter";
    }
}