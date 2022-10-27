package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyResponse {
    private int code ;
    private String trangthai;

    public void setResult(int code, String trangthai){
        this.code = code ;
        this.trangthai = trangthai;
    }

    public  void success(){
        this.code = 0 ;
        this.trangthai = "message";
    }
}
