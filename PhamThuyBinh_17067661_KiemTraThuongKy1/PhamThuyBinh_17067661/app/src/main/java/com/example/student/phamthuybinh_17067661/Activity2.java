package com.example.student.phamthuybinh_17067661;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    EditText edtHoTen,edtSDT;
    Button btnLaySanPham,btnXacNhan;
    TextView txtSanPhamChon;
    String chuoisanpham="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        edtHoTen =findViewById(R.id.edtHoTen);
        edtSDT=findViewById(R.id.edtSDT);
        btnLaySanPham= findViewById(R.id.btnLaySanPham);
        btnXacNhan=findViewById(R.id.btnXacNhan);
        txtSanPhamChon = findViewById(R.id.txtSanPhamChon);
        final AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Chọn sản phẩm");
        final CharSequence[] items={"Iphone","Samsung galaxy","Nokia","Vertu","Xiaomi"};
        final boolean[] arraycheck={false,false,false,false,false};
        btnLaySanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.setMultiChoiceItems(items, arraycheck, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        arraycheck[i] = b;
                    }
                }); AlertDialog alertDialog = mydialog.create();
                mydialog.show();
            }
        });
        mydialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                chuoisanpham="";
                for (int j=0;j<items.length;j++){
                    if(arraycheck[j]==true){
                        chuoisanpham+= items[j].toString()+"\n";
                    }
                }txtSanPhamChon.setText(chuoisanpham);
            }
        });
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtHoTen.getText().toString().length()>0&&edtSDT.getText().toString().length()>0){
                    Intent intent = new Intent();
                    intent.putExtra("hoten",edtHoTen.getText().toString());
                    intent.putExtra("SDT",edtSDT.getText().toString());
                    intent.putExtra("sanpham",chuoisanpham);
                    setResult(RESULT_OK,intent);
                    finish();
                }else{
                    Toast.makeText(Activity2.this, "Thông tin không được bỏ trống!", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
    }
}
