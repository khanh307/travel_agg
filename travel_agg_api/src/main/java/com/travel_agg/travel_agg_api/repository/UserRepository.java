package com.travel_agg.travel_agg_api.repository;

import com.travel_agg.travel_agg_api.dto.ResponseDTO;
import com.travel_agg.travel_agg_api.dto.RoleDTO;
import com.travel_agg.travel_agg_api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
