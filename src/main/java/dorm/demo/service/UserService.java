package dorm.demo.service;

import dorm.demo.entity.User;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-03-01 20:20:16
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */

    String queryByUserName(String userName ,String passWord);


    List<User> queryAll();
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    boolean deleteById( );

}