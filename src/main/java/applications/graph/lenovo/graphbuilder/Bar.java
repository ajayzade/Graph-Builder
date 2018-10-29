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
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Bar extends AppCompatActivity {
    EditText i1,i3;
    Button add1,cle;
    TextView x1,x2;
    BarChart barChart;
    HorizontalBarChart horizontalBarChart;
    ArrayList<BarEntry> entry1,entry2;
    ArrayList<String> lab1,lab2;
    BarData barData;
    BarDataSet barDataSet;
    int i = 0,j = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        i1 = (EditText) findViewById(R.id.bar_value);
        i3 = (EditText) findViewById(R.id.bar_label);
        add1 = (Button) findViewById(R.id.bar_btn1);
        cle = (Button) findViewById(R.id.bar_clc);
        x1 = (TextView) findViewById(R.id.bar_txt);
        barChart = (BarChart) findViewById(R.id.bar);
        horizontalBarChart = (HorizontalBarChart) findViewById(R.id.hbar);
        entry1 = new ArrayList<BarEntry>();
        lab1 = new ArrayList<String>();
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float d = Float.parseFloat(i1.getText().toString());
                String s = i3.getText().toString();
                entry1.add(new BarEntry(d,i));
                lab1.add(s);
                i++;
                x1.setText(x1.getText().toString()+d+"\t\t\t\t\t\t\t\t\t\t"+s+"\n");
                barDataSet = new BarDataSet(entry1,"");
                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                barData = new BarData(lab1,barDataSet);
                barData.setValueTextSize(20);
                barData.setValueTextColor(Color.RED);
                barChart.setData(barData);
                horizontalBarChart.setData(barData);
                i1.setText("");
                i3.setText("");
            }
        });
        cle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entry1.clear();
                entry2.clear();
                lab1.clear();
                lab2.clear();
                barChart.clear();
                horizontalBarChart.clear();
                x1.setText("");
                x2.setText("");
                i = 0;
                j = 0;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(Bar.this);
        View v = getLayoutInflater().inflate(R.layout.dialog,null);
        RadioButton rb1 = (RadioButton) v.findViewById(R.id.radioButton1);
        RadioButton rb2 = (RadioButton) v.findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) v.findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton) v.findViewById(R.id.radioButton4);
        RadioButton rb5 = (RadioButton) v.findViewById(R.id.radioButton5);
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        final LinearLayout l = (LinearLayout) findViewById(R.id.bar_activity);
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
