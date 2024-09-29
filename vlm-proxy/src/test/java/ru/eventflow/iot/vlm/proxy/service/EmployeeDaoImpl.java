package ru.eventflow.iot.vlm.proxy.service;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import ru.eventflow.iot.vlm.proxy.dao.EmployeeDao;
import ru.eventflow.iot.vlm.proxy.domain.Employee;

import java.util.List;

/**
 * See https://mybatis.org/spring/sqlsession.html#SqlSessionDaoSupport
 */
public class EmployeeDaoImpl extends SqlSessionDaoSupport implements EmployeeDao {

    @Override
    public Employee findEmployeeById(int id) {
        return getSqlSession().selectOne("ru.eventflow.iot.vlm.proxy.dao.EmployeeDao.findEmployeeById", id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return getSqlSession().selectList("ru.eventflow.iot.vlm.proxy.dao.EmployeeDao.findAllEmployees");
    }
}
