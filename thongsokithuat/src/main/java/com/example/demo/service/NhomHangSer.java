package com.example.demo.service;

import com.example.demo.dto.NhomHangDto;
import com.example.demo.entity.NhomHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface NhomHangSer {
    Optional<NhomHang> save(NhomHang nhomHang);
    Optional<NhomHang> update(NhomHangDto nhomHangDto);
    Page<NhomHang> search(String maNhomhang,String tenNhomHang,Pageable pageable);
    Page<NhomHang> findAll(Pageable pageable);
    Optional<NhomHang> findById(int id);
    Boolean delete(int id);

    Optional<NhomHang> findByIdNhomHang(Integer id);

}
