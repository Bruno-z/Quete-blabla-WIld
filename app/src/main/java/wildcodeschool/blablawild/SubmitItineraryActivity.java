package wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SubmitItineraryActivity extends AppCompatActivity {


    EditText editTextDepart;
    EditText editTextDestination;
    EditText editTextPrice;
    EditText editTextDate;
    EditText editTextHeure;
    Button buttonPublier;
    Date  myDate;
    private FirebaseUser firebaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_itinerary);

        editTextDepart = (EditText)findViewById(R.id.editTextDepart);
        editTextDestination = (EditText)findViewById(R.id.editTextDestination);
        editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        editTextDate = (EditText)findViewById(R.id.editTextDate);
        editTextHeure = (EditText)findViewById(R.id.editTextHeure);
        buttonPublier = (Button)findViewById(R.id.buttonPublier);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();





        // j'utilise la database de Firebbase et je l'instancie avec un get instance pour la récuperer;

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        //  ce que renvoie une méthode databasereference en utilisant l'objet database
        final DatabaseReference ref = database.getReference("itineraries");

        final Intent intent = getIntent();

        buttonPublier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextDepart.length() != 0 && editTextDestination.length() != 0) {
                    String Départ = editTextDepart.getText().toString();
                    String Déstination = editTextDestination.getText().toString();



                    int price =Integer.parseInt(editTextPrice.getText().toString());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
                    try {
                         myDate  = sdf.parse(editTextDate.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }



                    // nom de ma class d'objet et les getter de ces objet avec un getText.tostring
                    ItineraryModel objet;
                    objet = new ItineraryModel(firebaseUser.getUid() , myDate,  price, (editTextDepart.getText().toString()),(editTextDestination.getText().toString()),firebaseUser.getDisplayName());


                    // ref= base de donné firebase et je push mon objet
                    ref.push().setValue(objet);
                    // intent de cette activity vers ma list
                    Intent hello = new Intent(SubmitItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);

                    startActivity(hello);




                }
        };

    });
}}
