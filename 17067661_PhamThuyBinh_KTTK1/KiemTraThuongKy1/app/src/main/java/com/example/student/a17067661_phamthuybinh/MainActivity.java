package com.example.student.a17067661_phamthuybinh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtThongTin;
    Button btnDatHang;
    static final int add=999;
    String hoten,sdt,sanpham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtThongTin = findViewById(R.id.txtThongTin);
        btnDatHang = findViewById(R.id.btnDatHang);
        final Intent i = new Intent(MainActivity.this, Activity2.class);
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(i, add);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==add){
            if(resultCode==RESULT_OK){
                hoten = data.getStringExtra("hoten");
                sdt = data.getStringExtra("SDT");
                sanpham=data.getStringExtra("sanpham");
                txtThongTin.setText("Họ tên: "+hoten+"\n"+"Số điện thoại: "+sdt+"\n"+"Sản phẩm: "+"\n"+sanpham);
            }
        }
    }
}
