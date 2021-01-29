package cn.smbms.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	public int add(User user) throws Exception {
		return userMapper.add(user);
	}

	public User getLoginUser(String userCode) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getLoginUser(userCode);
	}

	@Override
	public List<User> getUserList(String userName, Integer userRole) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserList(userName, userRole);
	}

	@Override
	public int getUserCount(String userName, int userRole) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserCount(userName, userRole);
	}

	@Override
	public int deleteUserById(Integer delId) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.deleteUserById(delId);
	}

	@Override
	public User getUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserById(id);
	}

	@Override
	public int modify(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.modify(user);
	}

	@Override
	public int updatePwd(int id, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updatePwd(id, userPassword);
	}

	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUserNameAndPassword(userName, password);
	}

}
