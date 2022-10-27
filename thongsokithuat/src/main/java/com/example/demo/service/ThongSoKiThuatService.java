package com.example.demo.service;

import com.example.demo.dto.ThongSoChiTietDto;
import com.example.demo.dto.ThongSoKiThuatDto;
import com.example.demo.entity.ThongSoKiThuat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ThongSoKiThuatService {
    Optional<ThongSoKiThuat> save(ThongSoKiThuat thongSoKiThuat, int nhomHangId, int nhomThongSoId);
    Optional<ThongSoKiThuat> update(ThongSoKiThuatDto thongSoKiThuatDto, int nhomHangId, int nhomThongSoId);
    Optional<ThongSoKiThuat> findById(int id);
    Page<ThongSoKiThuat> search(String tenThongSo, Pageable pageable);
    Page<ThongSoKiThuat> findAll(Pageable pageable);
    Boolean delete(int id);

    List<ThongSoKiThuat> ThongsokithuatFindIdNhomHang(Integer id);
}
