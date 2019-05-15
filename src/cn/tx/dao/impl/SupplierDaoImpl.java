package cn.tx.dao.impl;

import cn.tx.dao.SupplierDao;
import cn.tx.model.Supplier;
import cn.tx.query.SupplierQuery;
import org.apache.commons.lang.StringUtils;


public class SupplierDaoImpl extends BaseDaoImpl<Supplier,SupplierQuery> implements SupplierDao {

    @Override
    public String createHql(SupplierQuery demoQuery) {
        String hql = "from Supplier t where 1=1";
        
        return hql;
    }

    @Override
    public String createHqlCount(SupplierQuery supplierQuery) {
        return null;
    }

    @Override
    public String createHqlCondition(SupplierQuery supplierQuery) {
        return null;
    }
}
