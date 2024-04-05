package com.travel_agg.travel_agg_api.service.impl;

import com.travel_agg.travel_agg_api.dto.ResponseDTO;
import com.travel_agg.travel_agg_api.dto.UserDTO;
import com.travel_agg.travel_agg_api.entity.RoleEntity;
import com.travel_agg.travel_agg_api.entity.UserEntity;
import com.travel_agg.travel_agg_api.repository.RoleRepository;
import com.travel_agg.travel_agg_api.repository.UserRepository;
import com.travel_agg.travel_agg_api.service.IUserService;
import com.travel_agg.travel_agg_api.utils.PasswordHashing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public ResponseDTO<UserDTO> findUserById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            Optional<UserEntity> entity = userRepository.findById(uuid);
            return entity.map(userEntity -> ResponseDTO.ok(null,
                    mapper.map(userEntity, UserDTO.class))).orElseGet(() -> ResponseDTO.notFound("Người dùng không tồn tại"));
        } catch (IllegalArgumentException e) {
            return ResponseDTO.notFound("Người dùng không tồn tại");
        }
    }

    @Override
    public ResponseDTO<UserDTO> save(UserEntity userDTO) {

        try {
            if (userDTO.getUsername() == null || userDTO.getUsername().isEmpty()
                    || userDTO.getPassword() == null || userDTO.getPassword().isEmpty()
                    || userDTO.getFullName() == null || userDTO.getFullName().isEmpty()
                    || userDTO.getBirthday() == null) {
                return ResponseDTO.notEnoughInformation();
            }
            userDTO.setPassword(PasswordHashing.hashPassword(userDTO.getPassword()));
            UserEntity entity = mapper.map(userDTO, UserEntity.class);

            entity.setStatus(true);
            userRepository.save(entity);
            return ResponseDTO.ok("Đăng ký thành công", mapper.map(entity, UserDTO.class));
        } catch (IllegalArgumentException e) {
            return ResponseDTO.notFound("Người dùng không tồn tại");
        }
    }




}
