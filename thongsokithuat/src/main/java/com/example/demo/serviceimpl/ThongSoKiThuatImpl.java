package com.example.demo.serviceimpl;

import com.example.demo.dto.ThongSoKiThuatDto;
import com.example.demo.entity.NhomHang;
import com.example.demo.entity.NhomThongSo;
import com.example.demo.entity.ThongSoKiThuat;
import com.example.demo.responsitory.NhomHangRepo;
import com.example.demo.responsitory.NhomThongSoRepo;
import com.example.demo.responsitory.ThongSoKiThuatRepo;
import com.example.demo.service.ThongSoKiThuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ThongSoKiThuatImpl implements ThongSoKiThuatService {
    @Autowired
    NhomHangRepo nhomHangRepo;

    @Autowired
    NhomThongSoRepo nhomThongSoRepo;

    @Autowired
    ThongSoKiThuatRepo thongSoKiThuatRepo;


    @Override
    public Optional<ThongSoKiThuat> save(ThongSoKiThuat thongSoKiThuat, int nhomHangId, int nhomThongSoId) {
        try {
            Optional<NhomHang> nhomHang = nhomHangRepo.findById(nhomHangId);
            if (!nhomHang.isPresent()) {
                return Optional.empty();
            }
            Optional<NhomThongSo> nhomThongSo = nhomThongSoRepo.findById(nhomThongSoId);
            if (!nhomThongSo.isPresent()) {
                return Optional.empty();
            }
            ThongSoKiThuat thongSoKiThuat1 = new ThongSoKiThuat();
            thongSoKiThuat1.setTenThongSo(thongSoKiThuat.getTenThongSo());
            thongSoKiThuat1.setXoa(false);
            thongSoKiThuat1.setNhomThongSo(nhomThongSo.get());
            thongSoKiThuat1.setNhomHang(nhomHang.get());

            ThongSoKiThuat thongSoKiThuat2 = thongSoKiThuatRepo.save(thongSoKiThuat1);
            return Optional.ofNullable(thongSoKiThuat2);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ThongSoKiThuat> update(ThongSoKiThuatDto thongSoKiThuatDto, int nhomHangId, int nhomThongSoId) {
        try {
            Optional<ThongSoKiThuat> thongSoKiThuat = thongSoKiThuatRepo.findById(thongSoKiThuatDto.getId());
            if (!thongSoKiThuat.isPresent()) {
                return Optional.empty();
            }
            Optional<NhomHang> nhomHang = nhomHangRepo.findById(nhomHangId);
            if (!nhomHang.isPresent()) {
                return Optional.empty();
            }
            Optional<NhomThongSo> nhomThongSo = nhomThongSoRepo.findById(nhomThongSoId);
            if (!nhomThongSo.isPresent()) {
                return Optional.empty();
            }
            ThongSoKiThuat thongSoKiThuat1 = thongSoKiThuat.get();
            thongSoKiThuat1.setTenThongSo(thongSoKiThuatDto.getTenThongSo());
            thongSoKiThuat1.setXoa(false);
            thongSoKiThuat1.setNhomThongSo(nhomThongSo.get());
            thongSoKiThuat1.setNhomHang(nhomHang.get());

            return Optional.ofNullable(thongSoKiThuatRepo.save(thongSoKiThuat1));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ThongSoKiThuat> findById(int id) {
        try {
            return thongSoKiThuatRepo.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Page<ThongSoKiThuat> search(String tenThongSo, Pageable pageable) {
        try {
            return thongSoKiThuatRepo.search(tenThongSo, pageable);
        } catch (Exception e) {
            return Page.empty();
        }
    }

    @Override
    public Page<ThongSoKiThuat> findAll(Pageable pageable) {
        try {
            return thongSoKiThuatRepo.findAll(pageable);
        } catch (Exception e) {
            return Page.empty();
        }
    }

    @Override
    public Boolean delete(int id) {
        try {
            return thongSoKiThuatRepo.delete(id) >= 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<ThongSoKiThuat> ThongsokithuatFindIdNhomHang(Integer id) {
        try {
            return thongSoKiThuatRepo.ThongsokithuatFindIdNhomHang(id);

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
