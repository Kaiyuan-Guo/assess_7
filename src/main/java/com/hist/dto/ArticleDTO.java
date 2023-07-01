package com.hist.dto;

import com.hist.pojo.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gky
 * @date 2023/05/09
 * @apiNote
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleDTO implements Serializable {
    private String id;
    private String title;
    private String info;
    private String content;
    private Integer totalWords;
    private Date createDate;
    private Integer view;
    private String author;

    public void change(Article article){
        this.id= String.valueOf(article.getId());
        this.title=article.getTitle();
        this.info=article.getInfo();
        this.content=article.getContent();
        this.totalWords= article.getTotalWords();
        this.createDate=article.getCreateDate();
        this.view=article.getView();
        this.author=article.getAuthor();
    }
}
