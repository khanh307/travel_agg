package com.travel_agg.travel_agg_api.service.impl;

import com.travel_agg.travel_agg_api.dto.ResponseDTO;
import com.travel_agg.travel_agg_api.dto.RoleDTO;
import com.travel_agg.travel_agg_api.entity.RoleEntity;
import com.travel_agg.travel_agg_api.repository.RoleRepository;
import com.travel_agg.travel_agg_api.service.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public ResponseDTO<RoleDTO> save(RoleDTO roleDTO) {
        RoleEntity roleEntity;
        try {
            if (roleDTO.getName() == null || roleDTO.getName().isEmpty()) {
                return ResponseDTO.notEnoughInformation(
                );
            }

            if (roleDTO.getId() != null) {
                Optional<RoleEntity> entity = roleRepository.findById(roleDTO.getId());
                if (entity.isEmpty()) {
                    return ResponseDTO.notFound(
                            "Quyền không tồn tại"
                    );
                }
            }
            roleEntity = mapper.map(roleDTO, RoleEntity.class);
            roleEntity = roleRepository.save(roleEntity);
            return ResponseDTO.ok(
                    (roleDTO.getId() == null) ? "Tạo mới thành công" : "Cập nhật thành công",
                    mapper.map(roleEntity, RoleDTO.class)
            );
        } catch (Exception e) {
            return ResponseDTO.badRequest(
                    "Lỗi không xác định"
            );
        }
    }

    @Override
    public ResponseDTO<List<RoleDTO>> findAll() {
        try {
            List<RoleEntity> roles = roleRepository.findAll();

            List<RoleDTO> result = new ArrayList<>();

            for (RoleEntity entity : roles) {
                result.add(mapper.map(entity, RoleDTO.class));
            }
            return ResponseDTO.ok(
                    null,
                    result
            );
        } catch (Exception e) {
            return ResponseDTO.badRequest(
                    "Lỗi không xác định"
            );
        }

    }
}
