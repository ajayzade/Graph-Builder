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
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Pie extends AppCompatActivity {
    PieChart pieChart;
    ArrayList<Entry> entries ;
    ArrayList<String> pieEntryLabels;
    PieDataSet pieDataSet ;
    PieData pieData ;
    EditText v,l;
    Button button1,button3;
    TextView t;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        v = (EditText) findViewById(R.id.values);
        l = (EditText) findViewById(R.id.labels);
        button1 = (Button) findViewById(R.id.btn1);
        button3 = (Button) findViewById(R.id.clc);
        t = (TextView) findViewById(R.id.txt);
        pieChart = (PieChart) findViewById(R.id.pie);
        entries = new ArrayList<Entry>();
        pieEntryLabels = new ArrayList<String>();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float d = Float.parseFloat(v.getText().toString());
                String s = l.getText().toString();
                entries.add(new BarEntry(d,i));
                pieEntryLabels.add(s);
                i++;
                t.setText(t.getText().toString()+d+"\t\t\t\t\t\t\t\t\t\t"+s+"\n");
                v.setText("");
                l.setText("");
                pieDataSet = new PieDataSet(entries,"");
                pieDataSet.setSliceSpace(3f);
                pieDataSet.setSelectionShift(5f);
                pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                pieData = new PieData(pieEntryLabels,pieDataSet);
                pieData.setValueTextColor(Color.WHITE);
                pieData.setValueTextSize(15);
                pieChart.setData(pieData);
                pieChart.setRotationEnabled(true);
                pieChart.setUsePercentValues(true);
                pieChart.setCenterTextSize(20);
                pieChart.setHoleRadius(5);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pieChart.clear();
                t.setText("");
                entries.clear();
                pieEntryLabels.clear();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(Pie.this);
        View v = getLayoutInflater().inflate(R.layout.dialog,null);
        RadioButton rb1 = (RadioButton) v.findViewById(R.id.radioButton1);
        RadioButton rb2 = (RadioButton) v.findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) v.findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton) v.findViewById(R.id.radioButton4);
        RadioButton rb5 = (RadioButton) v.findViewById(R.id.radioButton5);
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        final LinearLayout l = (LinearLayout) findViewById(R.id.pie_activity);
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
