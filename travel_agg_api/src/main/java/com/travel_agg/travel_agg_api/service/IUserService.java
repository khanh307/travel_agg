package com.travel_agg.travel_agg_api.service;


import com.travel_agg.travel_agg_api.dto.ResponseDTO;
import com.travel_agg.travel_agg_api.dto.UserDTO;
import com.travel_agg.travel_agg_api.entity.UserEntity;

public interface IUserService {
    ResponseDTO<UserDTO> findUserById(String id);

    ResponseDTO<UserDTO> save(UserEntity userDTO);

//    ResponseDTO<String> changePassword(UserEntity userEntity);
}
