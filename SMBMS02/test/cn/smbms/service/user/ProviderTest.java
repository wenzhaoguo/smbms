package cn.smbms.service.user;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import org.apache.ibatis.session.SqlSession;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import cn.smbms.dao.provider.ProviderMapper;

import cn.smbms.pojo.Provider;
import cn.smbms.service.provider.ProviderService;
import cn.smbms.util.MybatisUtil;



public class ProviderTest {
	
	private Logger logger =Logger.getLogger(ProviderTest.class);
	@Test
	public void addProvider(){
		int count = 0;
//		List<User> list = new ArrayList<User>();
		
		SqlSession session = null;
		Date date = new Date();
		session = MybatisUtil.getSqlSession();
		Provider  provider=new Provider();
		provider.setId(16);
		provider.setProCode("1");
		provider.setProName("2");
		provider.setProDesc("3");
		provider.setProContact("4");
		provider.setProPhone("5");
		provider.setProAddress("6");
		provider.setProFax("7");
		provider.setCreatedBy(1);
		provider.setCreationDate(date);
		provider.setModifyDate(date);
		provider.setModifyBy(1);
		
		count = session.getMapper(ProviderMapper.class).addProvider(provider);
		session.commit();
		
		logger.debug("添加成功!");
		MybatisUtil.closeSqlSession(session);
	}
	
	
	@Test
	public void getProviderList(){
		//int count = 0;
		List<Provider> list = new ArrayList<Provider>();
		
		SqlSession session = null;
		
		session = MybatisUtil.getSqlSession();
		
		list = session.getMapper(ProviderMapper.class).getProviderList("2","1");
			session.commit();
			
			for (Provider provider : list) {
				logger.debug(provider.toString());
			}
			MybatisUtil.closeSqlSession(session);
			}
			
				
	@Test
	public void deleteProviderById(){
		int count = 0;
//		List<User> list = new ArrayList<User>();
		
		SqlSession session = null;
		
		session = MybatisUtil.getSqlSession();
		
		count = session.getMapper(ProviderMapper.class).deleteProviderById(16);
			session.commit();
			
				logger.debug("删除成功!!");
			
		MybatisUtil.closeSqlSession(session);
	}
	
	@Test
	public void getProviderById(){
		//int count = 0;
		List<Provider> list = new ArrayList<Provider>();
		
		SqlSession session = null;
		
		session = MybatisUtil.getSqlSession();
		
		list = session.getMapper(ProviderMapper.class).getProviderById(2);
			session.commit();
			
			for (Provider provider : list) {
				logger.debug(provider.toString());
			}
			
		MybatisUtil.closeSqlSession(session);
	}
	//*******************Spring-mybatis*****************
		@Test
		public void getProviderById01() {
			ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
			ProviderService providerService=(ProviderService)applicationContext.getBean("ProviderService");
			try {
				for(Provider provider : providerService.getProviderById(2)){
				logger.info(provider.getProAddress());	}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	@Test
	public void modify(){
		int count = 0;
//		List<User> list = new ArrayList<User>();
		
		SqlSession session = null;
		Date date = new Date();
		session = MybatisUtil.getSqlSession();
		Provider  provider=new Provider();
		provider.setId(1);
		provider.setProCode("1");
		provider.setProName("2");
		/*provider.setProDesc("3");
		provider.setProContact("4");
		provider.setProPhone("5");
		provider.setProAddress("6");
		provider.setProFax("7");
		provider.setCreatedBy(1);
		provider.setCreationDate(date);
		provider.setModifyDate(date);
		provider.setModifyBy(1);*/
		
		count = session.getMapper(ProviderMapper.class).modify(provider);
		session.commit();
		
		logger.debug("修改成功!");
		MybatisUtil.closeSqlSession(session);
	}
	
}

