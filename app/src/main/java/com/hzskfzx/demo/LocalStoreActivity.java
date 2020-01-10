package com.hzskfzx.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.LitePalDB;
import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class LocalStoreActivity extends AppCompatActivity {

    private String TAG=getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_store);

        Button btn=findViewById(R.id.btnStringToFile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: "+v.getId());
                save();
                Toast.makeText(getApplicationContext(),"保存成功",Toast.LENGTH_LONG).show();
            }
        });

        btn=findViewById(R.id.btnReadFile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: "+v.getId());
                String d= read();
                Toast.makeText(getApplicationContext(),d,Toast.LENGTH_LONG).show();
            }
        });

        btn=findViewById(R.id.btnLitePalCreateDatabase);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: "+v.getId());
                LitePal.getDatabase();
                Toast.makeText(LocalStoreActivity.this,"数据库创建成功",Toast.LENGTH_SHORT).show();
            }
        });

        btn=findViewById(R.id.btnAddBook);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=new Book();
                book.setAuthor("roy");
                book.setName("程序员");
                book.setPrice(20);
                book.setPages(450);
                book.setPress("中信出版社");
                book.save();
            }
        });

        btn=findViewById(R.id.btnUpdatePages);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=LitePal.find(Book.class,1);
                book.setPages(book.getPages()+1);
                book.save();
                SQLiteDatabase db = LitePal.getDatabase();
                ContentValues values = new ContentValues();
                values.put("pages","500");
                db.update("book",values,"id = ?", new String[] {"3"});
                db.delete("book","id>?",new String[]{"2"});
            }
        });

        btn=findViewById(R.id.btnBooksListToTAG);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                List<Book> books = LitePal.where("pages>?", "400").find(Book.class);
                for (Book book:books) {
                    Log.i(TAG, "Books:"+book.getId());
                }

                List<Book> books1 = LitePal.select("name", "author", "pages")
                        .where("pages>?", "400")
                        .order("pages")
                        .limit(10)
                        .offset(0)
                        .find(Book.class);

                for (Book book:books1) {
                    Log.i(TAG, "books1:"+book.getId());
                }
            }
        });
    }

    private void save(){
        String data="Data to save.";
        OutputStream outputStream;
        BufferedWriter bufferedWriter = null;
        try {
            outputStream=openFileOutput("data", Context.MODE_PRIVATE);
            bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(data);
        }
        catch (IOException ex){
            Log.e(TAG, ex.getMessage());
        }
        finally {
            if(bufferedWriter!=null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    Log.e(TAG, "save: "+e.getMessage() );
                }
            }
        }
    }

    private String read(){
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        StringBuilder stringBuilder=new StringBuilder();
        try {
            fileInputStream=openFileInput("data");
            bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));

            String line="";
            while(true){
                try {
                    if (((line=bufferedReader.readLine())==null)) break;
                    stringBuilder.append(line);
                } catch (IOException e) {
                    Log.e(TAG, "readFile: "+e.getMessage() );
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
