package dorm.demo.dao;

import dorm.demo.entity.Carport;
import dorm.demo.entity.Elv;
import dorm.demo.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CarportDao {
    public List<Carport> list(Page page);


    public int total();

    Carport getById(String portno);

    List<Carport> listByEntity(Carport carport);

    Carport getByEntity(Carport carport);

    List<Carport> listByIds(List<String> list);

    int insert(Carport carport);

    int insertBatch(List<Carport> list);

    int update(Carport carport);

    int updateByField(@Param("where") Carport where, @Param("set") Carport set);

    int updateBatch(List<Carport> list);

    int deleteById(String portno);

    int deleteByEntity(Carport carport);
  
    int deleteByIds(List<String> list);
    
    int countAll();
    
    int countByEntity(Carport carport);
    
}