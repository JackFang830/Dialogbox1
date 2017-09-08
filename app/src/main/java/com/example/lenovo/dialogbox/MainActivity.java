package com.example.lenovo.dialogbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.b0);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage("Here are the tips").setTitle("Tips");
                builder.setNegativeButton(R.string.b3, new DialogInterface.OnClickListener() {
               @Override//必须要进行方法重载否则会报错
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        Button button2 = (Button) findViewById(R.id.buttonTest);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.login_dialog,null);//一定要在这个位置定义view否则eT1,eT2将无法用到view的定义
                final EditText editText1 = (EditText) view.findViewById(R.id.editTextUserId);
                final EditText editText2 = (EditText) view.findViewById(R.id.editTextPwd);

                builder.setView(view) //positive可以继续后续操作，nag直接返回
                        .setTitle("Login")
                        .setPositiveButton(R.string.b1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                if(editText1.getText().toString().equals("abc")&&editText2.getText().toString().equals("123")){
                                    Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_LONG).show();
                                 }
                                else{
                                    Toast.makeText(MainActivity.this, "Defeat", Toast.LENGTH_LONG).show();
                                }
                            }
                        })
                        .setNegativeButton(R.string.b2, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cancel
                            }
                        });
                builder.show();
            }
        });

    }
}
