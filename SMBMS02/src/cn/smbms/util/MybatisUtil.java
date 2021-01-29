package cn.smbms.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;

public class MybatisUtil {

	private static SqlSessionFactory sqlSessionFactory;
	static{
		String resource ="mybatis_config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			// ´´½¨SqlSessionFactory
			 sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
}

	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
		
	}
	
	public static void closeSqlSession(SqlSession session){
		if(session!=null){session.close();}
		
	}
	
}
