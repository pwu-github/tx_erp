package cn.tx.service.impl;

import cn.tx.dao.DepDao;
import cn.tx.dao.EmpDao;
import cn.tx.model.Dep;
import cn.tx.model.Emp;
import cn.tx.query.DepQuery;
import cn.tx.query.EmpQuery;
import cn.tx.service.DepService;
import cn.tx.service.EmpService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepServiceImpl extends BaseServiceImpl<Dep,DepQuery> implements DepService {

    @Autowired
    private DepDao depDao;

    public void setDepDao(DepDao depDao) {
        this.depDao = depDao;
        this.baseDao = depDao;
    }


}
