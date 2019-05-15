package cn.tx.dao.impl;

import cn.tx.dao.DepDao;
import cn.tx.dao.EmpDao;
import cn.tx.model.Dep;
import cn.tx.model.Emp;
import cn.tx.query.DepQuery;
import cn.tx.query.EmpQuery;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepDaoImpl extends BaseDaoImpl<Dep,DepQuery> implements DepDao {


    @Override
    public String createHql(DepQuery depQuery) {
        String hql = "from Dep t where 1=1";

        if(StringUtils.isNotBlank(depQuery.getName())){
            hql = hql + "and t.name like :name";
        }
        if(StringUtils.isNotBlank(depQuery.getTel())){
            hql = hql + "and t.tel like :tel";
        }
        return hql;
    }

    @Override
    public String createHqlCount(DepQuery depQuery) {
        return null;
    }

    @Override
    public String createHqlCondition(DepQuery depQuery) {
        return null;
    }
}
