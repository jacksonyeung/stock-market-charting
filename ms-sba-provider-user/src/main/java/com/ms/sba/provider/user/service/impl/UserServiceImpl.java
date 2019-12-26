package com.ms.sba.provider.user.service.impl;

import com.ms.sba.provider.user.dao.UserRepository;
import com.ms.sba.provider.user.dto.RequestResult;
import com.ms.sba.provider.user.entity.User;
import com.ms.sba.provider.user.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RequestResult addUser(User user) {
        RequestResult requestResult = new RequestResult();

        boolean usernameExisted = userRepository.existsByUsernameEquals(user.getUsername());
        if (usernameExisted) {
            requestResult.setCode(RequestResult.CONFLICT_USERNAME);
        }else {
            boolean emailExisted = userRepository.existsByEmailEquals(user.getEmail());
            if (emailExisted) {
                requestResult.setCode(RequestResult.CONFLICT_EMAIL);
            }else {
                userRepository.save(user);
                requestResult.setCode(RequestResult.SUCCESS);
            }
        }

        return requestResult;
    }

    @Override
    public RequestResult validateUser(User user) {
        RequestResult requestResult = new RequestResult();
        User targetUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (targetUser != null) {
            requestResult.setCode(RequestResult.SUCCESS);
            requestResult.setData(targetUser);
        }else {
            requestResult.setCode(RequestResult.UNAUTHORIZED);
        }

        return requestResult;
    }

}
