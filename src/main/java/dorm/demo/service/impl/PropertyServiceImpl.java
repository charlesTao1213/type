package dorm.demo.service.impl;

import dorm.demo.dao.PropertyDao;
import dorm.demo.entity.Household;
import dorm.demo.entity.Page;
import dorm.demo.service.PropertyServiceI;
import dorm.demo.entity.Property;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyServiceI {

    @Resource(type = PropertyDao.class)
    private PropertyDao propertyDao;

    @Override
    public int total() {
        return propertyDao.total();
    }

    @Override
    public List<Property> list(Page page) {
        return propertyDao.list(page);
    }

    @Override
    public PropertyDao getPropertyDao() {
        return propertyDao;
    }

    public Property getById(String dormno) {
        return propertyDao.getById(dormno);
    }

    public Property getByEntity(Property property) {
        return propertyDao.getByEntity(property);
    }

    public List<Property> listByEntity(Property property) {
        return propertyDao.listByEntity(property);
    }

    public List<Property> listByIds(List<String> ids) {
        return propertyDao.listByIds(ids);
    }

    public int insert(Property property) {
        return propertyDao.insert(property);
    }

    public int insertBatch(List<Property> list) {
        return propertyDao.insertBatch(list);
    }

    public int update(Property property) {
        return propertyDao.update(property);
    }

    public int updateBatch(List<Property> list) {
        return propertyDao.updateBatch(list);
    }

    public int deleteById(String dormno) {
        return propertyDao.deleteById(dormno);
    }

    public int deleteByEntity(Property property) {
        return propertyDao.deleteByEntity(property);
    }
  
    public int deleteByIds(List<String> list) {
        return propertyDao.deleteByIds(list);
    }

    public int countAll() {
        return propertyDao.countAll();
    }
    
    public int countByEntity(Property property) {
        return propertyDao.countByEntity(property);
    }

}