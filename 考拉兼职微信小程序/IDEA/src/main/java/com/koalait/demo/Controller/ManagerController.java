package com.koalait.demo.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.koalait.demo.Entity.BossInfo;
import com.koalait.demo.Entity.LogInfo;
import com.koalait.demo.Entity.ManagerInfo;
import com.koalait.demo.Entity.UserInfo;
import com.koalait.demo.Mapper.LogMapper;
import com.koalait.demo.Mapper.ManagerMapper;
import com.koalait.demo.Mapper.UserMapper;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("koalait")
public class ManagerController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private LogMapper logMapper;

    /**
     *在地址栏中输入地址
     * @return 进入login页面
     */
    @GetMapping("/login")
    public String pageLogin() {
        return "login";
    }

    /**
     * 发出请求，通过addAttribute将数据从后台传到前端，显示在main页
     * @param model 调用model方法
     * @return      返回main主页面
     */
    @GetMapping("/ma")
    public String Main(Model model){
 //        int hu=managerMapper.hu();
//        model.addAttribute("hu",hu);
//        int bos=managerMapper.bos();
//        model.addAttribute("bos",bos);
        int male = managerMapper.male();     //图表三  性别人数在最上方
        model.addAttribute("male", male);
        int female = managerMapper.female();
        model.addAttribute("female", female);
        return "main";
    }

    /**
     * @param user_id  用户id
     * @param password 用户密码
     * @param session  在session中保存登陆信息
     * @param logInfo  日志属性
     * @param request  请求
     * @param response 响应
     * @return
     */
    @PostMapping("/login")
    public String UserLogin(@RequestParam("user_id") Integer user_id,
                            @RequestParam("password") String password,
                            HttpSession session, LogInfo logInfo,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "127.0.0.1";
        }
        System.out.println("IP地址：" + ip);
        String agentStr = request.getHeader("user-agent");
        System.out.println(agentStr);
        UserAgent agent = UserAgent.parseUserAgentString(agentStr);
        //浏览器
        Browser browser = agent.getBrowser();
        System.out.println("名称：" + browser.getName());
        //操作系统
        System.out.println("========================");
        OperatingSystem os = agent.getOperatingSystem();
        System.out.println("名称：" + os.getName());
        Integer id = agent.getId();
        System.out.println("用户编号：" + id);
        logInfo.setIE(browser.getName().toString());
        logInfo.setIP_Address(ip.toString());
        logInfo.setOS(os.getName().toString());
        UserInfo managerInfo = managerMapper.userLogin(user_id, password);
        if (managerInfo != null) {
            session.setAttribute("ManagerInfo", managerInfo);
            logInfo.setUser_id(managerInfo.getUser_id());
            logInfo.setUserName(managerInfo.getUser_name());
            int i = logMapper.addLog(logInfo);
            return "redirect:/koalait/main";
        }
        return "redirect:/koalait/login";
    }

    /**用于log页面功能，主要用于显示登陆日志的记录信息
     * @param pageIndex  分页页数  id
     * @param pageSize   每页有多少条数据
     * @param user_name  用户名
     * @param CreateDate 创建日期
     * @param model      调用model传值
     * @return           返回log页面，显示登陆日志
     */
    @RequestMapping("/log")
    public String getUserByName(@RequestParam(value = "PageIndex", defaultValue = "1") Integer pageIndex,
                                @RequestParam(value = "PageSize", defaultValue = "5") Integer pageSize,
                                @RequestParam(value = "user_name", defaultValue = "") String user_name,
                                @RequestParam(value = "CreateDate", defaultValue = "") Date CreateDate, Model model) {
        PageHelper.startPage(pageIndex, pageSize);
        List<LogInfo> lists = null;
        PageInfo<LogInfo> listInfo = null;
        if (user_name.isEmpty() && CreateDate == null) {
            lists = logMapper.getAllLog(pageIndex, pageSize);
        } else if (!user_name.isEmpty() && CreateDate == null) {
            lists = logMapper.getLogByIDName(pageIndex, pageSize, user_name);
        } else if(user_name.isEmpty() && CreateDate!=null){
            lists = logMapper.getLogByID(pageIndex, pageSize, CreateDate);
        } else {
            lists = logMapper.getLogByDateName(pageIndex, pageSize, user_name, CreateDate);
        }
        PageInfo<LogInfo> pages = new PageInfo<>(lists);
        List<LogInfo> LogInfoList = logMapper.getAllLog(pageIndex, pageSize);
        model.addAttribute("user_name", user_name);
        model.addAttribute("CreateDate", CreateDate);
        model.addAttribute("LogInfo", LogInfoList);
        model.addAttribute("log", pages);
        return "log";
    }

    /**管理员进行登陆操作，输入id和密码。
     * @param user_id   id
     * @param password 用户密码
     * @param session  在session中保存用户信息
     * @return      登陆成功进入main主页面，失败返回login页面
     */
    @PostMapping("/logi")
    public String UserLogin(@RequestParam("user_id") Integer user_id,
                            @RequestParam("password") String password,
                            HttpSession session) {
        session.setAttribute("test",123456);
        UserInfo userInfo = userMapper.userLogin(user_id, password);
        if (userInfo!=null) {
            session.setAttribute("user", userInfo);
            return "main";
        } else {
            return "redirect:/koalait/logi";
        }
    }

    /**点击链接
     * @return 返回管理员us页面
     */
    @GetMapping("/us")
    public String aboutus(){
        return"us";
    }

    /**命名LtPage方法发出请求，利用addAttribute将数据从后台传入前端，各个图表显示在页面
     * @param model  调用model传值
     * @return       返回main主页面
     */
    @GetMapping("/main")
    public String ltPage(Model model) {

        List<Integer> lists = managerMapper.getBossTimeByTitle(); //图表一  工期
        model.addAttribute("boss", lists);

        List<Integer>Lists= managerMapper.getBossWageByTitle();  //图表二 日薪  折线图
        model.addAttribute("boss",Lists);

        int male = managerMapper.male();     //图表三  性别图
        model.addAttribute("male", male);
        int female = managerMapper.female();
        model.addAttribute("female", female);

        int firsttime = managerMapper.firsttime();     //图表五  入职年限
        model.addAttribute("firsttime", firsttime);
        int secondtime = managerMapper.secondtime();
        model.addAttribute("secondtime", secondtime);
        int thirdtime = managerMapper.thirdtime();
        model.addAttribute("thirdtime", thirdtime);
        int forthtime = managerMapper.forthtime();
        model.addAttribute("forthtime", forthtime);
        int fifthtime = managerMapper.fifthtime();
        model.addAttribute("fifthtime", fifthtime);


        int miniwage= managerMapper.miniwage();      //图表  饼图 日薪
        model.addAttribute("miniwage",miniwage);
        int mediumwage= managerMapper.mediumwage();
        model.addAttribute("mediumwage",mediumwage);
        int maxwage= managerMapper.maxwage();
        model.addAttribute("maxwage",maxwage);
        int topwage= managerMapper.topwage();
        model.addAttribute("topwage",topwage);
        return "main";
        }
    }