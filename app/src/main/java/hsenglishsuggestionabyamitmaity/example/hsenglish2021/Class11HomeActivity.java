package  hsenglishsuggestionabyamitmaity.example.hsenglish2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Class11HomeActivity extends AppCompatActivity {

    private LinearLayout problems,solution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_class11_home );

        problems = findViewById ( R.id.class11learning );
        solution = findViewById ( R.id.class11solutions );


        problems.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intentrrtt = new Intent ( Class11HomeActivity.this,MCQChapterActivity.class );
                startActivity ( intentrrtt);
            }
        } );
        solution.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intentrrttt = new Intent ( Class11HomeActivity.this,LAQChapterActivity.class );
                startActivity ( intentrrttt);

            }
        } );
    }
}