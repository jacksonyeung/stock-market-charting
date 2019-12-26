package com.ms.sba.provider.user.dao;

import com.ms.sba.provider.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    public boolean existsByUsernameEquals(String username);

    public boolean existsByEmailEquals(String email);

    public User findByUsernameAndPassword(String username, String password);

}
