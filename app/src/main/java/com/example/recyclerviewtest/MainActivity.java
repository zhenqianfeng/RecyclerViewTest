package com.example.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Book> bookList = new ArrayList<>();
    private BookAdapter ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ba = new BookAdapter(bookList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(ba);
        bookList.addAll(generatedData());
    }

    protected ArrayList<Book> generatedData(){
        ArrayList<Book> alb = new ArrayList<>();
        Book b;

        b=new Book(1233333,"Dune",450,false);
        alb.add(b);
        b=new Book(4569087,"Star wars",789,true);
        alb.add(b);
        b=new Book(7893452,"Star trek",852,false);
        alb.add(b);
        b=new Book(1233333,"Dune",450,false);
        alb.add(b);
        b=new Book(4569087,"Star wars",789,true);
        alb.add(b);
        b=new Book(7893452,"Star trek",852,false);
        alb.add(b);
        b=new Book(1233333,"Dune",450,false);
        alb.add(b);
        b=new Book(4569087,"Star wars",789,true);
        alb.add(b);
        b=new Book(7893452,"Star trek",852,false);
        alb.add(b);
        return alb;
    }
}
