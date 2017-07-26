package jakemcdowell.blobsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playgamebuttonclick(View v) {
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
    }

    public void entershopbuttonclick(View v) {
        Intent intent2 = new Intent(this,ShopActivity.class);
        startActivity(intent2);
    }

    public void howtoplaybuttonclick(View v) {
        Intent intent3 = new Intent(this,HelpActivity.class);
        startActivity(intent3);
    }
}
