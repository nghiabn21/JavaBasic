package com.example.demo.serviceimpl;

import com.example.demo.dto.ThongSoChiTietDto;
import com.example.demo.entity.ThongSoChiTiet;
import com.example.demo.entity.ThongSoKiThuat;
import com.example.demo.responsitory.ThongSoChiTietRepo;
import com.example.demo.responsitory.ThongSoKiThuatRepo;
import com.example.demo.service.ThongSoChiTietSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThongSoChiTietImpl implements ThongSoChiTietSer {
    @Autowired
    ThongSoChiTietRepo thongSoChiTietRepo;

    @Autowired
    ThongSoKiThuatRepo thongSoKiThuatRepo;


    @Override
    public Optional<ThongSoChiTiet> save(ThongSoChiTiet thongSoChiTiet, int thongSoKiThuatId) {
        try {
            Optional<ThongSoKiThuat> thongSoKiThuat = thongSoKiThuatRepo.findById(thongSoKiThuatId);
            if(!thongSoKiThuat.isPresent()) {
                return Optional.empty();
            }
            ThongSoChiTiet thongSoChiTiet1 = new ThongSoChiTiet();
            thongSoChiTiet1.setGiaTri(thongSoChiTiet.getGiaTri());
            thongSoChiTiet1.setTen(thongSoChiTiet.getTen());
            thongSoChiTiet1.setThongSoKiThuat(thongSoKiThuat.get());
            thongSoChiTiet1.setXoa(false);

            ThongSoChiTiet thongSoChiTiet2 = thongSoChiTietRepo.save(thongSoChiTiet1);
            return Optional.of(thongSoChiTiet2);

        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ThongSoChiTiet> update(ThongSoChiTietDto thongSoChiTietDto, int thongSoKiThuatId) {
        try {
            Optional<ThongSoChiTiet> thongSoChiTiet = thongSoChiTietRepo.findById(thongSoChiTietDto.getId());
            if(!thongSoChiTiet.isPresent()) {
                return Optional.empty();
            }
            Optional<ThongSoKiThuat> thongSoKiThuat =thongSoKiThuatRepo.findById(thongSoKiThuatId);
            if(!thongSoChiTiet.isPresent()) {
                return Optional.empty();
            }
            ThongSoChiTiet thongSoChiTiet1 = thongSoChiTiet.get();
            thongSoChiTiet1.setTen(thongSoChiTietDto.getTen());
            thongSoChiTiet1.setGiaTri(thongSoChiTietDto.getGiaTri());
            thongSoChiTiet1.setThongSoKiThuat(thongSoKiThuat.get());
            thongSoChiTiet1.setXoa(false);

            return Optional.ofNullable(thongSoChiTietRepo.save(thongSoChiTiet1));
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ThongSoChiTiet> findByid(int id) {
        try {
            return thongSoChiTietRepo.findById(id);
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Page<ThongSoChiTiet> search(String ten, String giaTri, Pageable pageable) {
        try {
            return thongSoChiTietRepo.search(ten,giaTri,pageable);
        }catch (Exception e) {
            return Page.empty();
        }
    }

    @Override
    public Page<ThongSoChiTiet> findAll(Pageable pageable) {
        try {
            return thongSoChiTietRepo.findAll(pageable);
        }catch (Exception e) {
            return Page.empty();
        }
    }

    @Override
    public Boolean delete(int id) {
       try {
           return thongSoChiTietRepo.delete(id) >= 0;
       }catch (Exception e) {
           return false;
       }
    }
}
