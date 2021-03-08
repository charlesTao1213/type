package dorm.demo.service.impl;
import com.alibaba.druid.support.json.JSONUtils;
import  dorm.demo.entity.User;
import dorm.demo.dao.UserDao;
import dorm.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-03-01 20:20:16
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public String queryByUserName(String userName ,String passWord) {
        User user= userDao.queryByUserName(userName);
        if(user.getPassword().equals(passWord)){
            return "true";
        }
        return "false";
    }

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */


    @Override
    public List<User> queryAll() {
        return this.userDao.queryAll();
    }


    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.userDao.queryByUserName(user.getUsername());
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.userDao.deleteById() > 0;
    }
}