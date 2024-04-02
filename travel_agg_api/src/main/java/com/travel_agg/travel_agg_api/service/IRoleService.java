package com.travel_agg.travel_agg_api.service;

import com.travel_agg.travel_agg_api.dto.ResponseDTO;
import com.travel_agg.travel_agg_api.dto.RoleDTO;

import java.util.List;

public interface IRoleService {
    ResponseDTO<RoleDTO> save(RoleDTO roleDTO);

    ResponseDTO<List<RoleDTO>> findAll();
}
