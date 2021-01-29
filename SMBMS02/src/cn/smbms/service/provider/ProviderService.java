package cn.smbms.service.provider;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Provider;

public interface ProviderService {


	/**
	 * ���ӹ�Ӧ��
	 * @param connection
	 * @param provider
	 * @return
	 * @throws Exception
	 */
	public int addProvider(Provider provider);


	/**
	 * ͨ����Ӧ�����ơ������ȡ��Ӧ���б�-ģ����ѯ-providerList
	 * @param connection
	 * @param proName
	 * @return
	 * @throws Exception
	 */
	public List<Provider> getProviderList(@Param("proName") String proName, @Param("proCode")String proCode);
	
	/**
	 * ͨ��proIdɾ��Provider
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteProviderById(Integer delId); 
	
	
	/**
	 * ͨ��proId��ȡProvider
	 * @param connection
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public  Provider getProviderById(@Param("id")int id); 
	
	/**
	 * �޸��û���Ϣ
	 * @param connection
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int modify(Provider provider);
	public List<Provider> getList();
	public List<Provider> getproName();
	
}
