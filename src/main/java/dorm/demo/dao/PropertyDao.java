package dorm.demo.dao;

import dorm.demo.entity.Household;
import dorm.demo.entity.Page;
import dorm.demo.entity.Property;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PropertyDao {
    public List<Property> list(Page page);


    public int total();
    Property getById(String dormno);

    List<Property> listByEntity(Property property);

    Property getByEntity(Property property);

    List<Property> listByIds(List<String> list);

    int insert(Property property);

    int insertBatch(List<Property> list);

    int update(Property property);

    int updateByField(@Param("where") Property where, @Param("set") Property set);

    int updateBatch(List<Property> list);

    int deleteById(String dormno);

    int deleteByEntity(Property property);
  
    int deleteByIds(List<String> list);
    
    int countAll();
    
    int countByEntity(Property property);
    
}