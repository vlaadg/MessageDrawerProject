package com.gvs.messengerapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.gvs.messengerapp.activities.RegisterActivity;
import com.gvs.messengerapp.databinding.ActivityMainBinding;
import com.gvs.messengerapp.models.User;
import com.gvs.messengerapp.ui.fragments.ChatsFragment;
import com.gvs.messengerapp.ui.objects.AppDrawer;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private Toolbar mToolbar;
    private AppDrawer mAppDrawer;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        intiFields();
        initFunc();
    }

    private void initFunc() {
        if(mAuth.getCurrentUser() != null){
            setSupportActionBar(mToolbar);
            mAppDrawer.create();
            //переключет на фрагмент
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dataContainer, new ChatsFragment()).commit();
        } else {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }

    private void intiFields() {
        mToolbar = mBinding.mainToolbar;
        mAppDrawer = new AppDrawer(this, mToolbar);
        mAuth = FirebaseAuth.getInstance();
        initUsers();
    }

    private void initUsers() {
        FirebaseDatabase.getInstance().getReference().child("users").child( FirebaseAuth.getInstance().getCurrentUser().getUid().toString())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        User user = snapshot.getValue(User.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }

}