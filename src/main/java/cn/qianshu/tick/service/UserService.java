package cn.qianshu.tick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qianshu.tick.entity.User1;
import cn.qianshu.tick.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User1 findUser(String username,String password) {
		return userRepository.findByUserNameAndPassword(username,password);
	}

}
