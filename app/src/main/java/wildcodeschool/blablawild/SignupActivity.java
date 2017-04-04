package wildcodeschool.blablawild;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonSignup;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    private EditText editTextDisplayName;
    private EditText editTextUri;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextUsername = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextDisplayName = (EditText) findViewById(R.id.editTextDisplayName);
        editTextUri = (EditText) findViewById(R.id.editTextUri);
        buttonSignup = (Button) findViewById(R.id.buttonSignup);
        buttonSignup.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);



    }


    @Override
    public void onClick(View view) {

        if (view == buttonSignup) {

            mAuth.createUserWithEmailAndPassword(editTextUsername.getText().toString().trim(), editTextPassword.getText().toString().trim())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(editTextDisplayName.getText().toString().trim())
                                        .setPhotoUri(Uri.parse(editTextUri.getText().toString().trim()))
                                        .build();

                                user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        if (task.isSuccessful()){
                                            Log.d("test", "User Profil Updated");
                                            finish();
                                            startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                                        }
                                    }
                                });
                            } else {
                                //display some message here
                                Toast.makeText(SignupActivity.this, "Registration Error", Toast.LENGTH_LONG).show();
                                progressDialog.setMessage("Registering Please Wait...");
                                progressDialog.show();



                            }
                        }
                    });

        }
    }
}

