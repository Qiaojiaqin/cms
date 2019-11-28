package com.briup.cms.service.impl;

import com.briup.cms.bean.Customer;
import com.briup.cms.dao.ICustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private ICustomerDao customerDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerDao.queryByUsername(username);
        if(customer == null) {
            throw new UsernameNotFoundException("用户名错误");
        }
        return new User(customer.getUsername(),passwordEncoder.encode(customer.getPassword()), AuthorityUtils.createAuthorityList("admin"));
    }
}
