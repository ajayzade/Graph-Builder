package applications.graph.lenovo.graphbuilder;

import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lenovo.graphbuilder.R;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ScatterPoints extends AppCompatActivity {
    ScatterChart scatterChart;
    ArrayList<Entry> entrie;
    ArrayList<String> scatterEntryLabels;
    EditText v,l;
    Button button1,button3;
    TextView t;
    int i = 0;
    ScatterData scatterData;
    ScatterDataSet scatterDataSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scatter_points);
        v = (EditText) findViewById(R.id.sc_value);
        l = (EditText) findViewById(R.id.sc_label);
        button1 = (Button) findViewById(R.id.sc_btn1);
        button3 = (Button) findViewById(R.id.sc_clc);
        t = (TextView) findViewById(R.id.sc_txt);
        entrie = new ArrayList<Entry>();
        scatterEntryLabels = new ArrayList<String>();
        scatterChart = (ScatterChart) findViewById(R.id.scatter);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float d = Float.parseFloat(v.getText().toString());
                String s = l.getText().toString();
                entrie.add(new Entry(d,i));
                scatterEntryLabels.add(s);
                i++;
                t.setText(t.getText().toString()+d+"\t\t\t\t\t\t\t\t\t\t"+s+"\n");
                v.setText("");
                l.setText("");
                scatterDataSet = new ScatterDataSet(entrie,"");
                scatterDataSet.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                scatterDataSet.setScatterShapeSize(10);
                scatterDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                scatterData = new ScatterData(scatterEntryLabels,scatterDataSet);
                scatterData.setValueTextColor(Color.BLACK);
                scatterData.setValueTextSize(15);
                scatterChart.setData(scatterData);
                
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scatterChart.clear();
                t.setText("");
                entrie.clear();
                scatterEntryLabels.clear();
                i = 0;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            color();
        }

        return super.onOptionsItemSelected(item);
    }
    public void color(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ScatterPoints.this);
        View v = getLayoutInflater().inflate(R.layout.dialog,null);
        RadioButton rb1 = (RadioButton) v.findViewById(R.id.radioButton1);
        RadioButton rb2 = (RadioButton) v.findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) v.findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton) v.findViewById(R.id.radioButton4);
        RadioButton rb5 = (RadioButton) v.findViewById(R.id.radioButton5);
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        final LinearLayout l = (LinearLayout) findViewById(R.id.scatter_activity);
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                l.setBackgroundColor(Color.RED);
                dialog.dismiss();
            }
        });
        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                l.setBackgroundColor(Color.MAGENTA);
                dialog.dismiss();
            }
        });
        rb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                l.setBackgroundColor(Color.YELLOW);
                dialog.dismiss();
            }
        });
        rb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                l.setBackgroundColor(Color.BLUE);
                dialog.dismiss();
            }
        });
        rb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                l.setBackgroundColor(Color.GREEN);
                dialog.dismiss();
            }
        });
    }
}
