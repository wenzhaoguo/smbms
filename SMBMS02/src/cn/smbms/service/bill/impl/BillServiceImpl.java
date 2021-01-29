package cn.smbms.service.bill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smbms.dao.bill.BillMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.service.bill.BillService;

@Service("BillService")
public class BillServiceImpl implements BillService {
	@Autowired
	private BillMapper billMapper;
	@Override
	public int add(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.add(bill);
	}

	@Override
	public List<Bill> getBillList(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.getBillList(bill);
	}

	@Override
	public int deleteBillById(int delId) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.deleteBillById(delId);
	}

	@Override
	public Bill getBillById(int id) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.getBillById(id);
	}

	@Override
	public int modify(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.modify(bill);
	}

	@Override
	public int getBillCountByProviderId(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.getBillCountByProviderId(bill);
	}

	@Override
	public List<Bill> getBillList2() {
		// TODO Auto-generated method stub
		return billMapper.getBillList2();
	}

}
