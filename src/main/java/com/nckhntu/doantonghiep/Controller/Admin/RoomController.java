package com.nckhntu.doantonghiep.Controller.Admin;

import com.nckhntu.doantonghiep.DTO.RoomDTO;
import com.nckhntu.doantonghiep.Entity.RoomEntity;
import com.nckhntu.doantonghiep.Entity.UserEntity;
import com.nckhntu.doantonghiep.Repository.RoomRepository;
import com.nckhntu.doantonghiep.Repository.UserRepository;
import com.nckhntu.doantonghiep.Service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/room")
public class RoomController {
    private final RoomService roomService;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public RoomController(RoomService roomService, UserRepository userRepository, RoomRepository roomRepository) {
        this.roomService = roomService;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public String room(Model model) {
        try {
            List<RoomDTO> dtoList = roomService.GetAllRoom();
            model.addAttribute("rooms", dtoList);
            return "Admin/Room/List_room";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "Admin/Room/List_room";
        }
    }


    @GetMapping("/action/user/{id}")
    public String actionRoomUser(@PathVariable Long id, Model model) {
        try {
            UserEntity userEntity = userRepository.findById(id).get();
            RoomEntity roomDTO = roomRepository.findByCustomer(userEntity.getId());
            model.addAttribute("room", roomDTO);
            return "redirect:/admin/room/user/"+roomDTO.getId();
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "Admin/Room/ChatRoom";
        }
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable Long id, Model model) {
        try {
            RoomDTO roomDTO = roomService.GetRoomById(id);
            model.addAttribute("room", roomDTO);
            return "Admin/Room/ChatRoom";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "Admin/Room/ChatRoom";
        }
    }
}
