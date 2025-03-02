package com.nckhntu.doantonghiep.Service;

import com.nckhntu.doantonghiep.DTO.UserBuyPetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserByPetService {
    Page<UserBuyPetDTO> getAllUserBuyPet(Pageable pageable);
    List<UserBuyPetDTO> getAllUserBuyPetByUser();
    List<UserBuyPetDTO> getAllUserBuyPetByUserId( Long userId);
    UserBuyPetDTO getUserBuyPetById(Long id);
    void addPetForUser(UserBuyPetDTO userBuyPetDTO);
    void updatePetForUser(UserBuyPetDTO userBuyPetDTO);
    void deleteUserBuyPet(UserBuyPetDTO userBuyPetDTO);
<<<<<<< HEAD
    void sendReminders();

=======
>>>>>>> e493c0935f66b5b5c6e645fd2628356d617c215c
}
