package dorm.demo.dao;

import dorm.demo.entity.Household;
import dorm.demo.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface HouseholdDao {
    public List<Household> list(Page page);

    public int total();

    Household getById(String dormno);

    List<Household> listByEntity(Household household);

    Household getByEntity(Household household);

    List<Household> listByIds(List<String> list);

    int insert(Household household);

    int insertBatch(List<Household> list);

    int update(Household household);

    int updateByField(@Param("where") Household where, @Param("set") Household set);

    int updateBatch(List<Household> list);

    int deleteById(int dormno);

    int deleteByEntity(Household household);
  
    int deleteByIds(List<String> list);
    
    int countAll();
    
    int countByEntity(Household household);
    
}