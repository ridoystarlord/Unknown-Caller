package com.ridoy.unknowncaller.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.ridoy.unknowncaller.R;
import com.ridoy.unknowncaller.models.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN = 11;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    KProgressHUD hud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        hud=KProgressHUD.create(this);
        hud.setDimAmount(0.5f);

        if (mAuth.getCurrentUser() != null) {
            goToNextActivity();
        }

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        findViewById(R.id.loginBtn).setOnClickListener(view -> {
            Intent intent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(intent, RC_SIGN_IN);
        });
    }

    void goToNextActivity() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            GoogleSignInAccount account = task.getResult();
            authWithGoogle(account.getIdToken());
        }
    }

    void authWithGoogle(String idToken) {
        hud.show();
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        User firebaseUser = new User(user.getUid(), user.getDisplayName(), user.getPhotoUrl().toString(), "Unknown", 500);
                        database.getReference()
                                .child("profiles")
                                .child(user.getUid())
                                .setValue(firebaseUser).addOnCompleteListener(task1 -> {
                            if (task1.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finishAffinity();
                                hud.dismiss();
                            } else {
                                hud.dismiss();
                                Toast.makeText(LoginActivity.this, task1.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    } else {
                        hud.dismiss();
                        Log.e("err", task.getException().getLocalizedMessage());
                        Toast.makeText(LoginActivity.this, "Error: " + task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}