package com.example.demo.entity;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "nhom_hang")
public class NhomHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "ma_nhom_hang")
    private String maNhomHang;

    @Column(name = "ten_nhom_hang")
    private String tenNhomHang ;

    @Column(name = "xoa")
    private Boolean xoa ;

    @Transient
    private List<ThongSoKiThuat> thongSoKiThuatList;
}
