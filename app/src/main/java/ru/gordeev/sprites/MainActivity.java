package ru.gordeev.sprites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.gordeev.sprites.view.MyView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(new MyView(this));
    }
}
