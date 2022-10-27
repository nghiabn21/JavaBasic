package com.example.demo.serviceimpl;

import com.example.demo.dto.HangHoaThongSoDto;
import com.example.demo.entity.HangHoa;
import com.example.demo.entity.HangHoaThongSo;
import com.example.demo.entity.ThongSoChiTiet;
import com.example.demo.entity.ThongSoKiThuat;
import com.example.demo.responsitory.HangHoaRepo;
import com.example.demo.responsitory.HangHoaThongSoRepo;
import com.example.demo.responsitory.ThongSoChiTietRepo;
import com.example.demo.responsitory.ThongSoKiThuatRepo;
import com.example.demo.service.HangHoaThongSoSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HangHoaThongSoImpl implements HangHoaThongSoSer {
    @Autowired
    HangHoaThongSoRepo hangHoaThongSoRepo;

    @Autowired
    HangHoaRepo hangHoaRepo;

    @Autowired
    ThongSoChiTietRepo thongSoChiTietRepo;

    @Autowired
    ThongSoKiThuatRepo thongSoKiThuatRepo;


    @Override
    public Optional<HangHoaThongSo> save(HangHoaThongSo hangHoaThongSo, int hangHoaId, int thongSoChiTietId, int thongSoKiThuatId) {
        try {
            Optional<HangHoa> hangHoa = hangHoaRepo.findById(hangHoaId);
            if(!hangHoa.isPresent()) {
                return Optional.empty();
            }
            Optional<ThongSoChiTiet> thongSoChiTiet = thongSoChiTietRepo.findById(thongSoChiTietId);
            if (!thongSoChiTiet.isPresent()) {
                return Optional.empty();
            }
            Optional<ThongSoKiThuat> thongSoKiThuat = thongSoKiThuatRepo.findById(thongSoKiThuatId);
            if(!thongSoKiThuat.isPresent()) {
                return Optional.empty();
            }
            HangHoaThongSo hangHoaThongSo1 = new HangHoaThongSo();
            hangHoaThongSo1.setHangHoa(hangHoa.get());
            hangHoaThongSo1.setXoa(false);
            hangHoaThongSo1.setThongSoKiThuat(thongSoKiThuat.get());
            hangHoaThongSo1.setThongSoChiTiet(thongSoChiTiet.get());
            hangHoaThongSo1.setGiaTri(hangHoaThongSo.getGiaTri());

            HangHoaThongSo hangHoaThongSo2 = hangHoaThongSoRepo.save(hangHoaThongSo1);
            return  Optional.ofNullable(hangHoaThongSo2);
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<HangHoaThongSo> update(HangHoaThongSoDto hangHoaThongSoDto, int hangHoaId, int thongSoChiTietId, int thongSoKiThuatId) {
        try {
            Optional<HangHoaThongSo> hangHoaThongSo = hangHoaThongSoRepo.findByid(hangHoaThongSoDto.getId());
            if(!hangHoaThongSo.isPresent()) {
                return Optional.empty();
            }
            Optional<HangHoa> hangHoa = hangHoaRepo.findById(hangHoaId);
            if(!hangHoa.isPresent()) {
                return Optional.empty();
            }
            Optional<ThongSoChiTiet> thongSoChiTiet = thongSoChiTietRepo.findById(thongSoChiTietId);
            if (!thongSoChiTiet.isPresent()) {
                return Optional.empty();
            }
            Optional<ThongSoKiThuat> thongSoKiThuat = thongSoKiThuatRepo.findById(thongSoKiThuatId);
            if(!thongSoKiThuat.isPresent()) {
                return Optional.empty();
            }
            HangHoaThongSo hangHoaThongSo1 = hangHoaThongSo.get();
            hangHoaThongSo1.setHangHoa(hangHoa.get());
            hangHoaThongSo1.setXoa(false);
            hangHoaThongSo1.setThongSoKiThuat(thongSoKiThuat.get());
            hangHoaThongSo1.setThongSoChiTiet(thongSoChiTiet.get());
            hangHoaThongSo1.setGiaTri(hangHoaThongSoDto.getGiaTri());

            return  Optional.ofNullable(hangHoaThongSoRepo.save(hangHoaThongSo1));
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<HangHoaThongSo> findById(int id) {
      try {
          return hangHoaThongSoRepo.findById(id);
      }catch (Exception e) {
          return Optional.empty();
      }
    }

    @Override
    public Page<HangHoaThongSo> search(String giaTri, Pageable pageable) {
       try {
           return hangHoaThongSoRepo.search(giaTri,pageable);
       }catch (Exception e) {
           return Page.empty();
       }
    }

    @Override
    public Page<HangHoaThongSo> findAll(Pageable pageable) {
        try {
            return hangHoaThongSoRepo.findAll(pageable);
        }catch (Exception e) {
            return Page.empty();
        }
    }

    @Override
    public Boolean delete(int id) {
       try {
           return hangHoaThongSoRepo.delete(id) >=0 ;

       }catch (Exception e) {
           return false;
       }
    }
}
