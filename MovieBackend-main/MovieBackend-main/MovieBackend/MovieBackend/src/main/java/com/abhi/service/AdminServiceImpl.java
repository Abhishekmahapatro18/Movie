package com.abhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.model.Admin;
import com.abhi.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public boolean AdminLogin(String emailId, String password) {
		try {
			List<Admin> allAdminData = adminRepository.findAll();

			for (Admin adminData : allAdminData) {
				if ((adminData.getEmailId()).equals(emailId)
						&& (adminData.getPassword()).equals(password)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
