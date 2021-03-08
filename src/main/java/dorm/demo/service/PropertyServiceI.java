package dorm.demo.service;

import dorm.demo.dao.PropertyDao;
import dorm.demo.entity.Household;
import dorm.demo.entity.Page;
import dorm.demo.entity.Property;

import java.util.List;

public interface PropertyServiceI {
    int total();
    List<Property> list(Page page);

    
    PropertyDao getPropertyDao();
   
    Property getById(String dormno);

    Property getByEntity(Property property);

    List<Property> listByEntity(Property property);

    List<Property> listByIds(List<String> ids);

    int insert(Property property);

    int insertBatch(List<Property> list);

    int update(Property property);

    int updateBatch(List<Property> list);

    int deleteById(String dormno);

    int deleteByEntity(Property property);
  
    int deleteByIds(List<String> list);
    
    int countAll();
    
    int countByEntity(Property property);
}