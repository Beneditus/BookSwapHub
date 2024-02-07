package com.example.bookswaphub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class loginFragment extends Fragment {

    // Views
    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView registerTextView;

    private UserDatabase userDatabase;
    private UserDao userDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        emailEditText = view.findViewById(R.id.etLoginEmail);
        passwordEditText = view.findViewById(R.id.etLoginPassword);
        Button loginButton = view.findViewById(R.id.btLoginLogin);
        registerTextView = view.findViewById(R.id.tvLoginRegister);


        userDatabase = UserDatabase.getUserDatabase(requireContext());
        userDao = userDatabase.userDao();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    private void loginUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        new Thread(new Runnable() {
            @Override
            public void run() {
                UserEntity user = userDao.getUserByEmailAndPassword(email, password);
                if (user != null) {

                } else {

                }
            }
        }).start();
    }
}
