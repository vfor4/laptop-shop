package com.laptopshop.service.impl;

import java.util.Calendar;

import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.PasswordResetToken;
import com.laptopshop.repository.PasswordResetTokenRepository;
import com.laptopshop.service.PasswordResetTokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService{

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public void createPasswordResetTokenForUser(NguoiDung user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(user, token);
        passwordResetTokenRepository.save(myToken);        
    }

    @Override
    public PasswordResetToken testRepo(long id){
        return passwordResetTokenRepository.findById(id).get();
    }

    @Override
    public String validatePasswordResetToken(String token) {
        if(token == null || token.isEmpty()) return "invalidToken"; 
        final PasswordResetToken passToken = passwordResetTokenRepository.findByToken(token);

        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                : null;
    }

    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(PasswordResetToken passToken) {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }

    @Override
    public NguoiDung getByResetPasswordToken(String token) {
        if(token == null || token.isEmpty()) {
            return null;
        }
        return passwordResetTokenRepository.findByToken(token).getUser();
    }

    @Override
    public void deletePasswordResetToken(String token) throws RuntimeException{
        if(token == null || token.isEmpty()){
            throw new RuntimeException("token is not present");
        }
        passwordResetTokenRepository.deleteByToken(token);
    }

    
    
    
}
