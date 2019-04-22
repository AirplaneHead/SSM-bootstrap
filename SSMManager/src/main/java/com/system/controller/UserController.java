package com.system.controller;


import com.system.model.User;
import com.system.service.IUserService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lf
 * @since 2019-04-18
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    public void addPerson(HttpServletResponse resp, HttpServletRequest request) throws IOException {
        String str=request.getParameter("str");
        JSONObject object = JSONObject.fromObject(str);
        User user = new User();
        user.setName(object.getString("name"));
        user.setAge(Integer.valueOf(object.getString("age")));
        userService.insert(user);

        PrintWriter out=resp.getWriter();
        out.write("1");
        out.flush();
        out.close();
    }

    @RequestMapping("getsecondall")
    public void getsecondall(HttpServletResponse resp, HttpServletRequest request) throws IOException {
        //得到客户端传递的页码和每页记录数，并转换成int类型
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        //查询参数
        String name = request.getParameter("name");
        String age=request.getParameter("age");

        int offset=(pageNumber-1)*pageSize;  //当前起始页
        //定义map集合：
        Map mp=new HashMap();
        //分页：
        mp.put("offset",offset);
        mp.put("pageSize",pageSize);

        if(StringUtils.isNotBlank(age)){
            int intAge=Integer.parseInt(age);
            mp.put("age",intAge);
        }
        if(StringUtils.isNotBlank(name)){
            mp.put("name",name);
        }
        //分页：
        List<User> usrList = userService.queryByMap(mp);

        // System.out.println(mp.get("page")+","+mp.get("pname"));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",usrList.size());
        map.put("rows",usrList);
        PrintWriter out=resp.getWriter();
        String s= JSONObject.fromObject(map).toString();
        // System.out.println(s);
        out.write(s);
        out.flush();
        out.close();

    }

    //删除：
    @RequestMapping("delPerson")
    public void delPerson(HttpServletResponse resp, HttpServletRequest request) throws IOException {

        //得到传过来的字符串：
        String str=request.getParameter("str");
        JSONArray json = JSONArray.fromObject(str);
        //将字符串转化为数组：
        for (Object object : json) {
            int id=Integer.parseInt(object.toString());
            User user = new User();
            user.setId(id);
            userService.deleteById(user);
        }
        //返回：
        PrintWriter out=resp.getWriter();
        out.write("1");
        out.flush();
        out.close();
    }

    //修改：
    @RequestMapping("updatePerson")
    public void updatePerson(HttpServletResponse resp, HttpServletRequest request) throws IOException {

        //得到传过来的字符串：
        String str=request.getParameter("str");
        JSONObject object = JSONObject.fromObject(str);

        //添加：
        User user = new User();
        user.setId(Integer.valueOf(object.getString("id")));
        user.setName(object.getString("name"));
        user.setAge(Integer.valueOf(object.getString("age")));
        userService.updateById(user);
        //返回：
        PrintWriter out=resp.getWriter();
        out.write("1");
        out.flush();
        out.close();

    }

}
