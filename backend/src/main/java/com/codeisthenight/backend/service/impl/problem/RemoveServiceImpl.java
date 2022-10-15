package com.codeisthenight.backend.service.impl.problem;

import com.codeisthenight.backend.mapper.ProblemMapper;
import com.codeisthenight.backend.pojo.Problem;
import com.codeisthenight.backend.pojo.User;
import com.codeisthenight.backend.service.impl.utils.UserDetailsImpl;
import com.codeisthenight.backend.service.problem.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveServiceImpl implements RemoveService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int id = Integer.parseInt(data.get("id"));
        Problem problem = problemMapper.selectById(id);
        Map<String, String> map = new HashMap<>();

        if (problem == null) {
            map.put("error_message", "题目不存在或已被删除");
            return map;
        }

        if (!problem.getAuthor().equals(user.getId())) {
            map.put("error_message", "没有权限删除该题目");
            return map;
        }

        problemMapper.deleteById(id);
        map.put("error_message", "success");
        return map;
    }
}
