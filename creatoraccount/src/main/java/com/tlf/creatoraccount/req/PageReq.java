package com.tlf.creatoraccount.req;

public class PageReq extends BaseReq {
    private Integer limit;
    private Integer offset;

    public PageReq(Integer limit, Integer offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public PageReq() {
    }

    public PageReq(String role, String accountId, Integer limit, Integer offset) {
        super(role, accountId);
        this.limit = limit;
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
