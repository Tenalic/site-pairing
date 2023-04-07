package com.tenalic.site.service;

import javax.servlet.http.HttpSession;

public interface AdminService {

	String connectionAdmin(String nameAdmin, String paswwordAdmin);

	String verificationConnectionAdmin(HttpSession session);

}
