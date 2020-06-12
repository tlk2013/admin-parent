package com.dwsoft.admin.service.impl;

import com.dwsoft.admin.entity.Admin;
import com.dwsoft.admin.entity.AdminExample;
import com.dwsoft.admin.mapper.AdminMapper;
import com.dwsoft.admin.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tlk
 * @date 2020/5/16-15:56
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    @Override
    public Admin getAdminByID(int i) {
        return adminMapper.selectByPrimaryKey(i);
    }

}
