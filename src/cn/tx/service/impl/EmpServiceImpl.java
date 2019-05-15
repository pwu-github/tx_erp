package cn.tx.service.impl;

import cn.tx.dao.EmpDao;
import cn.tx.model.Emp;
import cn.tx.query.EmpQuery;
import cn.tx.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmpServiceImpl extends BaseServiceImpl<Emp,EmpQuery> implements EmpService {

    @Autowired
    private EmpDao empDao;

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
        this.baseDao = empDao;
    }


}
