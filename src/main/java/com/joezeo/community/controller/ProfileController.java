package com.joezeo.community.controller;

import com.joezeo.community.dto.PaginationDTO;
import com.joezeo.community.exception.CustomizeErrorCode;
import com.joezeo.community.exception.CustomizeException;
import com.joezeo.community.pojo.User;
import com.joezeo.community.service.NotificationService;
import com.joezeo.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5") Integer size,
                          Model model,
                          HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user == null){
            throw new CustomizeException(CustomizeErrorCode.USER_NOT_LOGIN);
        }

        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的问题");

            // 查询问题
            PaginationDTO paginationDTO = questionService.listPage(user.getId(), page, size);
            model.addAttribute("pagination", paginationDTO);
        } else if ("notify".equals(action)) {
            model.addAttribute("section", "notify");
            model.addAttribute("sectionName", "最新回复");

            // 查询通知
            PaginationDTO paginationDTO = notificationService.listPage(user.getId(), page, size);
            model.addAttribute("pagination", paginationDTO);
        }

        return "profile";
    }
}
