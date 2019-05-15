package cn.tx.service;

import cn.tx.utils.Page;

import java.util.List;

public interface BaseService<T,Q> {
    public void save(T t);

    public void update(T t);

    public T getObj(Integer id);

    public void delete(Integer id);

    public void delete(T obj);

    public Page queryObjByCondition(Q q,List<String> exclude);

    public List<T> list();
}
