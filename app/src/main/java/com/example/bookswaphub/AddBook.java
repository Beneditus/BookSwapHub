package com.example.bookswaphub;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBook extends AppCompatActivity {
    private EditText etBookName, etAuthorName, etPublicationYear;
    private Button btnAddBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);


        etBookName = findViewById(R.id.etAddBookName);
        etAuthorName = findViewById(R.id.etAddBookAuthor);
        etPublicationYear = findViewById(R.id.etAddBookPublicationYear);
        btnAddBook = findViewById(R.id.btAddBook);


    }
}
