package com.codeisthenight.backend.controller.problem;

import com.codeisthenight.backend.pojo.Problem;
import com.codeisthenight.backend.service.problem.GetListAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetListAllController {
    @Autowired
    private GetListAllService getListAllService;

    @GetMapping("/problem/getlistall/")
    public List<Problem> getListAll() {
        return getListAllService.getListAll();
    }
}
