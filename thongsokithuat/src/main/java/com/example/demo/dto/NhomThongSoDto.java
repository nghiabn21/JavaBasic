package com.example.demo.dto;

import com.example.demo.entity.HangHoa;
import lombok.Data;

@Data
public class NhomThongSoDto {
    public Integer id ;
    public String tenNhomThongSo;
    public HangHoa hangHoa;
    public String maNhomThongSo;
    public Boolean xoa ;
}
