package cn.smbms.service.user;


import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import cn.smbms.dao.role.RoleMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.bill.BillService;
import cn.smbms.service.role.RoleService;
import cn.smbms.util.MybatisUtil;


public class RoleTest {
	private Logger logger =Logger.getLogger(RoleTest.class);
	
	@Test
	public void getRole(){
		//int count = 0;
		List<Role> list = new ArrayList<Role>();
		
		SqlSession session = null;
		
		session = MybatisUtil.getSqlSession();
		
		list = session.getMapper(RoleMapper.class).getRole();
			session.commit();
			
			for (Role role : list) {
				logger.debug(role.getId()+role.getRoleCode()+role.getRoleName());
			}
			
				
		MybatisUtil.closeSqlSession(session);
	}
	
	
	//*******************Spring-mybatis*****************
		@Test
		public void getRole02() {
			
			ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
			RoleService roleService=(RoleService)applicationContext.getBean("RoleService");
			try {
				for (Role role : roleService.getRole()) {
					logger.info(role.getRoleName());	
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
