package com.laptopshop.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.VaiTro;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long> {

	NguoiDung findByEmail(String email);

	Page<NguoiDung> findByVaiTro(Set<VaiTro> vaiTro, Pageable of);

	List<NguoiDung> findByVaiTro(Set<VaiTro> vaiTro);

	@Modifying
	@Query(value="update nguoi_dung u set u.is_locked = ?1 where u.id = ?2", nativeQuery = true)
	int setUserStatusByUserId(boolean isActive, long userId);
}
