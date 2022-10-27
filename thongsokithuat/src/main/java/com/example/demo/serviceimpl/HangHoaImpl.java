package com.example.demo.serviceimpl;

import com.example.demo.dto.HangHoaDto;
import com.example.demo.entity.HangHoa;
import com.example.demo.entity.HangHoaThongSo;
import com.example.demo.entity.NhomHang;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.createRequest.Request;
import com.example.demo.response.MyResponse;
import com.example.demo.responsitory.HangHoaRepo;
import com.example.demo.responsitory.NhomHangRepo;
import com.example.demo.responsitory.ThuongHieuRepo;
import com.example.demo.service.HangHoaSer;
import org.hibernate.hql.internal.HolderInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HangHoaImpl implements HangHoaSer {
    @Autowired
    HangHoaRepo hangHoaRepo ;

    @Autowired
    NhomHangRepo nhomHangrepo;

    @Autowired
    ThuongHieuRepo thuongHieuRepo;

    @Override
    public Optional<HangHoa> save(HangHoa hanghoa, int nhomHangId, int thuongHieuId) {
        MyResponse response = new MyResponse();
     Optional<NhomHang> nhomHang = nhomHangrepo.findById(nhomHangId);
     if( !nhomHang.isPresent()) {
          response.setResult(-1, "nhóm hàng không tồn tại");
          return Optional.empty();
     }

     Optional<ThuongHieu> thuongHieu =thuongHieuRepo.findById(thuongHieuId);
     if(!thuongHieu.isPresent()) {
       response.setResult(-1,"thương hiệu không tồn tại");
       return Optional.empty();
     }
     HangHoa hanghoa1 = new HangHoa();
     hanghoa1.setMa(hanghoa.getMa());
     hanghoa1.setMaGiamGia(hanghoa.getMaGiamGia());
     hanghoa1.setMoTa(hanghoa.getMoTa());
     hanghoa1.setPhanTramGiamGia(hanghoa.getPhanTramGiamGia());
     hanghoa1.setTenHangHoa(hanghoa.getTenHangHoa());
     hanghoa1.setTichDiem(hanghoa.getTichDiem());
     hanghoa1.setUrlHinhAnh1(hanghoa.getUrlHinhAnh1());
     hanghoa1.setUrlHinhAnh2(hanghoa.getUrlHinhAnh2());
     hanghoa1.setUrlHinhAnh3(hanghoa.getUrlHinhAnh3());
     hanghoa1.setXoa(false);
     hanghoa1.setNhomhang(nhomHang.get());
     hanghoa1.setThuongHieu(thuongHieu.get());
     hanghoa1.setMaVach(hanghoa.getMaVach());

     HangHoa hd = hangHoaRepo.save(hanghoa1);
     if( hd == null) {
         response.setResult(-1, "lưu không thành công");
         return Optional.empty();
     }else {
         response.success();
     }
      return Optional.of(hd);
    }

    @Override
    public Optional<HangHoa> update(HangHoaDto hangHoaDto, int nhomHangId, int thuongHieuId) {
     try {
       Optional<HangHoa> hangHoa = hangHoaRepo.findById(hangHoaDto.getId());
       if(!hangHoa.isPresent()) {
           return Optional.empty();
       }
       Optional<ThuongHieu> thuongHieu = thuongHieuRepo.findById(thuongHieuId);
       if (!thuongHieu.isPresent()) {
        return Optional.empty();
       }
       Optional<NhomHang> nhomHang = nhomHangrepo.findById(nhomHangId);
       if (!thuongHieu.isPresent()) {
           return Optional.empty();
       }
         HangHoa hanghoa1 = hangHoa.get();
         hanghoa1.setMa(hangHoaDto.getMa());
         hanghoa1.setMaGiamGia(hangHoaDto.getMaGiamGia());
         hanghoa1.setMoTa(hangHoaDto.getMoTa());
         hanghoa1.setPhanTramGiamGia(hangHoaDto.getPhanTramGiamGia());
         hanghoa1.setTenHangHoa(hangHoaDto.getTenHangHoa());
         hanghoa1.setTichDiem(hangHoaDto.getTichDiem());
         hanghoa1.setUrlHinhAnh1(hangHoaDto.getUrlHinhAnh1());
         hanghoa1.setUrlHinhAnh2(hangHoaDto.getUrlHinhAnh2());
         hanghoa1.setUrlHinhAnh3(hangHoaDto.getUrlHinhAnh3());
         hanghoa1.setXoa(false);
         hanghoa1.setNhomhang(nhomHang.get());
         hanghoa1.setThuongHieu(thuongHieu.get());
         hanghoa1.setMaVach(hangHoaDto.getMaVach());

         return Optional.ofNullable(hangHoaRepo.save(hanghoa1));

     }catch (Exception e) {
       return Optional.empty();
     }
    }

    @Override
    public Page<HangHoa> findAll(Pageable pageable) {
        try {
            return hangHoaRepo.findAll(pageable);
        }catch (Exception e) {
           return Page.empty();
        }
    }

    @Override
    public Page<HangHoa> search(String ma, String maHangHoa, Pageable pageable) {
        try {
            return hangHoaRepo.search(ma,maHangHoa,pageable);
        }catch (Exception e) {
          return Page.empty();
        }
    }

    @Override
    public Boolean delete(int id) {
        try {
            int rs = hangHoaRepo.deleteId(id);
            return hangHoaRepo.deleteId(id) >= 0;
        }catch (Exception e) {
         return false;
         }
    }

    @Override
    public Optional<HangHoa> findById(int id) {
        try {
            return hangHoaRepo.findById(id);
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}
