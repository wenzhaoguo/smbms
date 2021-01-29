package cn.smbms.service.provider.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smbms.dao.provider.ProviderMapper;
import cn.smbms.pojo.Provider;
import cn.smbms.service.provider.ProviderService;
@Service("ProviderService")
public class ProviderServiceImpl implements ProviderService {
	@Autowired
	private ProviderMapper providerMapper;
	@Override
	public int addProvider(Provider provider) {
		// TODO Auto-generated method stub
		return providerMapper.addProvider(provider);
	}

	@Override
	public List<Provider> getProviderList(String proName, String proCode) {
		// TODO Auto-generated method stub
		return providerMapper.getProviderList(proName, proCode);
	}

	@Override
	public int deleteProviderById(Integer delId) {
		// TODO Auto-generated method stub
		return providerMapper.deleteProviderById(delId);
	}

	@Override
	public Provider getProviderById(int id) {
		// TODO Auto-generated method stub
		return providerMapper.getProviderById(id);
	}

	@Override
	public int modify(Provider provider) {
		// TODO Auto-generated method stub
		return providerMapper.modify(provider);
	}

	@Override
	public List<Provider> getList() {
		// TODO Auto-generated method stub
		return providerMapper.getList();
	}

	@Override
	public List<Provider> getproName() {
		// TODO Auto-generated method stub
		return providerMapper.getproName();
	}



}
