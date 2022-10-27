package com.example.demo.service;

import com.example.demo.dto.ThongSoChiTietDto;
import com.example.demo.entity.ThongSoChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ThongSoChiTietSer {
    Optional<ThongSoChiTiet> save(ThongSoChiTiet thongSoChiTiet, int thongSoKiThuatId);
    Optional<ThongSoChiTiet> update(ThongSoChiTietDto thongSoChiTietDto, int thongSoKiThuatId);
    Optional<ThongSoChiTiet> findByid(int id);
    Page<ThongSoChiTiet> search(String ten, String giaTri , Pageable pageable);
    Page<ThongSoChiTiet> findAll(Pageable pageable);
    Boolean delete(int id);
}
