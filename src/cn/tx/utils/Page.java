package cn.tx.utils;

import java.util.List;

public class Page {

    //页码
    private int pageNo = 1;

    //每页的记录数
    private int pageSize = 5;

    //指定查询条件下的总记录数,需要根据数据库查询出来
    private int totlaCount = 0;

    //指定条件下的总页数
    private int totalPage;

    //开始行号  startNum=（pageNo - 1） * pageSize
    private int startNum;

    //结果集,需要根据数据库查询出来
    private List<?> list;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotlaCount() {
        return totlaCount;
    }

    public void setTotlaCount(int totlaCount) {
        this.totlaCount = totlaCount;
    }

    public int getTotalPage() {
        totalPage = totlaCount/pageSize;
        if(totlaCount == 0 || totlaCount%pageSize != 0){
            totlaCount++;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartNum() {
        return startNum = (pageNo - 1)*pageSize;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
