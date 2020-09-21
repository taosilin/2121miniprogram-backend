package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Admin;

public interface AdminService extends Service<Admin> {
    Admin adminLogin(String adminID);
}
