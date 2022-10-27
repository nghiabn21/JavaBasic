package com.example.demo.service;

import com.example.demo.dto.HangHoaThongSoDto;
import com.example.demo.entity.HangHoaThongSo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface HangHoaThongSoSer {
    Optional<HangHoaThongSo> save(HangHoaThongSo hangHoaThongSo, int hangHoaId, int thongSoChiTietId, int thongSoKiThuatId);
    Optional<HangHoaThongSo> update(HangHoaThongSoDto hangHoaThongSoDto, int hangHoaId, int thongSoChiTietId, int thongSoKiThuatId);
    Optional<HangHoaThongSo> findById(int id);
    Page<HangHoaThongSo> search(String giaTri, Pageable pageable);
    Page<HangHoaThongSo> findAll(Pageable pageable);
    Boolean delete(int id);
}
