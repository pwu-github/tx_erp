package cn.tx.dao.impl;

import cn.tx.dao.BaseDao;
import cn.tx.model.Dep;
import cn.tx.model.Emp;
import cn.tx.query.DepQuery;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.runners.Parameterized;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseDaoImpl<T,Q> extends HibernateDaoSupport implements BaseDao<T,Q> {
    @Override
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public T getObj(Integer id) {
        Class<?> genericClass = getGenericClass();
        return (T) this.getHibernateTemplate().get(genericClass,id );
    }

    @Override
    public void delete(Integer id) {
        T obj = getObj(id);
        this.getHibernateTemplate().delete(obj);
    }

    @Override
    public void delete(T obj) {
        this.getHibernateTemplate().delete(obj);
    }

    @Override
    public List<T> queryObjByCondition(final Q q,final List<String> exclude) {
        @SuppressWarnings("unchecked")
        List<T> tList = this.getHibernateTemplate().executeFind(new HibernateCallback<List<T>>() {

            @Override
            public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
                String hql = createHql(q);
                //创建查询对象
                Query query = session.createQuery(hql);
                setDynamicParam(query,q,exclude);

                Class<?> qClass = q.getClass();
                Field startNumField = null;
                Object o = null;
                try {
                    startNumField = qClass.getDeclaredField("startNum");
                    startNumField.setAccessible(true);
                    o = startNumField.get(q);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                List<T> list = (List<T>)query.setFirstResult((Integer)o).setMaxResults(5).list();
                return list;
            }
        });
        return tList;
    }

    public Class getGenericClass(){
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)genericSuperclass;
        Type[] actualTypeArguments = pt.getActualTypeArguments();
        Class class1 = (Class)actualTypeArguments[0];
        return class1;
    }

    public abstract String createHql(Q q);
    public abstract String createHqlCount(Q q);
    public abstract String createHqlCondition(Q q);

    //设置动态参数
    public void setDynamicParam(Query query,Q q,List<String> exclude){
        //获得查询类的类对象
        Class<? extends Object> class1 = q.getClass();
        //反向解析查询对象，得到查询对象的所有属性
        Field[] fields = class1.getDeclaredFields();
        //获得父类的属性
        Field[] fields1 = class1.getSuperclass().getDeclaredFields();
        List<Field> list = Arrays.asList(fields);
        List<Field> list1 = Arrays.asList(fields1);
        List<Field> fieldList = new ArrayList<Field>();
        fieldList.addAll(list);
        fieldList.addAll(list1);

        for(Field f : fieldList){
            //获得属性名字
            String fieldName = f.getName();
            if(exclude != null && exclude.contains(fieldName)){
                continue;
            }
            Object val = null;
            try {
                f.setAccessible(true);
                val = f.get(q);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(val != null){
                if(val.getClass() == String.class ){
                    if(StringUtils.isNotBlank(val.toString())){
                        query.setParameter(fieldName,"%"+val+"%" );
                    }
                }else{
                    query.setParameter(fieldName,val );
                }
            }
        }
    }

    public List<T> list(){
        Class aClass = getGenericClass();
        String hql = "from " + aClass.getName();
        return this.getHibernateTemplate().find(hql);
    }

    //查询指定条件下的总记录数，对应utils下的page中的totalCount
    public Long queryObjByConditionCount(final Q q, final List<String> exclude){
        @SuppressWarnings("unchecked")
        Long totalCount = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {

            @Override
            public Long doInHibernate(Session session) throws HibernateException, SQLException {
                String hql = createHqlCount(q);
                //创建查询对象
                Query query = session.createQuery(hql);
                setDynamicParam(query,q,exclude);
                Long result = (Long) query.uniqueResult();
                return result;
            }
        });
        return totalCount;
    }
}
