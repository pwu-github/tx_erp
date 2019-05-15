package cn.tx.controller;

import cn.tx.model.Dep;
import cn.tx.model.Emp;
import cn.tx.query.EmpQuery;
import cn.tx.service.DepService;
import cn.tx.service.EmpService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class EmpAction extends ActionSupport {

    private EmpQuery query = new EmpQuery();

    private DepService depService;

    private EmpService empService;

    public DepService getDepService() {
        return depService;
    }

    public void setDepService(DepService depService) {
        this.depService = depService;
    }

    public EmpQuery getQuery() {
        return query;
    }

    public void setQuery(EmpQuery query) {
        this.query = query;
    }

    public EmpService getEmpService() {
        return empService;
    }

    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }

    public String emp_list(){
        //查询部门信息
        List<Dep> list = depService.list();
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("dList",list );

        //查询数据
//        List<Emp> empList = empService.queryObjByCondition(query);
//        actionContext.put("empList",empList);
        return SUCCESS;
    }

    public String emp_input(){
        return SUCCESS;
    }
}
