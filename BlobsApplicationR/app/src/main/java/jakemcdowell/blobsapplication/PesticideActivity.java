package jakemcdowell.blobsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PesticideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesticide);
        TextView golddisplay = (TextView) findViewById(R.id.textView12);
        golddisplay.setText("" + PlayerData.currentGold);
        ImageView e = (ImageView) findViewById(R.id.soldout);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void leavepurchasebutton(View v) {
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
