package com.example.demo.controller;

import com.example.demo.dto.HangHoaDto;
import com.example.demo.entity.HangHoa;
import com.example.demo.entity.createRequest.Request;
import com.example.demo.response.MyResponse;
import com.example.demo.responsitory.HangHoaRepo;
import com.example.demo.service.HangHoaSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hanghoa")
public class HangHoaController {
    @Autowired
    HangHoaSer hangHoaSer;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody HangHoa hangHoa,
                                  @RequestParam("nhom_hang_id") int nhomhangId,
                                  @RequestParam("thuong_hieu_id") int thuonghieuId) {
        Optional<HangHoa> hd = hangHoaSer.save(hangHoa, nhomhangId, thuonghieuId);
        if (hd.isPresent()) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.ok("failed");
        }

    }


    @PutMapping("/update")
    public ResponseEntity<?> save(@RequestBody HangHoaDto hangHoaDto,
                                  @RequestParam("nhom_hang_id") int nhomhangId,
                                  @RequestParam("thuong_hieu_id") int thuonghieuId) {
        Optional<HangHoa> hd = hangHoaSer.update(hangHoaDto, nhomhangId, thuonghieuId);
        if (hd.isPresent()) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.ok("failed");
        }

    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<HangHoa> hangHoas = hangHoaSer.findAll(pageable);
        return ResponseEntity.ok(hangHoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id) {
        Optional<HangHoa> hangHoa = hangHoaSer.findById(id);
        if (hangHoa.isPresent()) {
            return ResponseEntity.ok(hangHoa.get());
        } else {
            return ResponseEntity.ok("failure");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        return hangHoaSer.delete(id) ? ResponseEntity.ok("success") : ResponseEntity.ok("failure");
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "ma") String ma,
                                    @RequestParam(name = "ten_hang_hoa") String tenHangHoa,
                                    @RequestParam(name = "page") Integer page,
                                    @RequestParam(name = "size") Integer size){
        Pageable pageable =PageRequest.of(page -1 ,size);
        Page<HangHoa> hangHoas = hangHoaSer.search(ma,tenHangHoa,pageable);
        return ResponseEntity.ok(hangHoas);
    }

}
