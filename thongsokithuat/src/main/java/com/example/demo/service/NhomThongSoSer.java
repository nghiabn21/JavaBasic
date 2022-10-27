package com.example.demo.service;

import com.example.demo.dto.NhomThongSoDto;
import com.example.demo.entity.NhomThongSo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public interface NhomThongSoSer {
    Optional<NhomThongSo> save(NhomThongSo nhomThongSo, int hangHoaId );
    Optional<NhomThongSo> update(NhomThongSoDto nhomThongSoDto, int hangHoaId);
    Optional<NhomThongSo> findById(int id);
    Page<NhomThongSo> search(String maNhomThongSo, String tenNhomThongSo, Pageable pageable);
    Page<NhomThongSo> findAll(Pageable pageable);
    Boolean delete(int id);

}
