package com.laptopshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import com.laptopshop.entities.GioHang;
import com.laptopshop.entities.NguoiDung;
import com.laptopshop.repository.GioHangRepository;
import com.laptopshop.service.GioHangService;

@Service
public class GioHangServiceImpl implements GioHangService{
	
	@Autowired
	private GioHangRepository repo;
	
	@Override
	public GioHang getGioHangByNguoiDung(NguoiDung n)
	{
		if(Objects.isNull(n)){
			return null;
		}
		return repo.findByNguoiDung(n);
		
	}
	
	@Override
	public GioHang save(GioHang g)
	{
		return repo.save(g);
	}

}
