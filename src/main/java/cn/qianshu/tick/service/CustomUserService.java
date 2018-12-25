package cn.qianshu.tick.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.qianshu.tick.entity.Role1;
import cn.qianshu.tick.entity.User1;
import cn.qianshu.tick.repository.UserRepository;


public class CustomUserService implements UserDetailsService {
	
	protected Log log = LogFactory.getLog(getClass());
	
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User1 user = userRepository.findByUsername(s);
        log.info("登录用户"+s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        
        log.info("登录用户user:" + user.getUsername());
        
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        List<Role1> roles = user.getRoles();
        if(roles != null)
        {
            for (Role1 role : roles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }
        log.info("登录用户fdsakjfks");
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }

}
