package com.wpl.todoapp.demo.component;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.wpl.todoapp.databinding.ActivityTextViewBinding;

public class TextViewActivity extends AppCompatActivity {
    TextView tvUserName1;
    private ActivityTextViewBinding binding;  //驼峰命名法与activity_text_view.xml绑定

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_text_view);

        binding = ActivityTextViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        tvUserName1  = findViewById(R.id.tv1);
//        tvUserName1.setText("小羊，你好呀！！");
        binding.tv1.setText("小羊小羊你好呀！");
    }

}