package cn.smbms.service.user;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.smbms.dao.bill.BillMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.service.bill.BillService;
import cn.smbms.util.MybatisUtil;

public class Billtest {
	private Logger logger = Logger.getLogger(Billtest.class);

	@Test
	public void test() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Bill bill = new Bill();
		bill.setBillCode("RB_G20");
		bill.setProductName("机器人");
		bill.setProductDesc("玩具");
		bill.setProductUnit("");
		BigDecimal b1 = new BigDecimal(50);
		bill.setProductCount(b1);
		BigDecimal b2 = new BigDecimal(50);
		bill.setTotalPrice(b2);
		bill.setIsPayment(1);
		bill.setCreatedBy(1);
		bill.setProviderId(4);
		int add=0;
		try {
			add = sqlSession.getMapper(BillMapper.class).add(bill);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlSession.commit();
		logger.debug(add);
	}
	@Test
	public void getBillList(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Bill bill = new Bill();
		bill.setProductName("玩具");
		bill.setProviderId(4);
		try {
			List<Bill> billList = sqlSession.getMapper(BillMapper.class).getBillList(bill);
			for (Bill bill2 : billList) {
				logger.debug(bill2.getProductName()+bill2.getTotalPrice());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void deleteBillById(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		try {
			int num = sqlSession.getMapper(BillMapper.class).deleteBillById(21);
			sqlSession.commit();
			logger.debug(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void getBillById(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		try {
			Bill bill = sqlSession.getMapper(BillMapper.class).getBillById(19);			
			logger.debug(bill.getProductName()+bill.getTotalPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//*******************Spring-mybatis*****************
	@Test
	public void getBillById02() {
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		BillService billService=(BillService)applicationContext.getBean("BillService");
		try {
			
			logger.info(billService.getBillById(19).getProductName());	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void modify(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Bill bill = new Bill();
		bill.setId(6);
		bill.setBillCode("RB-G6");
		try {
			int num = sqlSession.getMapper(BillMapper.class).modify(bill);
			sqlSession.commit();
			logger.debug(num);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	@Test
	public void getBillCountByProviderId(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Bill bill = new Bill();
		bill.setProviderId(14);
		try {
			int num = sqlSession.getMapper(BillMapper.class).getBillCountByProviderId(bill);
			logger.debug(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
