package com.example.demo.dto;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

@Data
public class NhomHangDto {
    public Integer id ;
    public String maNhomHang;
    public String tenNhomHang;
    public Boolean xoa;
}
