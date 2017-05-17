package com.eekrupin.testCRUD.dao;
import com.eekrupin.testCRUD.Direction;
import com.eekrupin.testCRUD.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    final int LIMIT = 5;

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void addUser(User user) {
        getSession().persist(user);
        logger.info("Пользователь сохранен: " + user.toString());
    }

    @Override
    public void updateUser(User user) {
        getSession().update(user);
        logger.info("Пользователь обновлен: " + user.toString());
    }

    @Override
    public void removeUser(int id) {
        User user = (User)getSession().load(User.class, new Integer(id));
        if (user!=null){
            getSession().delete(user);
        }
        logger.info("Пользователь удален: " + user.toString());
    }

    @Override
    public User getUser(int id) {
        User user = (User)getSession().load(User.class, new Integer(id));
        logger.info("Пользователь загружен: " + user.toString());
        return user;
    }

    @SuppressWarnings("uncheked")
    public List<User> listUsers(int id, Direction direction, String searchName) {
        Session session = getSession();
        List<User> userList;
        if (direction == Direction.Forward) {
            userList = session.createSQLQuery("select * from User where id > ? AND NAME LIKE '%" + searchName + "%' order by id limit ?")
                    .addEntity(User.class)
                    .setInteger(0, id)
                    .setInteger(1, LIMIT)
                    .list();
        }
        else {
            userList = session.createSQLQuery("SELECT * FROM (select * from User where id < ? AND NAME LIKE '%" + searchName + "%' order by id desc limit ?) AS tabl order by id")
                    .addEntity(User.class)
                    .setInteger(0, id)
                    .setInteger(1, LIMIT)
                    .list();
        }
        for (User user: userList){
            logger.info("Список пользоватлей: " + user);
        }
        return userList;
    }

    public List<User> listUsers(String searchName) {
        return listUsers(0, Direction.Forward, searchName);
    }

}
