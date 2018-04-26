package com.yundian.result;

import java.util.List;

/**
 * page生成
 *
 * @author jnx
 * @create 2018/4/15
 */
public class PageProvider {


    public static  <E> Page<E> getPage(Paginator paginator, int totalCount,List<E> items,Class<? extends E> cls) {

        Page<E> page = new Page<E>(totalCount,paginator.getPage(),paginator.getPageSize(),items);
        return page;
    }
}
