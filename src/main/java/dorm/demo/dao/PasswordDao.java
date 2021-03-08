package dorm.demo.dao;

import dorm.demo.entity.Page;
import dorm.demo.entity.Password;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PasswordDao {
    public List<Password> list(Page page);


    public int total();

    Password getById(String dormno);

    List<Password> listByEntity(Password password);

    Password getByEntity(Password password);

    List<Password> listByIds(List<String> list);

    int insert(Password password);

    int insertBatch(List<Password> list);

    int update(Password password);

    int updateByField(@Param("where") Password where, @Param("set") Password set);

    int updateBatch(List<Password> list);

    int deleteById(String dormno);

    int deleteByEntity(Password password);
  
    int deleteByIds(List<String> list);
    
    int countAll();
    
    int countByEntity(Password password);
    
}