package com.hist.controller;

import com.github.pagehelper.PageInfo;
import com.hist.dto.ArticleDTO;
import com.hist.pojo.*;
import com.hist.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author gky
 * @date 2023/05/07
 * @apiNote
 */
@RestController
@RequestMapping("/mail")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 登录
     */
    @GetMapping("/user")
    public Result login(String username, String password, String number) {
        //获取用户信息
        User user = articleService.login(username, password,number);
        Integer code = user != null ? Code.OK : Code.ERROR;
        String msg = user != null ? "登录成功" : "登录失败";
        return new Result(code, user, msg);
    }

    /**
     * 分页列表
     */
    @PostMapping("/list")
    public Result getArticlePage(@RequestBody Map<String,String> body){
        Integer page = Integer.valueOf(body.get("page"));
        Integer limit = Integer.valueOf(body.get("limit"));
        Long id = Long.valueOf(body.get("id"));
        String title = "";
        PageInfo<ArticleDTO> pageInfo=articleService.fuzzySearch(page,limit,id,title);
        Page page1=new Page();
        page1.setTotal((int) pageInfo.getTotal());
        page1.setPage(pageInfo.getPageNum());
        page1.setList(pageInfo.getList());
        return new Result(Code.OK,page1,"success");
    }

    /**
     * 添加和修改
     */
    @PostMapping("/saveOrUpdate")
    public Result update(@RequestBody Map<String,String> body) throws ParseException {
        String id=body.get("articleId");
        String title = body.get("title");
        String content = body.get("content");
        //获取创建时间
        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(date);
        Date date1=formatter.parse(format);
        if(id==null){
            id= String.valueOf(System.currentTimeMillis());
            articleService.add(id,title,content,date1);
        }else {

            articleService.update(id, title, content);
        }
        return new Result(Code.OK,"","success");
    }

    /**
     * 根据id查询
     */
    @GetMapping("/{id}")
    public Result queryById(@PathVariable("id") String id){
        Article article = articleService.queryById(Long.valueOf(id));
        return new Result(Code.OK,article,"success");
    }

    /**
     * 根据id删除
     */
    @DeleteMapping("/delete")
    public Result deleteById(@RequestParam Long id){
        articleService.deleteById(id);
        return new Result(Code.OK,"","success");
    }
    /**
     * 搜索
     */
    @PostMapping("/search")
    public Result fuzzySearch(@RequestBody Map<String,String> body){
        Integer page = Integer.valueOf(body.get("page"));
        Integer limit = Integer.valueOf(body.get("limit"));
        Long id = Long.valueOf(body.get("id"));
        String title = body.get("search");
        PageInfo<ArticleDTO> pageInfo=articleService.fuzzySearch(page,limit,id,title);
        Page page1=new Page();
        page1.setTotal((int) pageInfo.getTotal());
        page1.setPage(pageInfo.getPageNum());
        page1.setList(pageInfo.getList());
        return new Result(Code.OK,page1,"success");
    }


}









