package com.hist.service;

import com.github.pagehelper.PageInfo;
import com.hist.dto.ArticleDTO;
import com.hist.pojo.Article;
import com.hist.pojo.User;

import java.util.Date;
import java.util.List;

/**
 * @author gky
 * @date 2023/05/06
 * @apiNote
 */
public interface ArticleService {
    User login(String username, String password, String number);

    List<Article> queryAllArticle();

    PageInfo<Article> getArticlePage(Integer page, Integer limit);

    void add(String id, String title, String content, Date createDate);

    void update(String id,String title,String content);

    Article queryById(Long id);

    void deleteById(Long id);

    PageInfo<ArticleDTO> fuzzySearch(Integer page, Integer limit, Long id, String title);

}











