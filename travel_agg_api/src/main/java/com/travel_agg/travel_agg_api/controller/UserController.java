package com.travel_agg.travel_agg_api.controller;

import com.travel_agg.travel_agg_api.dto.ResponseDTO;
import com.travel_agg.travel_agg_api.dto.UserDTO;
import com.travel_agg.travel_agg_api.entity.UserEntity;
import com.travel_agg.travel_agg_api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping(value = "/get-by-id/{id}")
    public ResponseDTO<UserDTO> getUserByID(@PathVariable(name = "id") String id) {
        return userService.findUserById(id);
    }

    @PostMapping(value = "/update")
    public ResponseDTO<UserDTO> updateUser(@RequestBody UserEntity userDTO) {
        return userService.save(userDTO);
    }
}
