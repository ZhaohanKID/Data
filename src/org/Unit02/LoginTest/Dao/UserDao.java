package org.Unit02.LoginTest.Dao;

public interface UserDao {
    public abstract boolean UserLogin(String name, String password);
    public abstract boolean UserRegister(String name, String password);
}
