package dao;

import base.BaseDao;
import dto.CommentDetailDto;
import entity.User;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao extends BaseDao {

    public List<User> findAll() {

        String sql = "SELECT user FROM User user";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }
}
