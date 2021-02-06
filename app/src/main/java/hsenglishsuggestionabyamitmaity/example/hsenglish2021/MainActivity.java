package hsenglishsuggestionabyamitmaity.example.hsenglish2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private LinearLayout notifications,class11,about,contact,QUiz,mainnee;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;
    private String versions = "1.0";
    private TextView version;
    private String currentUserID;
    private ProgressDialog progressDialog;
    private DatabaseReference UserRef,VersionRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        notifications = findViewById ( R.id.notifications );
        class11 = findViewById ( R.id.class11);
        RootRef= FirebaseDatabase.getInstance ().getReference ();
        about = findViewById ( R.id.about);
        contact = findViewById ( R.id.cotacts);
        QUiz = findViewById ( R.id.problems_quiz );
        mainnee = findViewById ( R.id.problems_quiz_main );




        UserRef= FirebaseDatabase.getInstance ().getReference ().child ( "Users" );
        VersionRef= FirebaseDatabase.getInstance ().getReference ();
        version = findViewById ( R.id.versionCode );
        mAuth = FirebaseAuth.getInstance ();
        progressDialog = new ProgressDialog ( MainActivity.this );

        progressDialog.setContentView ( R.layout.loading );
        progressDialog.setTitle ( "Please Wait.." );

        progressDialog.setCanceledOnTouchOutside ( false );


        try {
            PackageInfo packageInfo = getPackageManager ().getPackageInfo ( getPackageName (),0 );
            versions = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace ();
        }

        version.setText ( versions );


        QUiz.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intentu = new Intent ( MainActivity.this,PastyearmainhomeActivity.class );
                startActivity ( intentu );
            }
        } );

        mainnee.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                openPortal();
            }
        } );



        notifications.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent ( MainActivity.this,NotificationActivity.class );
                startActivity ( intent );
            }
        } );


        class11.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intenter = new Intent ( MainActivity.this,Class11HomeActivity.class );
                startActivity ( intenter );
            }
        } );


        about.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent intentrrttt = new Intent ( MainActivity.this,AboutusActivity.class );
                startActivity ( intentrrttt);
            }
        } );

        contact.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intentrrtty = new Intent ( MainActivity.this,ContactUSActivity.class );
                startActivity ( intentrrtty);
            }
        } );




    }




    private void openPortal() {
        String url = "https://www.gamezop.com/?id=Cw02RgQzR";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.intent.setPackage("com.android.chrome");
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }





    public void GooglePLay(View view) {

        Intent sendIntent = new Intent (  Intent.ACTION_SEND);
        sendIntent.putExtra ( Intent.EXTRA_TEXT,
                "\n\nPlease Download HS English Suggestion 2021 From Google PlayStore:-\n" +
                        "\n\nhttps://play.google.com/store/apps/details?id=hsfinenglishsuggestiosnmaortk.example.hsenglishsuggestion");
        sendIntent.putExtra ( Intent.EXTRA_SUBJECT,"WBCHSE Physics Life App" );
        sendIntent.setType ( "text/plain" );
        Intent shareIntent = Intent.createChooser ( sendIntent,"WBCHSE Physics Life App" );
        startActivity ( shareIntent );
    }


    public void MODELQNPAPWR(View view) {

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pages.razorpay.com/HSEnglish2021"));
        startActivity(browserIntent);
    }
}