package com.codeisthenight.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeisthenight.backend.pojo.Problem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProblemMapper extends BaseMapper<Problem> {
}
