package com.system.service;

import com.system.model.User;
import com.baomidou.mybatisplus.service.IService;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yx
 * @since 2017-08-16
 */
public interface IUserService extends IService<User>{

 //
    /**
     * 查询所有数据
     * @param map
     * @return
     */
    List<User> queryByMap(Map<String,Object> map);

}
