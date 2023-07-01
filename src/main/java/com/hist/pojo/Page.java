package com.hist.pojo;

import com.hist.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gky
 * @date 2023/05/07
 * @apiNote
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Page {
    private Integer total;
    private Integer page;
    private List<ArticleDTO> list;

}
