package com.hist.mapper;

import com.hist.pojo.Article;
import com.hist.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author gky
 * @date 2023/05/06
 * @apiNote
 */
public interface ArticleMapper {
    /**
     * 根据用户名和密码查询用户对象
     */
    User login(@Param("username") String username, @Param("password") String password);
    /**
     * 查询所有文章信息
     */
    List<Article> queryAllArticle();
    /**
     * 添加
     */
    void add(@Param("id") String id, @Param("title") String title, @Param("content") String content, @Param("createDate")Date createDate);
    /**
     * 修改
     */
    void update(@Param("id") String id,@Param("title") String title,@Param("content") String content);
    /**
     * 根据id查询
     */
    Article queryById(@Param("id") Long id);
    /**
     * 通过ids删除文章
     */
    void deleteById(@Param("id") Long id);
    /**
     * 搜索（模糊查询）
     */
    List<Article> fuzzySearch(@Param("id") Long id,@Param("title") String title);

}
