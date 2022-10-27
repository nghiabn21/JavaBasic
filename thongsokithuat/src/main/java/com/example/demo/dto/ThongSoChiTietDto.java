package com.example.demo.dto;

import com.example.demo.entity.ThongSoKiThuat;
import lombok.Data;

@Data
public class ThongSoChiTietDto {
    public Integer id ;
    public String ten ;
    public String giaTri;
    public Boolean xoa;
    public ThongSoKiThuat thongSoKiThuat;
}
