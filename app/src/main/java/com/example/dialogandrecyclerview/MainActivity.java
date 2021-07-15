package com.example.dialogandrecyclerview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<String> dataset = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = getLayoutInflater().inflate(R.layout.custom_layout, null);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager rLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(rLayoutManager);

        int i = 0;
        while (i < 20) {
            String str = "Data_" + i;
            dataset.add(str);
            i++;
        }

        MyAdapter adapter = new MyAdapter(dataset);
        recyclerView.setAdapter(adapter);

        new AlertDialog.Builder(this)
                .setTitle("タイトル")
                .setMessage("メッセージ")
                .setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // OK button pressed
                    }
                })
                .show();
    }
}