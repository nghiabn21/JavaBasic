package com.example.demo.entity.createRequest;

import com.example.demo.dto.HangHoaDto;
import com.example.demo.dto.HangHoaThongSoDto;
import lombok.Data;

import java.util.List;

@Data
public class Request {
    private Integer nhomHangId;
  //  private Integer hangHoaId ;
  //  private Integer hangHoaThongSoId;
    private Integer thuonghieuId;
//    private Integer thongSochitietId ;
//    private Integer thongSoKithuatId ;
//    private Integer nhomThongsoId;
    private HangHoaDto hangHoaDto ;
//    private List<HangHoaThongSoDto> hangHoaThongSoDto;

   public String Validate(){
       if(nhomHangId == null || nhomHangId <=0) {
           return "nhóm hàng id không hợp lệ";
       }
//       if(hangHoaId == null ||  hangHoaId <=0) {
//           return "hàng hóa id không hợp lệ";
//       }
//       if(hangHoaThongSoId == null || hangHoaThongSoId <=0) {
//           return "hàng hóa thông số id không hợp lệ";
//       }
//       if(thuonghieuId == null || thuonghieuId <=0) {
//           return "thương hiệu  id không hợp lệ";
//       }
//       if(thongSochitietId == null || thongSochitietId <=0) {
//           return "thông số chi tiết id không hợp lệ";
//       }
//       if(thongSoKithuatId == null || thongSoKithuatId <=0) {
//           return "thông số kĩ thuật id không hợp lệ";
//       }
//       if(nhomThongsoId == null || nhomThongsoId <=0) {
//           return "nhóm thông số id không hợp lệ";
//       }
       return null ;
   }


}
