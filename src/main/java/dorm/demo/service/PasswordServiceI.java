package dorm.demo.service;

import dorm.demo.dao.PasswordDao;
import dorm.demo.entity.Page;
import dorm.demo.entity.Password;

import java.util.List;

public interface PasswordServiceI {

    int total();
    List<Password> list(Page page);
    
    PasswordDao getPasswordDao();
   
    Password getById(String dormno);

    Password getByEntity(Password password);

    List<Password> listByEntity(Password password);

    List<Password> listByIds(List<String> ids);

    int insert(Password password);

    int insertBatch(List<Password> list);

    int update(Password password);

    int updateBatch(List<Password> list);

    int deleteById(String dormno);

    int deleteByEntity(Password password);
  
    int deleteByIds(List<String> list);
    
    int countAll();
    
    int countByEntity(Password password);
}