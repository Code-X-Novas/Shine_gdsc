package com.example.new_project;




import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class reg_page extends AppCompatActivity {
    TextInputEditText editTextemail, editTextpassword;
    Button signup;
    TextView signin;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reg_page);

        editTextemail=findViewById(R.id.email);
        editTextpassword=findViewById(R.id.password);
        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(reg_page.this, login_page.class);
                startActivity(intent);
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emial,password;
                emial=String.valueOf(editTextemail.getText());
                password=String.valueOf(editTextpassword.getText());
                if (TextUtils.isEmpty(emial)){
                    Toast.makeText(reg_page.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(reg_page.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;

                }
                firebaseAuth.createUserWithEmailAndPassword(emial,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(reg_page.this,"Registration Sucessfull",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(reg_page.this, login_page.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

            }
        });

    }
}