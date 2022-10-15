package com.codeisthenight.backend.service.impl.problem;

import com.codeisthenight.backend.mapper.ProblemMapper;
import com.codeisthenight.backend.pojo.Problem;
import com.codeisthenight.backend.pojo.User;
import com.codeisthenight.backend.service.impl.utils.UserDetailsImpl;
import com.codeisthenight.backend.service.problem.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateServiceImpl implements UpdateService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public Map<String, String> update(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int id = Integer.parseInt(data.get("id"));

        String problem_id = data.get("problem_id");
        String title = data.get("title");

        String time_limit_string = data.get("time_limit");
        String memory_limit_string = data.get("memory_limit");
        int time_limit = Integer.parseInt(data.get("time_limit"));
        int memory_limit = Integer.parseInt(data.get("memory_limit"));
        String description = data.get("description");
        String input = data.get("input");
        String output = data.get("output");
        String examples = data.get("example");
        String difficulty_string = data.get("difficulty");
        int difficulty = Integer.parseInt(data.get("difficulty"));
        String hint = data.get("hint");
        String io_score_string = data.get("io_score");
        int io_score = Integer.parseInt(data.get("io_score"));

        Map<String, String> map = new HashMap<>();
        if (title == null || title.length() == 0) {
            map.put("error_message", "标题不能为空");
            return map;
        }

        if (title.length() > 100) {
            map.put("error_message", "标题长度不能大于100");
            return map;
        }

        if (time_limit_string == null || time_limit_string.length() == 0) {
            map.put("error_message", "time_limit不能为空");
            return map;
        }

        if (memory_limit_string == null || memory_limit_string.length() == 0) {
            map.put("error_message", "memory_limit不能为空");
            return map;
        }

        if (description == null || description.length() == 0) {
            description = "null";
        }

        if (description.length() > 10000) {
            map.put("error_message", "题目的长度不能大于10000");
            return map;
        }

        // 输入描述
        if (input == null || input.length() == 0) {
            map.put("error_message", "输入描述不能为空");
            return map;
        }
        if (input.length() > 1000) {
            map.put("error_message", "输入描述的长度不能大于1000");
            return map;
        }

        // 输出描述
        if (output == null || output.length() == 0) {
            map.put("error_message", "输出描述不能为空");
            return map;
        }
        if (output.length() > 1000) {
            map.put("error_message", "输出描述的长度不能大于1000");
            return map;
        }

        // 例子
        if (examples == null || examples.length() == 0) {
            map.put("error_message", "例子不能为空");
            return map;
        }
        if (examples.length() > 1000) {
            map.put("error_message", "例子的长度不能大于1000");
            return map;
        }

        //hint
        if (hint == null || hint.length() == 0) {
            hint = "null";
        }

        if (hint.length() > 1000) {
            map.put("error_message", "提示的长度不能大于1000");
            return map;
        }

        if (difficulty_string == null || difficulty_string.length() == 0) {
            map.put("error_message", "difficulty不能为空");
            return map;
        }
        if (io_score_string == null || io_score_string.length() == 0) {
            map.put("error_message", "io_score不能为空");
            return map;
        }

        Problem problem = problemMapper.selectById(id);
        if (problem == null) {
            map.put("error_message", "题目不存在或已删除");
            return map;
        }
        if (!problem.getAuthor().equals(user.getId())) {
            map.put("error_message", "没有权限修改当前题目");
            return map;
        }
        Date now = new Date();
        Problem new_problem = new Problem(
                problem.getId(),
                problem_id,
                title,
                problem.getAuthor(),
                time_limit,
                memory_limit,
                null,
                description,
                input,
                output,
                examples,
                difficulty,
                hint,
                io_score,
                problem.getCreatetime(),
                now
        );
        problemMapper.updateById(new_problem);
        map.put("error_message", "success");
        return map;
    }


}
