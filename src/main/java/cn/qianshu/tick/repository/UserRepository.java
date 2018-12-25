package cn.qianshu.tick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.qianshu.tick.entity.User1;

@Repository
public interface UserRepository extends JpaRepository<User1, Integer>,JpaSpecificationExecutor<User1> {

	@Query("select u from User1 u where u.username =:username and u.password =:password")
	User1 findByUserNameAndPassword(@Param("username")String username,@Param("password") String password);

}
