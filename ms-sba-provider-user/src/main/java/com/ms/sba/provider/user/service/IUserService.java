package com.ms.sba.provider.user.service;

import com.ms.sba.provider.user.dto.RequestResult;
import com.ms.sba.provider.user.entity.User;

public interface IUserService {

    public RequestResult addUser(User user);

    public RequestResult validateUser(User user);

}
