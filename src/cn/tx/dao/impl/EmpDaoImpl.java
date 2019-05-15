package cn.tx.dao.impl;

import cn.tx.dao.EmpDao;
import cn.tx.model.Emp;
import cn.tx.query.EmpQuery;
import org.apache.commons.lang.StringUtils;


public class EmpDaoImpl extends BaseDaoImpl<Emp,EmpQuery> implements EmpDao {

    @Override
    public String createHql(EmpQuery empQuery) {
        String hql = "from Emp t where 1=1";
        hql = hql + createHqlCondition(empQuery);
        return hql;
    }

    @Override
    public String createHqlCount(EmpQuery empQuery) {
        String hql = "select count(empId) from Emp";
        hql = hql + createHqlCondition(empQuery);
        return hql;
    }

    @Override
    public String createHqlCondition(EmpQuery empQuery) {
        String hql = "";
        if(StringUtils.isNotBlank(empQuery.getUsername())){
            hql = hql + " and t.username like :username";
        }
        if(StringUtils.isNotBlank(empQuery.getName())){
            hql = hql + " and t.name like :name";
        }
        if(StringUtils.isNotBlank(empQuery.getTel())){
            hql = hql + " and t.tel like :tel";
        }
        if(empQuery.getGender() != null){
            hql = hql + " and t.gender = :gender";
        }
        if(StringUtils.isNotBlank(empQuery.getEmail())){
            hql = hql + " and t.email like :email";
        }
        if(empQuery.getStartBirth() != null){
            hql = hql + " and t.birthday >= :startBirth";
        }
        if(empQuery.getEndBirth() != null){
            hql = hql + " and t.birthday <= :endBirth";
        }
        if(empQuery.getDepId() != null){
            hql = hql + " and t.dep.depId = :depId";
        }
        return hql;
    }
}
