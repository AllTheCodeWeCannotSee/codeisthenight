package com.codeisthenight.backend.service.impl.problem;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.codeisthenight.backend.mapper.ProblemMapper;
import com.codeisthenight.backend.pojo.Problem;
import com.codeisthenight.backend.pojo.User;
import com.codeisthenight.backend.service.impl.utils.UserDetailsImpl;
import com.codeisthenight.backend.service.problem.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListServiceImpl implements GetListService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public List<Problem> getlist() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();

        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("author", user.getId());

        return problemMapper.selectList(queryWrapper);
    }

}
