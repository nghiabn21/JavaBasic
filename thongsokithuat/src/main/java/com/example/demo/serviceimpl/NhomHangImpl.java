package com.example.demo.serviceimpl;

import com.example.demo.dto.NhomHangDto;
import com.example.demo.entity.NhomHang;
import com.example.demo.entity.ThongSoKiThuat;
import com.example.demo.responsitory.NhomHangRepo;
import com.example.demo.responsitory.ThongSoKiThuatRepo;
import com.example.demo.service.NhomHangSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhomHangImpl implements NhomHangSer {
    @Autowired
    NhomHangRepo nhomHangRepo;

    @Autowired
    ThongSoKiThuatRepo thongSoKiThuatRepo;


    @Override
    public Optional<NhomHang> save(NhomHang nhomHang) {
        try {
            return Optional.ofNullable(nhomHangRepo.save(nhomHang));
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<NhomHang> update(NhomHangDto nhomHangDto) {
        try {
            Optional<NhomHang> nhomHang = nhomHangRepo.findById(nhomHangDto.getId());
            if(!nhomHang.isPresent()) {
                return Optional.empty();
            }
            NhomHang nhomHang1 = nhomHang.get();
            nhomHang1.setMaNhomHang(nhomHangDto.getMaNhomHang());
            nhomHang1.setTenNhomHang(nhomHangDto.getTenNhomHang());
            nhomHang1.setXoa(nhomHangDto.getXoa());

            return Optional.ofNullable(nhomHangRepo.save(nhomHang1));
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Page<NhomHang> search(String maNhomhang,String tenNhomHang, Pageable pageable) {
       try {
           return nhomHangRepo.search(maNhomhang,tenNhomHang,pageable);
       }catch (Exception e) {
           return Page.empty();
       }
    }

    @Override
    public Page<NhomHang> findAll(Pageable pageable) {
        try {
            return nhomHangRepo.findAll(pageable);
        }catch (Exception e) {
            return Page.empty();
        }
    }

    @Override
    public Optional<NhomHang> findById(int id) {
       try {
           return nhomHangRepo.findById(id);
       }catch (Exception e) {
           return Optional.empty();
       }
    }

    @Override
    public Boolean delete(int id) {
        try {
            int rs = nhomHangRepo.delete(id);
            return nhomHangRepo.delete(id) >=0 ;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<NhomHang> findByIdNhomHang(Integer id) {
        try {
            Optional<NhomHang> nhomHang = nhomHangRepo.findById(id);
            if(!nhomHang.isPresent()) {
                return Optional.empty();
            }
            List<ThongSoKiThuat> thongSoKiThuats = thongSoKiThuatRepo.ThongsokithuatFindIdNhomHang(id);
            nhomHang.get().setThongSoKiThuatList(thongSoKiThuats);
            return nhomHang;
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}
