package com.example.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

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

        Button addRecordButton = findViewById(R.id.btn_add);
        addRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText isbn_et = findViewById(R.id.edit_isbn);
                EditText name_et = findViewById(R.id.edit_name);
                EditText page_et = findViewById(R.id.editText3);
                ToggleButton isLentToggle=findViewById(R.id.toggleButton);
                int newISBN=Integer.parseInt(isbn_et.getText().toString());
                String newName=name_et.getText().toString();
                int newPage=Integer.parseInt(page_et.getText().toString());
                boolean newIsLent=isLentToggle.isChecked();

                Book newBook = new Book(newISBN,newName,newPage,newIsLent);

                bookList.add(newBook);
                ba.notifyDataSetChanged();
            }
        });
        recyclerView.setAdapter(ba);
        bookList.addAll(generatedData());
//        ba.notifyDataSetChanged();
    }

    protected ArrayList<Book> generatedData(){
        ArrayList<Book> alb = new ArrayList<>();
        Book b;

        b=new Book(1233333,"Dune",450,false);
        alb.add(b);
    /*    b=new Book(4569087,"Star wars",789,true);
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
        alb.add(b);*/
        return alb;
    }
}
