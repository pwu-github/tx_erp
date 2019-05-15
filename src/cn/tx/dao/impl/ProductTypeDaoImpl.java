package cn.tx.dao.impl;

import cn.tx.dao.ProductTypeDao;
import cn.tx.model.ProductType;
import cn.tx.query.ProductTypeQuery;
import org.apache.commons.lang.StringUtils;


public class ProductTypeDaoImpl extends BaseDaoImpl<ProductType,ProductTypeQuery> implements ProductTypeDao {

    @Override
    public String createHql(ProductTypeQuery demoQuery) {
        String hql = "from ProductType t where 1=1";
        
        return hql;
    }

    @Override
    public String createHqlCount(ProductTypeQuery productTypeQuery) {
        return null;
    }

    @Override
    public String createHqlCondition(ProductTypeQuery productTypeQuery) {
        return null;
    }
}
