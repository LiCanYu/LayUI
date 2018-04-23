package com.practis.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.BeanFactory;

public class BeenFactory {
    static SqlSessionFactory ssf;
    static {
        ssf=new SqlSessionFactoryBuilder().build(BeanFactory.class.getResourceAsStream("mybatis.xml"));
    }
    public SqlSession getSession(){
        return ssf.openSession();
    }
}
