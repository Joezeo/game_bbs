package com.joezeo.community.controller;

import com.joezeo.community.dto.IndexDTO;
import com.joezeo.community.dto.JsonResult;
import com.joezeo.community.dto.PaginationDTO;
import com.joezeo.community.dto.TopicDTO;
import com.joezeo.community.pojo.Topic;
import com.joezeo.community.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/")
    public String htmIndex() {
        return "index";
    }

    @PostMapping("/list")
    @ResponseBody
    public JsonResult<IndexDTO> index(@RequestBody IndexDTO<TopicDTO> indexDTO){
        PaginationDTO<TopicDTO> paginationDTO = topicService.listPage(indexDTO.getPage(), indexDTO.getSize(), indexDTO.getCondition(), indexDTO.getTab());
        indexDTO.setPagination(paginationDTO);
        return JsonResult.okOf(indexDTO);
    }
}
