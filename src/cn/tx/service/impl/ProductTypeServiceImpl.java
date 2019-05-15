package cn.tx.service.impl;

import cn.tx.dao.ProductTypeDao;
import cn.tx.model.ProductType;
import cn.tx.query.ProductTypeQuery;
import cn.tx.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductTypeServiceImpl extends BaseServiceImpl<ProductType,ProductTypeQuery> implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    public void setProductTypeDao(ProductTypeDao productTypeDao) {
        this.productTypeDao = productTypeDao;
        this.baseDao = productTypeDao;
    }


}
