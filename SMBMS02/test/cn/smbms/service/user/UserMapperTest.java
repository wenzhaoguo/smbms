package cn.smbms.service.user;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.util.MybatisUtil;

public class UserMapperTest {
	private Logger logger = Logger.getLogger(UserMapperTest.class);

	@Test
	public void add() {
		int i = 0;
		SqlSession session = null;
		// 读取核心配置文件
		session = MybatisUtil.getSqlSession();
		User user = new User();
		user.setUserCode("xiaowen");
		user.setUserName("老温");
		user.setUserPassword("00000000");
		// 发起会话
		try {
			i = session.getMapper(UserMapper.class).add(user);
			logger.debug(">>>>" + i);
			session.commit();
			MybatisUtil.closeSqlSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//*******************Spring-mybatis*****************
	@Test
	public void getLoginUser01() {
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		UserService userService=(UserService)applicationContext.getBean("UserService");
		try {
			String userCode ="zhanghua";
			logger.info(userService.getLoginUser(userCode).getAddress());	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getLoginUser02() {
		// 用户数量
		User user = null;
		SqlSession session = null;
		// 读取核心配置文件
		String userCode = "hanlubiao";
		session = MybatisUtil.getSqlSession();
		// 发起会话
		try {
			user = session.getMapper(UserMapper.class).getLoginUser(userCode);
			logger.debug(">>>>" + user.getAddress()+user.getPhone()+user.getUserName());

			MybatisUtil.closeSqlSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void getUserList() {
		// 用户数量
		List<User> user = null;
		SqlSession session = null;
		// 读取核心配置文件
		String userName = "王洋";
		session = MybatisUtil.getSqlSession();
		// 发起会话
		try {
			user = session.getMapper(UserMapper.class).getUserList(userName, 3, 1, 1);
			for (User user2 : user) {
				logger.debug(">>>>" + user2.getAddress()+user2.getPhone()+user2.getUserName());

			}

			MybatisUtil.closeSqlSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void deleteUserById() {
		int i = 0;
		SqlSession session = null;
		// 读取核心配置文件
		session = MybatisUtil.getSqlSession();
		// 发起会话
		try {
			i = session.getMapper(UserMapper.class).deleteUserById(17);
			logger.debug(">>>>" + i);
			session.commit();
			MybatisUtil.closeSqlSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void getUserById() {
		// 用户数量
		
		SqlSession session = null;
		// 读取核心配置文件
		session = MybatisUtil.getSqlSession();
		// 发起会话
		try {
			User user = session.getMapper(UserMapper.class).getUserById(1);
			
				logger.debug(">>>>" + user.getAddress()+user.getPhone()+user.getUserName());

			

			MybatisUtil.closeSqlSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	@Test
	public void modify() {
		int i = 0;
		SqlSession session = null;
		// 读取核心配置文件
		session = MybatisUtil.getSqlSession();
		User user = new User();
		user.setUserCode("xiaowen");
		user.setUserName("哈哈");
		user.setUserPassword("00000000");
		user.setId(16);
		// 发起会话
		try {
			i = session.getMapper(UserMapper.class).modify(user);
			logger.debug(">>>>" + i);
			session.commit();
			MybatisUtil.closeSqlSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void updatePwd() {
		int i = 0;
		SqlSession session = null;
		// 读取核心配置文件
		session = MybatisUtil.getSqlSession();
		// 发起会话
		try {
			i = session.getMapper(UserMapper.class).updatePwd(16, "1111111");
			logger.debug(">>>>" + i);
			session.commit();
			MybatisUtil.closeSqlSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	 public void getUserCounttest() throws Exception {
	  int count=0;
	  SqlSession session = null;
		// 读取核心配置文件
		session = MybatisUtil.getSqlSession();
		// 发起会话
	  count=session.getMapper(UserMapper.class).getUserCount("孙", 3);
	  logger.info(count);
	  MybatisUtil.closeSqlSession(session);
	  
	 }
}
