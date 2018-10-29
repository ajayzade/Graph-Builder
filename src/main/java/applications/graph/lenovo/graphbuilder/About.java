package applications.graph.lenovo.graphbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lenovo.graphbuilder.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class About extends AppCompatActivity {

    TextView t;
    String s = "This app is for drawing various graphs and charts which are helpful for analysing the data in various formats.\n" +
            "The app includes following features :\n" +
            "1. Coordinate Graphs\n" +
            "2. Bar Charts\n" +
            "3. Scatter Charts\n" +
            "4. Pie Charts\n" +
            "and it also contains some predefined graphs of some equations.";
    InterstitialAd init;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        t = (TextView) findViewById(R.id.info);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-2919657393459579/8074164168");
        adView = findViewById(R.id.View);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        t.setText(s);
    }
}