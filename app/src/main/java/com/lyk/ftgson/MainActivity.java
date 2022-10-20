package com.lyk.ftgson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lyk.ftgson.bean.TestBean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * gson 容错
 * 1. 根据IKGson改变而来，加入了对象解析容错
 * 2. 以Gson 2.9.1 版本为基础来更改
 * ===================== 解析 =====================
 * 1. 在 JsonReader 中对基本类型进行数据容错，比如 nextString()、nextBoolean() 等
 * 2. chat 的解析容错，放到了 TypeAdapters 中，因为他也是解析成string，但只取第一位，超出一位报错
 * 3. 数组 的解析容错，在 ArrayTypeAdapter 中，在里面对象解析出错时，将其 try catch 并跳过
 * 4. 集合 的解析容错，在 CollectionTypeAdapterFactory 下的 Adapter 中，在里面对象解析出错时，将其 try catch 并跳过
 * 5. 对象 的解析容错，在 ReflectiveTypeAdapterFactory 下的 Adapter 中，在里面对象解析出错时，将其 try catch 并跳过
 */
public class MainActivity extends AppCompatActivity {

    private EditText jsonEt;
    private TextView parseBtn;
    private TextView gsonTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonEt = findViewById(R.id.jsonEt);
        parseBtn = findViewById(R.id.parseBtn);
        gsonTv = findViewById(R.id.gsonTv);

        jsonEt.setText(readJsonFile());
        parseBtn.setOnClickListener(v -> {
            try {
                Gson gson = new Gson();
                TestBean bean = gson.fromJson(jsonEt.getText().toString().trim(), TestBean.class);
                gsonTv.setText(bean.toString());
            } catch (Exception e) {
                gsonTv.setText(e.toString());
            }
        });
    }

    public String readJsonFile() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[20480];
        int n;
        try {
            InputStream mIn = getAssets().open("testJson.json");
            while ((n = mIn.read(buffer)) != -1) {
                baos.write(buffer, 0, n);
            }
            return baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}