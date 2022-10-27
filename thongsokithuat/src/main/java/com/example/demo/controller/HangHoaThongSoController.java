package com.example.demo.controller;

import com.example.demo.dto.HangHoaThongSoDto;
import com.example.demo.entity.HangHoaThongSo;
import com.example.demo.service.HangHoaThongSoSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/hanghoathongso")
public class HangHoaThongSoController {
    @Autowired
    HangHoaThongSoSer hangHoaThongSoSer;

    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<HangHoaThongSo> hangHoaThongSos = hangHoaThongSoSer.findAll(pageable);
        return ResponseEntity.ok(hangHoaThongSos);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "giaTri") String giaTri,
                                    @RequestParam(name = "page") Integer page,
                                    @RequestParam(name = "size") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<HangHoaThongSo> hangHoaThongSos = hangHoaThongSoSer.search(giaTri, pageable);
        return ResponseEntity.ok(hangHoaThongSos);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody HangHoaThongSo hangHoaThongSo,
                                  @RequestParam(name = "hangHoaId") int hangHoaId,
                                  @RequestParam(name = "thongSoChiTiet") int thongSoChiTietId,
                                  @RequestParam(name = "thongSoKiThuat") int thongSoKiThuatId) {
        Optional<HangHoaThongSo> hangHoaThongSo1 = hangHoaThongSoSer.save(hangHoaThongSo, hangHoaId, thongSoChiTietId, thongSoKiThuatId);
        if (hangHoaThongSo1.isPresent()) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.ok("failure");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody HangHoaThongSoDto hangHoaThongSoDto,
                                  @RequestParam(name = "hangHoaId") int hangHoaId,
                                  @RequestParam(name = "thongSoChiTiet") int thongSoChiTietId,
                                  @RequestParam(name = "thongSoKiThuat") int thongSoKiThuatId) {
        Optional<HangHoaThongSo> hangHoaThongSo1 = hangHoaThongSoSer.update(hangHoaThongSoDto, hangHoaId, thongSoChiTietId, thongSoKiThuatId);
        if (hangHoaThongSo1.isPresent()) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.ok("failure");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id){
        Optional<HangHoaThongSo> hangHoaThongSo = hangHoaThongSoSer.findById(id);
        if(hangHoaThongSo.isPresent()) {
            return ResponseEntity.ok(hangHoaThongSo.get());
        }else {
            return ResponseEntity.ok("failure");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        return hangHoaThongSoSer.delete(id) ? ResponseEntity.ok("success") : ResponseEntity.ok("failure");
    }

}

