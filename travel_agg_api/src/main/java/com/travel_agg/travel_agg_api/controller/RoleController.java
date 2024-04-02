package com.travel_agg.travel_agg_api.controller;

import com.travel_agg.travel_agg_api.dto.ResponseDTO;
import com.travel_agg.travel_agg_api.dto.RoleDTO;
import com.travel_agg.travel_agg_api.service.IRoleService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    IRoleService roleService;

    @PostMapping(value = "/update")
    public ResponseDTO<RoleDTO> updateRole(@RequestBody RoleDTO roleDTO) {
        return roleService.save(roleDTO);
    }

    @GetMapping(value = "/get")
    public ResponseDTO<List<RoleDTO>> getRoles() {
        return roleService.findAll();
    }
}
