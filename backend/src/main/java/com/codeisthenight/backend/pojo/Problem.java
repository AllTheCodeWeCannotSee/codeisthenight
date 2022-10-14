package com.codeisthenight.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Problem {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String problemId;
    private String title;
    private Integer author;
    private Integer timeLimit;
    private Integer memoryLimit;
    private Integer stackLimit;
    private String description;
    private String input;
    private String output;
    private String examples;
    private Integer difficulty;
    private String hint;
    private Integer ioScore;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifytime;
}
