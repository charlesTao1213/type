package dorm.demo.service;

import dorm.demo.dao.HouseholdDao;
import dorm.demo.entity.Household;
import dorm.demo.entity.Page;

import java.util.List;

public interface HouseholdServiceI {
    int total();
    List<Household> list(Page page);

    
    HouseholdDao getHouseholdDao();
   
    Household getById(String dormno);

    Household getByEntity(Household household);

    List<Household> listByEntity(Household household);

    List<Household> listByIds(List<String> ids);

    int insert(Household household);

    int insertBatch(List<Household> list);

    int update(Household household);

    int updateBatch(List<Household> list);

    int deleteById(int dormno);

    int deleteByEntity(Household household);
  
    int deleteByIds(List<String> list);
    
    int countAll();
    
    int countByEntity(Household household);
}