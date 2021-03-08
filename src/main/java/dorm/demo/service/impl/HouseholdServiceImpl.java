package dorm.demo.service.impl;

import dorm.demo.dao.HouseholdDao;
import dorm.demo.entity.Page;
import dorm.demo.service.HouseholdServiceI;
import dorm.demo.entity.Household;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HouseholdServiceImpl implements HouseholdServiceI {

    @Resource(type = HouseholdDao.class)
    private HouseholdDao householdDao;

    @Override
    public int total() {
        return householdDao.total();
    }

    @Override
    public List<Household> list(Page page) {

        return householdDao.list(page);
    }

    @Override
    public HouseholdDao getHouseholdDao() {
        return householdDao;
    }

    public Household getById(String dormno) {
        return householdDao.getById(dormno);
    }

    public Household getByEntity(Household household) {
        return householdDao.getByEntity(household);
    }

    public List<Household> listByEntity(Household household) {
        return householdDao.listByEntity(household);
    }

    public List<Household> listByIds(List<String> ids) {
        return householdDao.listByIds(ids);
    }

    public int insert(Household household) {
        return householdDao.insert(household);
    }

    public int insertBatch(List<Household> list) {
        return householdDao.insertBatch(list);
    }

    public int update(Household household) {
        return householdDao.update(household);
    }

    public int updateBatch(List<Household> list) {
        return householdDao.updateBatch(list);
    }

    public int deleteById(int dormno) {
        return householdDao.deleteById(dormno);
    }

    public int deleteByEntity(Household household) {
        return householdDao.deleteByEntity(household);
    }
  
    public int deleteByIds(List<String> list) {
        return householdDao.deleteByIds(list);
    }

    public int countAll() {
        return householdDao.countAll();
    }
    
    public int countByEntity(Household household) {
        return householdDao.countByEntity(household);
    }

}