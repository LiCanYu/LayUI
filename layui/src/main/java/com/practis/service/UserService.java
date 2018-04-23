package com.practis.service;

import com.practis.model.User;

public interface UserService {
    int updateByPrimaryKey(User record);
    User selectByUsername(User user);
    int updateByPrimaryKeySelective(User record);
    User selectByPrimaryKey(Integer id);
    int insertSelective(User record);
    int insert(User record);
    int deleteByPrimaryKey(Integer id);
    User selectByUser(User user);
    int selectNum();
}
