package com.example.demo.dto;

import com.example.demo.entity.HangHoa;
import com.example.demo.entity.ThongSoChiTiet;
import com.example.demo.entity.ThongSoKiThuat;
import lombok.Data;

@Data
public class HangHoaThongSoDto {
    public Integer id;
    public HangHoa hangHoa ;
    public ThongSoKiThuat thongSoKiThuat ;
    public ThongSoChiTiet thongSoChiTiet;
    public String giaTri;
    public Boolean xoa;
}
