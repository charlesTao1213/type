package dorm.demo.dao;

import dorm.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-01 20:13:37
 */
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
   
    User queryByUserName(String userName);
    List<User> queryAll();

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 影响行数
     */
    int deleteById( );

}