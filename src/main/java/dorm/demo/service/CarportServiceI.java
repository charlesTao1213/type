package dorm.demo.service;

import dorm.demo.dao.CarportDao;
import dorm.demo.entity.Carport;
import dorm.demo.entity.Elv;
import dorm.demo.entity.Page;

import java.util.List;

public interface CarportServiceI {



    public List<Carport> list(Page page);


    public int total();
    
    CarportDao getCarportDao();
   
    Carport getById(String portno);

    Carport getByEntity(Carport carport);

    List<Carport> listByEntity(Carport carport);

    List<Carport> listByIds(List<String> ids);

    int insert(Carport carport);

    int insertBatch(List<Carport> list);

    int update(Carport carport);

    int updateBatch(List<Carport> list);

    int deleteById(String portno);

    int deleteByEntity(Carport carport);
  
    int deleteByIds(List<String> list);
    
    int countAll();
    
    int countByEntity(Carport carport);
}