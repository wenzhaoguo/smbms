package cn.smbms.service.role.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smbms.dao.role.RoleMapper;
import cn.smbms.pojo.Role;
import cn.smbms.service.role.RoleService;
@Service("RoleService")
public class RoleServiceImpl implements RoleService {
   @Autowired
   private RoleMapper roleMapper;
	@Override
	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return roleMapper.getRole();
	}

}
