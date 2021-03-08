package dorm.demo.service.impl;

import dorm.demo.dao.ElvDao;
import dorm.demo.entity.Page;
import dorm.demo.service.ElvServiceI;
import dorm.demo.entity.Elv;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ElvServiceImpl implements ElvServiceI {

    @Resource(type = ElvDao.class)
    private ElvDao elvDao;

    @Override
    public int total() {
        return elvDao.total();
    }

    @Override
    public List<Elv> list(Page page) {
        return elvDao.list(page);
    }

    @Override
    public ElvDao getElvDao() {
        return elvDao;
    }

    public Elv getById(String no) {
        return elvDao.getById(no);
    }

    public Elv getByEntity(Elv elv) {
        return elvDao.getByEntity(elv);
    }

    public List<Elv> listByEntity(Elv elv) {
        return elvDao.listByEntity(elv);
    }

    public List<Elv> listByIds(List<String> ids) {
        return elvDao.listByIds(ids);
    }

    public int insert(Elv elv) {
        return elvDao.insert(elv);
    }

    public int insertBatch(List<Elv> list) {
        return elvDao.insertBatch(list);
    }

    public int update(Elv elv) {
        return elvDao.update(elv);
    }

    public int updateBatch(List<Elv> list) {
        return elvDao.updateBatch(list);
    }

    public int deleteById(String no) {
        return elvDao.deleteById(no);
    }

    public int deleteByEntity(Elv elv) {
        return elvDao.deleteByEntity(elv);
    }
  
    public int deleteByIds(List<String> list) {
        return elvDao.deleteByIds(list);
    }

    public int countAll() {
        return elvDao.countAll();
    }
    
    public int countByEntity(Elv elv) {
        return elvDao.countByEntity(elv);
    }

}