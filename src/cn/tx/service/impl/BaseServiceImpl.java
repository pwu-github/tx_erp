package cn.tx.service.impl;

import cn.tx.dao.BaseDao;
import cn.tx.service.BaseService;
import cn.tx.utils.Page;

import java.lang.reflect.Field;
import java.util.List;

public class BaseServiceImpl<T,Q> implements BaseService<T,Q> {
    BaseDao<T,Q> baseDao;
    @Override
    public void save(T t) {
        baseDao.save(t);
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }

    @Override
    public T getObj(Integer id) {
        return (T)baseDao.getObj(id);
    }

    @Override
    public void delete(Integer id) {
        baseDao.delete(id);
    }

    @Override
    public void delete(T obj) {
        baseDao.delete(obj);
    }

    @Override
    public Page queryObjByCondition(Q q, List<String> exclude) {
        Page page = new Page();
        Class<?> qClass = q.getClass();
        try {
            Field field = qClass.getDeclaredField("pageNo");
            field.setAccessible(true);
            Integer pageNo = (Integer) field.get(q);
            page.setPageNo(pageNo);
            int startNum = page.getStartNum();
            Field startNum1 = qClass.getDeclaredField("startNum");
            field.setAccessible(true);
            startNum1.set(q,startNum);
            //查询结果集
            List<T> tList = baseDao.queryObjByCondition(q, exclude);
            page.setList(tList);
            //查询当前条件下的总记录数
            Long count = baseDao.queryObjByConditionCount(q,exclude );
            page.setTotlaCount(new Integer(count+""));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }


    @Override
    public List<T> list() {
        return baseDao.list();
    }
}
