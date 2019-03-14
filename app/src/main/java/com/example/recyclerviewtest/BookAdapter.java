package com.example.recyclerviewtest;

import android.service.autofill.TextValueSanitizer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder>{

    List<Book> bookList;

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, pages, isbn;
        Button btnAvailability, btnCheckout;

        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.txt_name);
            pages = view.findViewById(R.id.txt_page);
            isbn = view.findViewById(R.id.txt_ISBN);
            btnAvailability = view.findViewById(R.id.btn_test);
            btnCheckout = view.findViewById(R.id.btn_checkout);
        }
    }

    BookAdapter(List<Book> bookList) {this.bookList = bookList;}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_row, viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final BookAdapter.MyViewHolder viewHolder, int i) {
        final Book book=bookList.get(i);
        viewHolder.name.setText(book.getName());
        viewHolder.pages.setText(book.getPage()+"");
        viewHolder.isbn.setText(book.getISBN()+"");

        viewHolder.btnAvailability.setOnClickListener(new View.OnClickListener() {
            String showMsg;
            @Override
            public void onClick(View v) {
                if(book.isLent())showMsg = "Not available";
                else showMsg = "Available";
                Toast.makeText(v.getContext(),showMsg,Toast.LENGTH_LONG).show();
            }
        });



        viewHolder.btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), String.valueOf(book.getISBN()),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.bookList.size();
    }

}

