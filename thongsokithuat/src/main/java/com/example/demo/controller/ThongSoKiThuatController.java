package com.example.demo.controller;

import com.example.demo.constant.MessageResponse;
import com.example.demo.dto.ThongSoKiThuatDto;
import com.example.demo.entity.ThongSoKiThuat;
import com.example.demo.service.ThongSoKiThuatService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/thongsokithuat")
public class ThongSoKiThuatController {
    @Autowired
    ThongSoKiThuatService thongSoKiThuatService;

    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<ThongSoKiThuat> thongSoKiThuats = thongSoKiThuatService.findAll(pageable);
        return ResponseEntity.ok(thongSoKiThuats);
    }

    @GetMapping("/search")
    public ResponseEntity<?> findAll(@RequestParam(name = "tenThongSo") String tenThongSo,
                                     @RequestParam(name = "page") Integer page,
                                     @RequestParam(name = "size") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<ThongSoKiThuat> thongSoKiThuats = thongSoKiThuatService.search(tenThongSo, pageable);
        return ResponseEntity.ok(thongSoKiThuats);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ThongSoKiThuat thongSoKiThuat,
                                  @RequestParam(name = "nhomHangId") int nhomHangId,
                                  @RequestParam(name = "nhomThongSoId") int nhomThongSoId) {
        Optional<ThongSoKiThuat> thongSoKiThuat1 = thongSoKiThuatService.save(thongSoKiThuat, nhomHangId, nhomThongSoId);
        if (thongSoKiThuat1.isPresent()) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.ok("failure");
        }


    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ThongSoKiThuatDto thongSoKiThuatDto,
                                  @RequestParam(name = "nhomHangId") int nhomHangId,
                                  @RequestParam(name = "nhomThongSoId") int nhomThongSoId) {
        Optional<ThongSoKiThuat> thongSoKiThuat1 = thongSoKiThuatService.update(thongSoKiThuatDto, nhomHangId, nhomThongSoId);
        if (thongSoKiThuat1.isPresent()) {
            return ResponseEntity.ok(MessageResponse.SUCCESS);
        } else {
            return ResponseEntity.ok("failure");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id){
        Optional<ThongSoKiThuat> thongSoKiThuat = thongSoKiThuatService.findById(id);
        if(thongSoKiThuat.isPresent()) {
            return ResponseEntity.ok(thongSoKiThuat.get());
        }else {
            return ResponseEntity.ok("failure");
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findByIdNhomhang(@PathVariable(name = "id") int id){
        List<ThongSoKiThuat> thongSoKiThuat = thongSoKiThuatService.ThongsokithuatFindIdNhomHang(id);
        return  ResponseEntity.ok(thongSoKiThuat);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        return thongSoKiThuatService.delete(id) ? ResponseEntity.ok("success") : ResponseEntity.ok("failure");
    }
}
