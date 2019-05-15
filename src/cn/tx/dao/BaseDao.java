package cn.tx.dao;

import cn.tx.model.Emp;
import cn.tx.query.EmpQuery;

import java.util.List;

public interface BaseDao<T,Q> {

    public void save(T t);

    public void update(T t);

    public T getObj(Integer id);

    public void delete(Integer id);

    public void delete(T obj);

    //查询指定条件下的每一页的结果集，对应utils下的page中的结果集List<?>
    public List<T> queryObjByCondition(Q q,List<String> exclude);

    //查询指定条件下的总记录数，对应utils下的page中的totalCount
    public Long queryObjByConditionCount(Q q,List<String> exclude);

    public List<T> list();
}
