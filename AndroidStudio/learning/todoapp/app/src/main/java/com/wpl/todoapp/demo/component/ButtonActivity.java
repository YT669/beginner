package com.wpl.todoapp.demo.component;

import android.os.Bundle; //用于在Activity之间传递数据，或保存Activity的状态（如 onSaveInstanceState）。
import android.util.Log;
import android.view.View; //导入View类，是所有 UI 组件（Button、TextView 等）的基类。View.OnClickListener 是 View 的内部接口。
import android.widget.Toast; //导入 Toast 类，用于显示短暂的浮动提示消息（不会获得焦点，几秒后自动消失）。

import androidx.activity.EdgeToEdge; //导入 AndroidX 提供的边缘到边缘辅助类（Android 15+ 推荐），帮助应用内容延伸到系统栏（状态栏/导航栏）下面。
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;//导入 AppCompatActivity，是 AndroidX 兼容库提供的 Activity 基类，让低版本 Android 也能使用新特性（如 ActionBar、Material Design）
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.wpl.todoapp.MainActivity;
import com.wpl.todoapp.databinding.ActivityButtonBinding; //导入 ViewBinding 自动生成的绑定类。ActivityButtonBinding 是根据 activity_button.xml 布局文件生成的，里面包含了布局中所有带 id 的控件引用。

import java.util.IllegalFormatCodePointException;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityButtonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityButtonBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        Log.d("wpl","onCreat");
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding.button2.setOnClickListener(v->{
            Toast.makeText(this,"button2",Toast.LENGTH_SHORT).show();
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"button3",Toast.LENGTH_SHORT).show();
            }
        });
        binding.button4.setOnClickListener(this);
        binding.button5.setOnClickListener(this);
    }

    public void setClink(View view) {
        Toast.makeText(this,"button1",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == binding.button4.getId()) {
            Toast.makeText(this,"button4",Toast.LENGTH_SHORT).show();
        }else if(v.getId() == binding.button5.getId()){
            Toast.makeText(this,"button5",Toast.LENGTH_SHORT).show();
        }

    }
}