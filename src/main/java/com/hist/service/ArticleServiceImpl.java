package com.hist.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hist.dto.ArticleDTO;
import com.hist.mapper.ArticleMapper;
import com.hist.pojo.Article;
import com.hist.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gky
 * @date 2023/05/06
 * @apiNote
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 根据用户名和密码查询用户对象
     */
    @Override
    public User login(String username, String password, String number) {
        return articleMapper.login(username,password);
    }
    /**
     * 查询所有文章信息
     */
    @Override
    public List<Article> queryAllArticle() {
        return articleMapper.queryAllArticle();
    }

    /**
     * 获取文章分页信息
     * limit相当于pageSize,page相当于pageNum
     */
    @Override
    public PageInfo<Article> getArticlePage(Integer page,Integer limit) {
        //开启分页功能
        PageHelper.startPage(page,limit);
        //查询所有文章信息
        List<Article> list=articleMapper.queryAllArticle();
        //获取分页相关数据
        PageInfo<Article> pageInfo=new PageInfo<>(list,3);
        return pageInfo;
    }

    /**
     * 添加
     */
    @Override
    public void add(String id, String title, String content, Date createDate) {
        articleMapper.add(id,title,content,createDate);
    }

    /**
     *修改
     */
    @Override
    public void update(String id, String title, String content) {
        articleMapper.update(id,title,content);
    }

    /**
     * 根据id查询
     */
    @Override
    public Article queryById(Long id) {
        Article article = articleMapper.queryById(id);
        return article;
    }

    /**
     * 根据id删除
     */
    @Override
    public void deleteById(Long id) {
        articleMapper.deleteById(id);
    }

    /**
     * 模糊搜索
     */
    @Override
    public PageInfo<ArticleDTO> fuzzySearch(Integer page, Integer limit, Long id, String title) {
        //开启分页功能
        PageHelper.startPage(page,limit);

        //查询所有文章信息
        List<Article> list=articleMapper.fuzzySearch(id,title);
        //将第一次查询到的pageInfo信息保存下来
        PageInfo<Article> pageInfo0=new PageInfo<>(list,3);
        long total = pageInfo0.getTotal();
        int pageNum = pageInfo0.getPageNum();
        List<ArticleDTO> list1 = new ArrayList<>();
        for (Article article : list) {
            ArticleDTO dto = new ArticleDTO();
            dto.change(article);
            list1.add(dto);
        }
        //获取分页相关数据
        PageInfo<ArticleDTO> pageInfo= new PageInfo<>(list1,3);
        pageInfo.setTotal(total);
        pageInfo.setPageNum(pageNum);
        return pageInfo;
    }


}
