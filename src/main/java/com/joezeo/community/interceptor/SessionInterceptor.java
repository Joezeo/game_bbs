package com.joezeo.community.interceptor;

import com.joezeo.community.pojo.User;
import com.joezeo.community.service.NotificationService;
import com.joezeo.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * session interceptor
 * 登录拦截
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) { // 如果用户未登录 检查cookie中的token信息
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("token".equals(cookie.getName())) {
                        if (cookie.getValue() != null && !"".equals(cookie.getValue())) {
                            user = userService.queryUserByToken(cookie.getValue());
                        }
                    }
                }
            }
            if (user != null) {
                request.getSession().setAttribute("user", user);
            }
        }
        if(user != null){
            // 加载该用户未阅读消息的数量
            int unreadCount = notificationService.countUnread(user.getId());
            request.getSession().setAttribute("unreadCount", unreadCount);
        }
        return true;
    }
}
