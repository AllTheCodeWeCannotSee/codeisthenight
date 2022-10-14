package com.codeisthenight.backend.controller.problem;

import com.codeisthenight.backend.pojo.Problem;
import com.codeisthenight.backend.service.problem.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetListController {
    @Autowired
    private GetListService getListService;

    @GetMapping("/problem/getlist/")
    public List<Problem> getlist() {
        return getListService.getlist();
    }
}
