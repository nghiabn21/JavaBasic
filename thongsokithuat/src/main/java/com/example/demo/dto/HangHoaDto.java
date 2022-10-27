package com.example.demo.dto;

import com.example.demo.entity.NhomHang;
import com.example.demo.entity.ThuongHieu;
import lombok.Data;

@Data
public class HangHoaDto {
    public Integer id;
    public String ma;
    public String maGiamGia;
    public String moTa;
    public Float phanTramGiamGia;
    public String tenHangHoa ;
    public Integer tichDiem ;
    public String urlHinhAnh1 ;
    public String urlHinhAnh2 ;
    public String urlHinhAnh3 ;
    public Boolean xoa;
    public NhomHang nhomhang ;
    public ThuongHieu thuongHieu;
    public String maVach ;


}
