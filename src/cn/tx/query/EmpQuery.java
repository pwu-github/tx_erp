package cn.tx.query;

import cn.tx.model.Emp;

import java.util.Date;

public class EmpQuery extends Emp {

    private Date startBirth;

    private Date endBirth;

    private Integer startNum;

    private Integer pageNo;

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Date getStartBirth() {
        return startBirth;
    }

    public void setStartBirth(Date startBirth) {
        this.startBirth = startBirth;
    }

    public Date getEndBirth() {
        return endBirth;
    }

    public void setEndBirth(Date endBirth) {
        this.endBirth = endBirth;
    }
}
