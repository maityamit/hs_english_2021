package hsenglishsuggestionabyamitmaity.example.hsenglish2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ContactUSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_contact_u_s );
    }

    public void EmailIntent(View view) {
        Intent intent = new Intent ( Intent.ACTION_SEND);
        intent.putExtra ( Intent.EXTRA_EMAIL,new String[]{"maityandmaityamit@gmail.com"} );
        intent.putExtra ( Intent.EXTRA_SUBJECT,"For Resolving Issue : HS Class 11 English App" );
        intent.setType ( "message/rfc822" );
        startActivity ( Intent.createChooser ( intent,"CHose an Email CLient:" ) );
    }

    public void ChattingIntent(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ("https://chat.whatsapp.com/EO66PDD2Dmi20teJtgciOC") );
        startActivity ( browserIntent );
    }
    public void TelegramChattingIntent(View view) {
        Intent browserIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ("https://t.me/wbchsephysicslife") );
        startActivity ( browserIntent );
    }
}