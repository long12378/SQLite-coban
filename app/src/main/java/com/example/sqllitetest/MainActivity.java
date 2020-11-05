package com.example.sqllitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button them, sua, xoa;
    private EditText id, name, toan, ly, hoa;
    private mydatabase mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new mydatabase(this);
        initView();
        initListener();
    }



    private void initListener() {
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = name.getText().toString();
                String diemtoan = toan.getText().toString();
                String diemly = ly.getText().toString();
                String diemhoa = hoa.getText().toString();
                boolean bl = mydb.insertData(ten,diemtoan,diemly,diemhoa);
                if(bl){
                    Toast.makeText(MainActivity.this,"them thanh cong",Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(MainActivity.this,"loi",Toast.LENGTH_SHORT).show();
            }
        });

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idsv = id.getText().toString();
                String ten = name.getText().toString();
                String diemtoan = toan.getText().toString();
                String diemly = ly.getText().toString();
                String diemhoa = hoa.getText().toString();
                boolean bl = mydb.updateData(idsv, ten, diemtoan, diemly, diemhoa);
                if(bl)
                    Toast.makeText(MainActivity.this, "Sua thanh cong",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"loi",Toast.LENGTH_SHORT).show();
            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idsv = id.getText().toString();
                boolean bl = mydb.deleteData(idsv);
                if(bl)
                    Toast.makeText(MainActivity.this, "xoa thanh cong",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "loi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        them = (Button) findViewById(R.id.bt_them);
        sua = (Button) findViewById(R.id.bt_sua);
        xoa = (Button) findViewById(R.id.bt_sua);
        id = (EditText) findViewById(R.id.et_id);
        name = (EditText) findViewById(R.id.et_name);
        toan = (EditText) findViewById(R.id.et_toan);
        ly = (EditText) findViewById(R.id.et_ly);
        hoa = (EditText) findViewById(R.id.et_hoa);


    }
}