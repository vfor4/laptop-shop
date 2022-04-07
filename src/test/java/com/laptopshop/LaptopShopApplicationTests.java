package com.laptopshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import io.jsonwebtoken.lang.Objects;
// import javafx.application.Application;

import com.google.gson.Gson;
import com.laptopshop.dto.SearchDonHangObject;
import com.laptopshop.entities.DonHang;
import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.VaiTro;
import com.laptopshop.models.ErrorResponse;
import com.laptopshop.models.Item;
import com.laptopshop.models.OrderRequest;
import com.laptopshop.models.TopSanPham;
import com.laptopshop.repository.ChiMucGioHangRepository;
import com.laptopshop.repository.DonHangRepository;
import com.laptopshop.repository.GioHangRepository;
import com.laptopshop.repository.NguoiDungRepository;
import com.laptopshop.repository.PasswordResetTokenRepository;
import com.laptopshop.repository.SanPhamRepository;
import com.laptopshop.service.DanhMucService;
import com.laptopshop.service.DonHangService;
import com.laptopshop.service.NguoiDungService;
import com.laptopshop.service.OrderService;
import com.laptopshop.service.PasswordResetTokenService;
import com.laptopshop.service.SanPhamService;
import com.laptopshop.service.VaiTroService;
import com.laptopshop.ulti.RSAUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaptopShopApplicationTests {

	@Autowired
	private DonHangService donHangService;

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private VaiTroService vaiTroService;

	@Test
	public void test2() {
		Set<VaiTro> vaiTro = new HashSet<>();
		vaiTro.add(vaiTroService.findByTenVaiTro("ROLE_MEMBER"));

		for(NguoiDung nd : nguoiDungService.getNguoiDungByVaiTro(vaiTro, 1).getContent()){
			System.out.println("user: " + nd.toString());
		}

	}

	boolean isValid(final String password) {
		final String PASSWORD_PATTERN = "(0[3|5|7|8|9])+([0-9]{8})";
		final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
	
	

	// @Test
	public void givenArrayList_whenAddingElement_addsNewElement() {
		System.out.println("valid: " + isValid("0369680567"));
	}

	// @Test(expected = UnsupportedOperationException.class)
	public void givenCollectionsEmptyList_whenAdding_throwsException() {
		List<String> immutableList = Collections.emptyList();
		immutableList.add("test");
	}
}
