package com.codeisthenight.backend.controller.problem;

import com.codeisthenight.backend.service.problem.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateController {
    @Autowired
    private UpdateService updateService;

    @PostMapping("/problem/update/")
    public Map<String, String> update(@RequestParam Map<String, String> data) {
        return updateService.update(data);
    }
}
