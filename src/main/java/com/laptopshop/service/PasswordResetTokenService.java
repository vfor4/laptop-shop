package com.laptopshop.service;

import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.PasswordResetToken;

public interface PasswordResetTokenService {
    public void createPasswordResetTokenForUser(NguoiDung user, String token);
    public String validatePasswordResetToken(String token);
    public PasswordResetToken testRepo(long id);
    public NguoiDung getByResetPasswordToken(String token);
    public void deletePasswordResetToken(String token);
}
