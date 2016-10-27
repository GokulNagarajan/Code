import Exception.DaoException;

import com.mindtree.entity.User;
import com.mindtree.service.UserDao;

public class UserService {
private UserDao userDao;
public void setUserDao(UserDao userDao) {
this.userDao = userDao;
}
public boolean isUserValid(String userName, String pwd) {
boolean isValid = true;
try {
userDao.getUser(userName, pwd);
} catch (DaoException e) {
//e.printStackTrace();
//System.out.println(e.toString());
isValid = false;
}
return isValid;
}
public boolean addUser(User user) {
boolean isValid = true;
try {
userDao.addUser(user);
} catch (DaoException e) {
//e.printStackTrace();
//System.out.println(e.toString());
isValid = false;
}
return isValid;
}
}