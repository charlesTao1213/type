package dorm.demo.service.impl;

import dorm.demo.dao.PasswordDao;
import dorm.demo.entity.Page;
import dorm.demo.service.PasswordServiceI;
import dorm.demo.entity.Password;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PasswordServiceImpl implements PasswordServiceI {

    @Resource(type = PasswordDao.class)
    private PasswordDao passwordDao;

    @Override
    public int total() {
        return passwordDao.total();
    }

    @Override
    public List<Password> list(Page page) {
        return passwordDao.list(page);
    }

    @Override
    public PasswordDao getPasswordDao() {
        return passwordDao;
    }

    public Password getById(String dormno) {
        return passwordDao.getById(dormno);
    }

    public Password getByEntity(Password password) {
        return passwordDao.getByEntity(password);
    }

    public List<Password> listByEntity(Password password) {
        return passwordDao.listByEntity(password);
    }

    public List<Password> listByIds(List<String> ids) {
        return passwordDao.listByIds(ids);
    }

    public int insert(Password password) {
        return passwordDao.insert(password);
    }

    public int insertBatch(List<Password> list) {
        return passwordDao.insertBatch(list);
    }

    public int update(Password password) {
        return passwordDao.update(password);
    }

    public int updateBatch(List<Password> list) {
        return passwordDao.updateBatch(list);
    }

    public int deleteById(String dormno) {
        return passwordDao.deleteById(dormno);
    }

    public int deleteByEntity(Password password) {
        return passwordDao.deleteByEntity(password);
    }
  
    public int deleteByIds(List<String> list) {
        return passwordDao.deleteByIds(list);
    }

    public int countAll() {
        return passwordDao.countAll();
    }
    
    public int countByEntity(Password password) {
        return passwordDao.countByEntity(password);
    }

}