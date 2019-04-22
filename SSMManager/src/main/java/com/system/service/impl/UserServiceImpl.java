package com.system.service.impl;

import com.system.model.User;
import com.system.mapper.UserMapper;
import com.system.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yx
 * @since 2017-08-16
 */
@Service("ServiceImpl")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {



    @Override
    public List<User> queryByMap(Map<String, Object> map) {
        List<User> users = baseMapper.queryByPage(map);
        return users;
    }
}
