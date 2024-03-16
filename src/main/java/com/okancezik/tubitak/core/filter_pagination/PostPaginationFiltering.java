package com.okancezik.tubitak.core.filter_pagination;

import lombok.Data;

@Data
public class PostPaginationFiltering {

    private int pageSize = 10;
    private int pageIndex = 0;

    public PostPaginationFiltering (int pageSize, int pageIndex)
    {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }
}
