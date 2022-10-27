package com.example.demo.serviceimpl;

import com.example.demo.dto.NhomThongSoDto;
import com.example.demo.entity.HangHoa;
import com.example.demo.entity.NhomThongSo;
import com.example.demo.responsitory.HangHoaRepo;
import com.example.demo.responsitory.NhomHangRepo;
import com.example.demo.responsitory.NhomThongSoRepo;
import com.example.demo.service.NhomThongSoSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NhomThongSoImpl implements NhomThongSoSer {
    @Autowired
    NhomThongSoRepo nhomThongSoRepo;

    @Autowired
    HangHoaRepo hangHoaRepo;


    @Override
    public Optional<NhomThongSo> save(NhomThongSo nhomThongSo, int hangHoaId) {
        try {
            Optional<HangHoa> hangHoa =hangHoaRepo.findById(hangHoaId);
            if(!hangHoa.isPresent()) {
             return Optional.empty();
            }
            NhomThongSo nhomThongSo1 = new NhomThongSo();
            nhomThongSo1.setMaNhomThongSo(nhomThongSo.getMaNhomThongSo());
            nhomThongSo1.setTenNhomThongSo(nhomThongSo.getTenNhomThongSo());
            nhomThongSo1.setHangHoa(hangHoa.get());
            nhomThongSo1.setXoa(false);

            NhomThongSo nhomThongSo2 = nhomThongSoRepo.save(nhomThongSo1);
            return Optional.ofNullable(nhomThongSo2);

        }catch (Exception e) {
        return Optional.empty();
         }
    }

    @Override
    public Optional<NhomThongSo> update(NhomThongSoDto nhomThongSoDto, int hangHoaId) {
        try {
            Optional<NhomThongSo> nhomThongSo =nhomThongSoRepo.findById(nhomThongSoDto.getId());
            if (!nhomThongSo.isPresent()) {
                return Optional.empty();
            }
            Optional<HangHoa> hangHoa = hangHoaRepo.findById(hangHoaId);
            if (!hangHoa.isPresent()) {
                return Optional.empty();
            }
            NhomThongSo nhomThongSo1 =nhomThongSo.get();
            nhomThongSo1.setMaNhomThongSo(nhomThongSoDto.getMaNhomThongSo());
            nhomThongSo1.setTenNhomThongSo(nhomThongSoDto.getTenNhomThongSo());
            nhomThongSo1.setHangHoa(hangHoa.get());
            nhomThongSo1.setXoa(false);

            return Optional.ofNullable(nhomThongSoRepo.save(nhomThongSo1));
            }catch (Exception e) {
            return Optional.empty();
        }
    }


    @Override
    public Optional<NhomThongSo> findById(int id) {
       try {
           return nhomThongSoRepo.findById(id);
       }catch (Exception e) {
       return Optional.empty();
       }
    }

    @Override
    public Page<NhomThongSo> search(String maNhomThongSo, String tenNhomThongSo, Pageable pageable) {
        try {
            return nhomThongSoRepo.search(maNhomThongSo,tenNhomThongSo,pageable);
        }catch (Exception e) {
            return Page.empty();
        }
    }

    @Override
    public Page<NhomThongSo> findAll(Pageable pageable) {
       try {
           return nhomThongSoRepo.findAll(pageable);
       }catch (Exception e) {
           return Page.empty();
       }
    }

    @Override
    public Boolean delete(int id) {
       try {
           return nhomThongSoRepo.delete(id) >= 0;
       }catch (Exception e) {
           return false;
       }
    }
}
