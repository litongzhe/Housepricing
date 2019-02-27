package com.raising.util;

import com.raising.modules.sys.entity.User;
import com.raising.utils.UserUtils;
import org.springframework.stereotype.Component;

/**
 * 自定义用户工具类
 * @author GaoYuan
 * @date 2018/6/19 上午10:46
 */
@Component
public class MyUserUtils{

    /**
     * 获取当前登录人
     * @author GaoYuan
     * @date 2018/6/19 上午10:49
     */
    public static User getCurrentUser(){
        return UserUtils.getCurrentUser();
    }
    /**
     * 获取当前登录人标识
     * @author GaoYuan
     * @date 2018/6/19 上午10:49
     */
    public static String getCurrentUserId(){
        User user = UserUtils.getCurrentUser();
        if (user == null) {
            // @TODO 内部测试时
            return "1";
        }
        return user.getId();
    }
}
