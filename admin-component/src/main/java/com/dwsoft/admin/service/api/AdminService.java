package com.dwsoft.admin.service.api;

import com.dwsoft.admin.entity.Admin;

import java.util.List;

/**
 * @author tlk
 * @date 2020/5/16-15:53
 */
public interface AdminService {
    void saveAdmin(Admin admin);
    List<Admin> getAll();

    Admin getAdminByID(int i);
}
