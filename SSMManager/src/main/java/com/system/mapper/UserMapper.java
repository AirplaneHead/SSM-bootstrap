package com.system.mapper;

import com.system.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yx
 * @since 2017-08-16
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> queryByPage(Map<String,Object> map);
}