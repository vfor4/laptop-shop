package com.laptopshop.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


import com.laptopshop.entities.SanPham;
import com.laptopshop.models.TopSanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, Long>, QuerydslPredicateExecutor<SanPham>{

	
	List<SanPham> findFirst12ByDanhMucTenDanhMucContainingIgnoreCaseOrderByIdDesc(String dm);
	
	List<SanPham> findByIdIn(Set<Long> idList);
	
	@Query(nativeQuery = true, value = "select distinct sp.ten_san_pham as tenSanPham, "
	+" sum(ctdh.so_luong_nhan_hang) as soLuong " 
	+" from san_pham sp "
	+" inner join chi_tiet_don_hang ctdh " 
	+" on ctdh.ma_san_pham = sp.id "
	+" inner join don_hang dh "
	+" on ctdh.ma_don_hang = dh.id " 
	+" and ctdh.so_luong_nhan_hang > 0 "
	+" and DATE_FORMAT(dh.ngay_nhan_hang , '%m') = ?1 "
	+" group by sp.ten_san_pham "
	+" order by so_luong desc "
	+" limit 5 " )
	List<TopSanPham> findTop5BestSellersByMonth(int month);

	// @Query(nativeQuery = true, value = "select 'abc' as tenSanPham, 2 from chi_tiet_don_hang ct where ct.ma_san_pham = ?")
}
