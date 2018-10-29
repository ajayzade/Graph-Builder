package applications.graph.lenovo.graphbuilder;

import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.lenovo.graphbuilder.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class EquationalActivity extends AppCompatActivity {

    Spinner spin;
    GraphView graphView;
    LineGraphSeries<DataPoint> s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    String[] equations = new String[] {
            "sin(x)",
            "x^2 + x + 5 (Quadratic)",
            "y = 2x + 3 (straight line)",
            "x^3 + x^2 + x + 1 (cubic)",
            "cos(x)",
            "tan(x)",
            "|x| (Mod x)",
            "cot(x) ",
            "sec(x) ",
            "cosec(x) "
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equational);
        spin = (Spinner) findViewById(R.id.spinner);
        graphView = (GraphView) findViewById(R.id.eq_graph);
        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setScrollableY(true);
        graphView.getViewport().setScalable(true);
        graphView.getViewport().setScalableY(true);
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setYAxisBoundsManual(true);
        s1 = new LineGraphSeries<DataPoint>();
        s2 = new LineGraphSeries<DataPoint>();
        s3 = new LineGraphSeries<DataPoint>();
        s4 = new LineGraphSeries<DataPoint>();
        s5 = new LineGraphSeries<DataPoint>();
        s6 = new LineGraphSeries<DataPoint>();
        s7 = new LineGraphSeries<DataPoint>();
        s8 = new LineGraphSeries<DataPoint>();
        s9 = new LineGraphSeries<DataPoint>();
        s10 = new LineGraphSeries<DataPoint>();
        s1.setDrawBackground(true);
        s1.setThickness(10);
        s2.setDrawBackground(true);
        s2.setThickness(10);
        s3.setDrawBackground(true);
        s3.setThickness(10);
        s4.setDrawBackground(true);
        s4.setThickness(10);
        s5.setDrawBackground(true);
        s5.setThickness(10);
        s6.setDrawBackground(true);
        s6.setThickness(10);
        s7.setDrawBackground(true);
        s7.setThickness(10);
        s8.setDrawBackground(true);
        s8.setThickness(10);
        s9.setDrawBackground(true);
        s9.setThickness(10);
        s10.setDrawBackground(true);
        s10.setThickness(10);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,equations);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                spin.setSelection(pos);
                if(pos == 0){
                    graphView.removeAllSeries();
                    sin();
                }
                if(pos == 1){
                    graphView.removeAllSeries();
                    quadratic();
                }
                if(pos == 2){
                    graphView.removeAllSeries();
                    straightLine();
                }
                if(pos == 3){
                    graphView.removeAllSeries();
                    cubic();
                }
                if(pos == 4){
                    graphView.removeAllSeries();
                    cos();
                }
                if(pos == 5){
                    graphView.removeAllSeries();
                    tan();
                }
                if(pos == 6){
                    graphView.removeAllSeries();
                    modX();
                }
                if (pos == 7){
                    graphView.removeAllSeries();
                    cot();
                }
                if (pos == 8){
                    graphView.removeAllSeries();
                    sec();
                }
                if (pos == 9){
                    graphView.removeAllSeries();
                    cosec();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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
        AlertDialog.Builder builder = new AlertDialog.Builder(EquationalActivity.this);
        View v = getLayoutInflater().inflate(R.layout.dialog,null);
        RadioButton rb1 = (RadioButton) v.findViewById(R.id.radioButton1);
        RadioButton rb2 = (RadioButton) v.findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) v.findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton) v.findViewById(R.id.radioButton4);
        RadioButton rb5 = (RadioButton) v.findViewById(R.id.radioButton5);
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        final LinearLayout l = (LinearLayout) findViewById(R.id.equational_activity);
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
    public void sin(){
        double x,y;
        x = -5.0;
        for(int i = 0;i < 500;i++){
            x = x + 0.1;
            y = Math.sin(x);
            s1.appendData(new DataPoint(x,y),true,500);
        }
        graphView.addSeries(s1);
        graphView.getViewport().setMinX(-20);
        graphView.getViewport().setMaxX(20);
        graphView.getViewport().setMinY(-10);
        graphView.getViewport().setMaxY(10);
    }
    public void quadratic(){
        double x,y;
        for (int i=0;i<500;i++){
            x = i;
            y = x*x + x + 5;
            s2.appendData(new DataPoint(x,y),true,500);
        }
        graphView.addSeries(s2);
        graphView.getViewport().setMinX(-100);
        graphView.getViewport().setMaxX(100);
        graphView.getViewport().setMinY(-100);
        graphView.getViewport().setMaxY(100);
    }
    public void straightLine(){
        double x,y;
        for (int i=0;i<500;i++){
            x = i;
            y = 2*x + 3;
            s3.appendData(new DataPoint(x,y),true,500);
        }
        graphView.addSeries(s3);
        graphView.getViewport().setMinX(-100);
        graphView.getViewport().setMaxX(100);
        graphView.getViewport().setMinY(-100);
        graphView.getViewport().setMaxY(100);
    }
    public void cubic(){
        double x,y;
        for (int i=0;i<500;i++){
            x = i;
            y = x*x*x + x*x + x + 1;
            s4.appendData(new DataPoint(x,y),true,500);
        }
        graphView.addSeries(s4);
        graphView.getViewport().setMinX(-100);
        graphView.getViewport().setMaxX(100);
        graphView.getViewport().setMinY(-100);
        graphView.getViewport().setMaxY(100);
    }
    public void cos(){
        double x,y;
        x = -5.0;
        for (int i=0;i<500;i++){
            x = x + 0.1;
            y = Math.cos(x);
            s5.appendData(new DataPoint(x,y),true,500);
        }
        graphView.addSeries(s5);
        graphView.getViewport().setMinX(-20);
        graphView.getViewport().setMaxX(20);
        graphView.getViewport().setMinY(-10);
        graphView.getViewport().setMaxY(10);
    }
    public void tan(){
        double x,y;
        x = -5.0;
        for(int i=0;i<500;i++){
            x = x + 0.1;
            y = Math.tan(x);
            s6.appendData(new DataPoint(x,y),true,500);
        }
        graphView.addSeries(s6);
        graphView.getViewport().setMinX(-20);
        graphView.getViewport().setMaxX(20);
        graphView.getViewport().setMinY(-20);
        graphView.getViewport().setMaxY(20);
    }
    public void cot(){
        double x,y;
        x = -5.0;
        for(int i=0;i<500;i++){
            x = x + 0.1;
            y = (1/(Math.tan(x)));
            s8.appendData(new DataPoint(x,y),true,500);
        }
        graphView.addSeries(s8);
        graphView.getViewport().setMinX(-20);
        graphView.getViewport().setMaxX(20);
        graphView.getViewport().setMinY(-20);
        graphView.getViewport().setMaxY(20);
    }
    public void sec(){
        double x,y;
        x = -5.0;
        for(int i=0;i<500;i++){
            x = x + 0.1;
            y = (1/(Math.cos(x)));
            s9.appendData(new DataPoint(x,y),true,500);
        }
        graphView.addSeries(s9);
        graphView.getViewport().setMinX(-20);
        graphView.getViewport().setMaxX(20);
        graphView.getViewport().setMinY(-20);
        graphView.getViewport().setMaxY(20);
    }
    public void cosec(){
        double x,y;
        x = -5.0;
        for(int i=0;i<500;i++){
            x = x + 0.1;
            y = (1/(Math.sin(x)));
            s10.appendData(new DataPoint(x,y),true,500);
        }
        graphView.addSeries(s10);
        graphView.getViewport().setMinX(-20);
        graphView.getViewport().setMaxX(20);
        graphView.getViewport().setMinY(-20);
        graphView.getViewport().setMaxY(20);
    }
    public void modX(){
        double x,y;
        x = -2;
        for(int i=0;i<1000;i++){
            x = x + 0.1;
            if(x < 0){
                y = -(x);
            }
            else{
                y = x;
            }
            if(x == 2){
                break;
            }
            s7.appendData(new DataPoint(x,y),true,1000);
        }
        graphView.addSeries(s7);
        graphView.getViewport().setYAxisBoundsManual(false);
        graphView.getViewport().setXAxisBoundsManual(false);
    }
}
