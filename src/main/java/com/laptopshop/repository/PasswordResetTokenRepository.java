package com.laptopshop.repository;
import com.laptopshop.entities.PasswordResetToken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long>{
    PasswordResetToken findByToken(String token);
    
    @Transactional
    int deleteByToken(String token);
}
