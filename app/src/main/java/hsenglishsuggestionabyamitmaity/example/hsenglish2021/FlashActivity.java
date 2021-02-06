package hsenglishsuggestionabyamitmaity.example.hsenglish2021;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

public class FlashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_flash );

        Thread thread = new Thread (  )
        {
            @Override
            public void run() {


                try {
                    sleep ( 3000 );
                }

                catch (Exception e)
                {
                    e.printStackTrace ();
                }
                finally {
                    Intent intent = new Intent ( FlashActivity.this,MainActivity.class );
                    startActivity ( intent );
                }
            }
        };

        thread.start ();

    }


    @Override
    protected void onPause() {
        super.onPause ();


        finish ();

    }

}