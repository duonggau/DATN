package com.nckhntu.doantonghiep.Repository;

import com.nckhntu.doantonghiep.Entity.UserBuyPetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.sql.Timestamp;
=======
>>>>>>> e493c0935f66b5b5c6e645fd2628356d617c215c
import java.util.List;

@Repository
public interface UserBuyPetRepository extends JpaRepository<UserBuyPetEntity, Long> {
    @Query("select up from UserBuyPetEntity up where up.user.id = :userId")
    List<UserBuyPetEntity> findByUser_Id(@Param("userId") Long userId);

<<<<<<< HEAD
    @Query("SELECT u FROM UserBuyPetEntity u WHERE u.buyDate <= :reminderDate")
    List<UserBuyPetEntity> findCustomersToNotify(@Param("reminderDate") Timestamp reminderDate);
=======
>>>>>>> e493c0935f66b5b5c6e645fd2628356d617c215c
}
