package com.example.demo.responsitory;

import com.example.demo.entity.NhomHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface NhomHangRepo extends JpaRepository<NhomHang,Integer> {
    @Query(value = "from NhomHang nh where nh.xoa = false ")
    Page<NhomHang> findAll(Pageable pageable);

    @Query(value = "from NhomHang nh where (?1 is null or nh.maNhomHang = ?1) " +
            "and (?2 is null or nh.tenNhomHang =?2) " +
            "and nh.xoa =false ")
    Page<NhomHang> search(String maNhomhang, String tenNhomHang, Pageable pageable);

    @Query(value = "from NhomHang nh where nh.xoa = false and nh.id = ?1")
    Optional<NhomHang> findById(int id);

    @Modifying
    @Transactional
    @Query(value = "update NhomHang nh set nh.xoa = true where nh.id = ?1")
    Integer delete(int id);

}
