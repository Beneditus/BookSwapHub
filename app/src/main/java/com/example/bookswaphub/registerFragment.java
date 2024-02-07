package com.example.bookswaphub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class registerFragment extends Fragment {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText emailEditText;

    private UserDatabase userDatabase;
    private UserDao userDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        usernameEditText = view.findViewById(R.id.etRegisterName);
        passwordEditText = view.findViewById(R.id.etRegisterPassword);
        emailEditText = view.findViewById(R.id.etRegisterEmail);
        Button registerButton = view.findViewById(R.id.btRegisterRegister);

        userDatabase = UserDatabase.getUserDatabase(requireContext());
        userDao = userDatabase.userDao();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        return view;
    }

    private void registerUser() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();

        UserEntity user = new UserEntity();

        user.setUserId(username);
        user.setPassword(password);
        user.setEmail(email);

        new Thread(new Runnable() {
            @Override
            public void run() {
                userDao.registerUser(user);
            }
        }).start();
    }
}
