package com.example.demo.dto;

import com.example.demo.entity.NhomHang;
import com.example.demo.entity.NhomThongSo;
import lombok.Data;

@Data
public class ThongSoKiThuatDto {
    public Integer id;
    public String tenThongSo;
   public Integer nhomHang;
    public Boolean xoa;
    public Integer nhomThongSo ;
}
