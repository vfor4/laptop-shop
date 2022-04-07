package com.laptopshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptopshop.entities.ChiTietDonHang;
import com.laptopshop.repository.ChiTietDonHangRepository;
import com.laptopshop.service.ChiTietDonHangService;

@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService{
	
	@Autowired
	private ChiTietDonHangRepository repo;
	
	@Override
	public List<ChiTietDonHang> save(List<ChiTietDonHang> list)
	{	
		if(Objects.isNull(list)){
			return new ArrayList<>();
		}
		return repo.saveAll(list);
	}
}
