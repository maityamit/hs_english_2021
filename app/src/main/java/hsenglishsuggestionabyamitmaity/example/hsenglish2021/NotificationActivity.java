package hsenglishsuggestionabyamitmaity.example.hsenglish2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class NotificationActivity extends AppCompatActivity {
    private TextView txt1,txt2,txt3,txt4,txt5;
    private ProgressDialog progressDialog;

    private DatabaseReference RootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_notification );


        RootRef= FirebaseDatabase.getInstance ().getReference ();
        txt1 = findViewById ( R.id.noti1 );
        txt2 = findViewById ( R.id.noti2 );
        progressDialog = new ProgressDialog ( NotificationActivity.this );
        progressDialog.setContentView ( R.layout.loading );
        progressDialog.setTitle ( "Please Wait...." );
        txt3 = findViewById ( R.id.noti3 );
        txt4 = findViewById ( R.id.noti4 );
        txt5 = findViewById ( R.id.noti5 );
        progressDialog.show ();




        progressDialog.setMessage ( "Tips: Please Cheak your Internet or Wi-fi Connection" );
        progressDialog.setCanceledOnTouchOutside ( false );

        RetriveYouserInfo();

    }

    private void RetriveYouserInfo() {

        RootRef.child ( "Notifications" )
                .addValueEventListener ( new ValueEventListener () {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                        String retrievenot1 = dataSnapshot.child ( "Not1" ).getValue ().toString ();
                        String retrievenot2 = dataSnapshot.child ( "Not2" ).getValue ().toString ();
                        String retrievenot3 = dataSnapshot.child ( "Not3" ).getValue ().toString ();
                        String retrievenot4 = dataSnapshot.child ( "Not4" ).getValue ().toString ();
                        String retrievenot5 = dataSnapshot.child ( "Not5" ).getValue ().toString ();

                        progressDialog.dismiss ();

                        txt1.setText ( retrievenot1 );
                        txt2.setText ( retrievenot2 );
                        txt3.setText ( retrievenot3 );
                        txt4.setText ( retrievenot4 );
                        txt5.setText ( retrievenot5 );

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                } );
    }
}