package com.raising.util;

import com.raising.framework.shiro.util.JWTUtil;
import com.raising.modules.PersonUser.entity.PersonUserEntity;
import com.raising.modules.PersonUser.service.PersonUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class PersonUserUtils {

    @Autowired
    private PersonUserService personUserServiceOrigin;
    private static PersonUserService personUserService;

    public PersonUserUtils() {
    }

    @PostConstruct
    public void init() {
        personUserService = this.personUserServiceOrigin;
    }

    public static String getUsername() {
        Subject subject = SecurityUtils.getSubject();
        String principal = (String)subject.getPrincipal();
        if (principal == null) {
            return "";
        } else {
            String tokenKey = JWTUtil.getUsername(principal);
            if (tokenKey != null && !"".equals(tokenKey)) {
                String[] tokenKeyAttr = tokenKey.split("-");
                String username = tokenKeyAttr[0];
                int attrLength = 3;
                if (tokenKeyAttr.length >= attrLength) {
                    String userId = tokenKey.split("-")[1];
                    String var7 = tokenKey.split("-")[2];
                }

                return username;
            } else {
                return "";
            }
        }
    }

    public static PersonUserEntity getCurrentUser() {
        try {
            String username = getUsername();
            if (StringUtils.isBlank(username)) {
                return null;
            } else {
                PersonUserEntity pue = personUserService.findByUserName(username);
                if (pue == null) {
                    return null;
                } else {
                    pue.setPassword((String)null);
                    pue.setSalt((String)null);
                    pue.setBalance((String)null);
                    return pue;
                }
            }
        } catch (Exception var2) {
            return null;
        }
    }

    public static String getCurrentUserId() {
        PersonUserEntity pue = getCurrentUser();
        return pue == null ? null : pue.getId();
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject() == null ? false : SecurityUtils.getSubject().isAuthenticated();
    }
}
