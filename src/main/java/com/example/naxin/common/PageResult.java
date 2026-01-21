package com.example.naxin.common;

import lombok.Data;
import java.util.List;

@Data
public class PageResult<T> {
    private Integer pageNum;     // 当前页码
    private Integer pageSize;    // 每页数量
    private Long total;         // 总记录数
    private Integer totalPages; // 总页数
    private List<T> list;       // 数据列表

    public static <T> PageResult<T> success(List<T> list, Integer pageNum, Integer pageSize, Long total) {
        PageResult<T> result = new PageResult<>();
        result.setPageNum(pageNum);
        result.setPageSize(pageSize);
        result.setTotal(total);
        result.setTotalPages((int) Math.ceil((double) total / pageSize));
        result.setList(list);
        return result;
    }
}
