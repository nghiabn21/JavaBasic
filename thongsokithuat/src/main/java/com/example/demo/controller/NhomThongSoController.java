package com.example.demo.controller;

import com.example.demo.dto.NhomThongSoDto;
import com.example.demo.entity.NhomThongSo;
import com.example.demo.service.NhomThongSoSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/nhomthongso")
public class NhomThongSoController {
    @Autowired
    NhomThongSoSer nhomThongSoSer;

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        Pageable pageable = PageRequest.of(0,10);
        Page<NhomThongSo> nhomThongSos = nhomThongSoSer.findAll(pageable);
        return ResponseEntity.ok(nhomThongSos);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "maNhomThongSo") String maNhomThongSo,
                                    @RequestParam(name = "tennhomThongSo") String tenNhomThongSo,
                                    @RequestParam(name = "page") Integer page,
                                    @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<NhomThongSo> nhomThongSos = nhomThongSoSer.search(maNhomThongSo, tenNhomThongSo,pageable);
        return ResponseEntity.ok(nhomThongSos);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody NhomThongSo nhomThongSo,
                                  @RequestParam( name = "hang_hoa_id") int hangHoaId){
        Optional<NhomThongSo> nhomThongSo1 = nhomThongSoSer.save(nhomThongSo, hangHoaId);
        if(nhomThongSo1.isPresent()) {
            return ResponseEntity.ok("success");
        }else {
            return ResponseEntity.ok("failure");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody NhomThongSoDto nhomThongSoDto,
                                    @RequestParam( name = "hangHoaId") int hangHoaId){
        Optional<NhomThongSo> nhomThongSo = nhomThongSoSer.update(nhomThongSoDto, hangHoaId);
        if(nhomThongSo.isPresent()) {
            return ResponseEntity.ok("success");
        }else {
            return ResponseEntity.ok("failure");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id){
        Optional<NhomThongSo> nhomThongSo = nhomThongSoSer.findById(id);
        if(nhomThongSo.isPresent()) {
            return ResponseEntity.ok(nhomThongSo.get());
        }else {
            return ResponseEntity.ok("failure");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        return nhomThongSoSer.delete(id) ? ResponseEntity.ok("success") : ResponseEntity.ok("failure");
    }
}
