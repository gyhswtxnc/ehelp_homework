package com.example.ehelp_homework;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ehelp_homework extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ehelp_homework);
        Button regist=(Button) findViewById(R.id.bt2);
        Button load=(Button)findViewById(R.id.bt1);
        RadioGroup feature=(RadioGroup)findViewById(R.id.buttongroup);
        final EditText username=(EditText)findViewById(R.id.input1);
        final EditText code=(EditText)findViewById(R.id.input2);
        final RadioButton teacher=(RadioButton)findViewById(R.id.button1);
        final RadioButton student=(RadioButton)findViewById(R.id.button2);
        final RadioButton club=(RadioButton)findViewById(R.id.button3);
        final RadioButton manager=(RadioButton)findViewById(R.id.button4);
        feature.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(teacher.getId()==checkedId){
                    Toast.makeText(ehelp_homework.this,"老师身份被选中",Toast.LENGTH_SHORT).show();
                }
                if(student.getId()==checkedId){
                    Toast.makeText(ehelp_homework.this,"学生身份被选中",Toast.LENGTH_SHORT).show();
                }
                if(club.getId()==checkedId){
                    Toast.makeText(ehelp_homework.this,"社团身份被选中",Toast.LENGTH_SHORT).show();
                }
                if(manager.getId()==checkedId){
                    Toast.makeText(ehelp_homework.this,"管理者身份被选中",Toast.LENGTH_SHORT).show();
                }
            }
        });

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(teacher.isChecked())
                {
                    Toast.makeText(ehelp_homework.this,"教师身份注册功能尚未开启",Toast.LENGTH_SHORT).show();
                }
                else if(student.isChecked()){
                    Toast.makeText(ehelp_homework.this,"学生身份注册功能尚未开启",Toast.LENGTH_SHORT).show();
                }
                else if(club.isChecked()){
                    Toast.makeText(ehelp_homework.this,"社团身份注册功能尚未开启",Toast.LENGTH_SHORT).show();
                }
                else if(manager.isChecked()){
                    Toast.makeText(ehelp_homework.this,"管理者身份注册功能尚未开启",Toast.LENGTH_SHORT).show();
                }
            }
        });
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(username.getText().toString()))
                {
                    Toast.makeText(ehelp_homework.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(code.getText().toString()))
                {
                    Toast.makeText(ehelp_homework.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }
                if(username.getText().toString().equals("Android")&&code.getText().toString().equals("123456"))
                {
                    builder.setTitle("提示");
                    builder.setCancelable(true);
                    builder.setMessage("登录成功");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(ehelp_homework.this,"确定",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(ehelp_homework.this,"取消",Toast.LENGTH_SHORT).show();
                        }

                    });
                    AlertDialog succ=builder.create();
                    succ.show();

                }
                else{
                    builder.setTitle("提示");
                    builder.setCancelable(true);
                    builder.setMessage("登录失败");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(ehelp_homework.this,"确定",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(ehelp_homework.this,"取消",Toast.LENGTH_SHORT).show();
                        }

                    });
                    AlertDialog fai=builder.create();
                    fai.show();

                }

            }
        });



    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

}
