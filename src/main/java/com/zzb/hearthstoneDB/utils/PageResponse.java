package com.zzb.hearthstoneDB.utils;

import com.github.pagehelper.PageInfo;
import com.zzb.hearthstoneDB.pojo.Card;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
@Data
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> dataInfo;
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPages;
    private Long totalItems;

    public PageResponse(PageInfo<T> pageInfo) {
        dataInfo = pageInfo.getList();
        pageNum = pageInfo.getPageNum();
        pageSize = pageInfo.getPageSize();
        totalPages = pageInfo.getPages();
        totalItems = pageInfo.getTotal();
    }
}
