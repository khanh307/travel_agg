package com.travel_agg.travel_agg_api.repository;

import com.travel_agg.travel_agg_api.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
}
