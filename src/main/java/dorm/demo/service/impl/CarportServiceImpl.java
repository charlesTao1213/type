package dorm.demo.service.impl;

import dorm.demo.dao.CarportDao;
import dorm.demo.entity.Page;
import dorm.demo.service.CarportServiceI;
import dorm.demo.entity.Carport;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarportServiceImpl implements CarportServiceI {

    @Resource(type = CarportDao.class)
    private CarportDao carportDao;

    @Override
    public List<Carport> list(Page page) {
        return carportDao.list(page);
    }

    @Override
    public int total() {
        return carportDao.total();
    }

    @Override
    public CarportDao getCarportDao() {
        return carportDao;
    }

    public Carport getById(String portno) {
        return carportDao.getById(portno);
    }

    public Carport getByEntity(Carport carport) {
        return carportDao.getByEntity(carport);
    }

    public List<Carport> listByEntity(Carport carport) {
        return carportDao.listByEntity(carport);
    }

    public List<Carport> listByIds(List<String> ids) {
        return carportDao.listByIds(ids);
    }

    public int insert(Carport carport) {
        return carportDao.insert(carport);
    }

    public int insertBatch(List<Carport> list) {
        return carportDao.insertBatch(list);
    }

    public int update(Carport carport) {
        return carportDao.update(carport);
    }

    public int updateBatch(List<Carport> list) {
        return carportDao.updateBatch(list);
    }

    public int deleteById(String portno) {
        return carportDao.deleteById(portno);
    }

    public int deleteByEntity(Carport carport) {
        return carportDao.deleteByEntity(carport);
    }
  
    public int deleteByIds(List<String> list) {
        return carportDao.deleteByIds(list);
    }

    public int countAll() {
        return carportDao.countAll();
    }
    
    public int countByEntity(Carport carport) {
        return carportDao.countByEntity(carport);
    }

}