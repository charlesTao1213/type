package dorm.demo.service;

import dorm.demo.dao.ElvDao;
import dorm.demo.entity.Elv;
import dorm.demo.entity.Page;
import dorm.demo.entity.Password;

import java.util.List;

public interface ElvServiceI {

    int total();
    List<Elv> list(Page page);
    
    ElvDao getElvDao();
   
    Elv getById(String no);

    Elv getByEntity(Elv elv);

    List<Elv> listByEntity(Elv elv);

    List<Elv> listByIds(List<String> ids);

    int insert(Elv elv);

    int insertBatch(List<Elv> list);

    int update(Elv elv);

    int updateBatch(List<Elv> list);

    int deleteById(String no);

    int deleteByEntity(Elv elv);
  
    int deleteByIds(List<String> list);
    
    int countAll();
    
    int countByEntity(Elv elv);
}