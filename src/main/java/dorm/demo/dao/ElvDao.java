package dorm.demo.dao;

import dorm.demo.entity.Elv;
import dorm.demo.entity.Page;
import dorm.demo.entity.Password;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ElvDao {



    public List<Elv> list(Page page);


    public int total();

    Elv getById(String no);

    List<Elv> listByEntity(Elv elv);

    Elv getByEntity(Elv elv);

    List<Elv> listByIds(List<String> list);

    int insert(Elv elv);

    int insertBatch(List<Elv> list);

    int update(Elv elv);

    int updateByField(@Param("where") Elv where, @Param("set") Elv set);

    int updateBatch(List<Elv> list);

    int deleteById(String no);

    int deleteByEntity(Elv elv);
  
    int deleteByIds(List<String> list);
    
    int countAll();
    
    int countByEntity(Elv elv);
    
}