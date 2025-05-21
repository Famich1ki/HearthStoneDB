package com.zzb.hearthstoneDB.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzb.hearthstoneDB.pojo.Card;

import java.util.List;
import java.util.function.Supplier;

public class PageUtils {

    public static <T> PageResponse<T> getPage(int pageNum, int pageSize, Supplier<List<T>> query) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> result = query.get();
        return new PageResponse<>(new PageInfo<>(result));
    }


}
