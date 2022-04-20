package com.laptopshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.common.collect.Lists;
import com.laptopshop.dto.PasswordDTO;
import com.laptopshop.entities.DonHang;
import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.ResponseObject;
import com.laptopshop.service.DonHangService;
import com.laptopshop.service.NguoiDungService;
import com.laptopshop.service.PasswordResetTokenService;
import com.laptopshop.ulti.EmailUlti;

@Controller
// @SessionAttributes("loggedInUser")
@RequestMapping("/user")

public class ClientAccountController {

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private DonHangService donHangService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@ModelAttribute("loggedInUser")
	public NguoiDung loggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return nguoiDungService.findByEmail(auth.getName());
	}

	public NguoiDung getSessionUser(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return nguoiDungService.findByEmail(auth.getName());
	}

	@GetMapping("/account")
	public String accountPage(HttpServletRequest res, Model model) {
		NguoiDung currentUser = getSessionUser(res);
		model.addAttribute("user", currentUser);
		List<DonHang> list = Lists.reverse(donHangService.getDonHangByNguoiDung(currentUser));
		// System.out.println(" user: " + currentUser);
		
		model.addAttribute("list", list);
		return "client/account";
	}

	@GetMapping("/changeInformation")
	public String clientChangeInformationPage(HttpServletRequest res, Model model) {
		NguoiDung currentUser = getSessionUser(res);
		model.addAttribute("user", currentUser);
		return "client/information";
	}

	@GetMapping("/changePassword")
	public String clientChangePasswordPage() {
		return "client/passwordChange";
	}

	@PostMapping("/updateInfo")
	@ResponseBody
	public ResponseObject commitChange(HttpServletRequest res, @RequestBody NguoiDung ng) {
		ResponseObject resObj = new ResponseObject();
		NguoiDung currentUser = getSessionUser(res);
		if(Objects.isNull(ng) || (ng.getHoTen().equals(currentUser.getHoTen()) 
		&& ng.getDiaChi().equals(currentUser.getDiaChi())
		&& ng.getSoDienThoai().equals(currentUser.getSoDienThoai()))){
			resObj.setStatus("400");
			return resObj;
		}
		currentUser.setHoTen(ng.getHoTen());
		currentUser.setSoDienThoai(ng.getSoDienThoai());
		currentUser.setDiaChi(ng.getDiaChi());
		nguoiDungService.updateUser(currentUser);
		resObj.setStatus("200");
		return resObj;
	}

	@PostMapping("/updatePassword")
	@ResponseBody
	public ResponseObject passwordChange(HttpServletRequest res, @RequestBody PasswordDTO dto) {
		NguoiDung currentUser = getSessionUser(res);
		if (!passwordEncoder.matches(dto.getOldPassword(), currentUser.getPassword())) {
			ResponseObject re = new ResponseObject();
			re.setStatus("old");
			return re;
		}
		nguoiDungService.changePass(currentUser, dto.getNewPassword());
		return new ResponseObject();
	}

}
