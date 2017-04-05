package wildcodeschool.blablawild;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;


import java.net.URL;


public class AccountActivity extends AppCompatActivity implements View.OnClickListener  {

    private ImageView imageViewProfile;
    private TextView textViewEmail;
    private TextView textViewDIsplayName;

    private Button buttonDisconnect;
    private FirebaseAuth firebaseAuth;
    private Uri image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        imageViewProfile = (ImageView) findViewById(R.id.imageViewprofile);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewDIsplayName = (TextView) findViewById(R.id.textViewDIsplayName);
        buttonDisconnect = (Button) findViewById(R.id.buttonDisconnect);


        //

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, SigninActivity.class));
            finish();
        } else {
            //getting current user
            FirebaseUser user = firebaseAuth.getCurrentUser();

            //initializing views
            textViewEmail = (TextView) findViewById(R.id.textViewEmail);
            buttonDisconnect = (Button) findViewById(R.id.buttonDisconnect);

            //displaying logged in user name
            textViewEmail.setText(  user.getEmail());
            textViewDIsplayName.setText("Welcome" +"  " + user.getDisplayName());
            textViewDIsplayName.setTextColor(getResources().getColor(R.color.colorAccent));
            //imageViewProfile.setImageBitmap(user.getPhotoUrl());
            Uri image = user.getPhotoUrl();
            //PICASSO
            Picasso.with(getApplicationContext()).load(user.getPhotoUrl()).into(imageViewProfile);




            //adding listener to button
            buttonDisconnect.setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonDisconnect){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
        }
    }


}




