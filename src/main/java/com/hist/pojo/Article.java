package com.hist.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gky
 * @date 2023/05/05
 * @apiNote
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article implements Serializable {
    /**
     * @JsonSerialize(using = ToStringSerializer.class)
     * 应该也可解决js与Number精度位数不一致问题
     */
    private Long id;
    private String title;
    private String info;
    private String content;
    private Integer totalWords;
    private Date createDate;
    private Integer view;
    private String author;

}
