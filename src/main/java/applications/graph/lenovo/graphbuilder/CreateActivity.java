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
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class CreateActivity extends AppCompatActivity {

    EditText edit1,edit2;
    Button drawButton,clearButton;
    TextView pointsText;
    GraphView graphView,graphView2;
    LineGraphSeries<DataPoint> lineGraphSeries;
    BarGraphSeries<DataPoint> barGraphSeries;
    ArrayList<XYValue> xyValueArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        edit1 = (EditText) findViewById(R.id.value_1);
        edit2 = (EditText) findViewById(R.id.value_2);
        drawButton = (Button) findViewById(R.id.btn);
        pointsText = (TextView) findViewById(R.id.show_value);
        graphView = (GraphView) findViewById(R.id.graph);
        graphView2 = (GraphView) findViewById(R.id.bar_graph);
        xyValueArray = new ArrayList<XYValue>();
        init();
        clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pointsText.setText("");
                edit2.setText("");
                edit1.setText("");
                graphView.removeAllSeries();
                graphView2.removeAllSeries();
            }
        });
    }
    private void init(){
        lineGraphSeries = new LineGraphSeries<DataPoint>();
        barGraphSeries = new BarGraphSeries<DataPoint>();
        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edit1.getText().toString().equals("") && !edit2.getText().toString().equals("")){
                    double x = Double.parseDouble(edit1.getText().toString());
                    double y = Double.parseDouble(edit2.getText().toString());
                    xyValueArray.add(new XYValue(x,y));
                    edit1.setText("");
                    edit2.setText("");
                    pointsText.setText(pointsText.getText()+"\t\t\t\t"+x+"\t\t\t\t\t\t\t\t\t\t"+y+"\n");
                    init();
                }
            }
        });
        if (xyValueArray.size()!=0){
            createPoints();
        }
    }
    private void createPoints(){
        xyValueArray = sortArray(xyValueArray);
        for(int i=0;i<xyValueArray.size();i++){
            try{
                double x = xyValueArray.get(i).getX();
                double y = xyValueArray.get(i).getY();
                lineGraphSeries.appendData(new DataPoint(x,y),true,20);
                barGraphSeries.appendData(new DataPoint(x,y),true,20);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        lineGraphSeries.setDrawDataPoints(true);
        lineGraphSeries.setColor(Color.RED);
        lineGraphSeries.setThickness(10);
        lineGraphSeries.setDataPointsRadius(20);
        lineGraphSeries.setDrawBackground(true);
        lineGraphSeries.setTitle("LINE GRAPH");
        barGraphSeries.setValuesOnTopColor(Color.YELLOW);
        barGraphSeries.setDrawValuesOnTop(true);
        barGraphSeries.setSpacing(5);
        barGraphSeries.setTitle("BAR GRAPH");
        barGraphSeries.setDataWidth(10);
        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setScalable(true);
        graphView.setBackgroundColor(Color.WHITE);
        graphView.getViewport().setScrollableY(true);
        graphView.getViewport().setDrawBorder(true);
        graphView.getViewport().setScalableY(true);
        graphView2.getViewport().setScalableY(true);
        graphView2.getViewport().setScalable(true);
        graphView2.getViewport().setScrollableY(true);
        graphView2.getViewport().setScrollable(true);
        graphView2.setBackgroundColor(Color.WHITE);

        graphView.addSeries(lineGraphSeries);
        graphView2.addSeries(barGraphSeries);
    }
    private ArrayList<XYValue> sortArray(ArrayList<XYValue> array){
        int factor = Integer.parseInt(String.valueOf(Math.round(Math.pow(array.size(),2))));
        int m = array.size() - 1;
        int count = 0;

        while(true){
            m--;
            if (m <=0 ){
                m = array.size() - 1;
            }
            try{
                double tempX = array.get(m - 1).getX();
                double tempY = array.get(m - 1).getY();
                if(tempX > array.get(m).getX()){
                    array.get(m - 1).setX(array.get(m).getX());
                    array.get(m).setX(tempX);
                    array.get(m - 1).setY(array.get(m).getY());
                    array.get(m).setY(tempY);
                }
                else if(tempX == array.get(m).getX()){
                    count++;
                }
                else if(array.get(m).getX() > array.get(m - 1).getX()){
                    count++;
                }
                if (count == factor){
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
                break;
            }
        }
        return array;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(CreateActivity.this);
        View v = getLayoutInflater().inflate(R.layout.dialog,null);
        RadioButton rb1 = (RadioButton) v.findViewById(R.id.radioButton1);
        RadioButton rb2 = (RadioButton) v.findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) v.findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton) v.findViewById(R.id.radioButton4);
        RadioButton rb5 = (RadioButton) v.findViewById(R.id.radioButton5);
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        final LinearLayout l = (LinearLayout) findViewById(R.id.create_activity);
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
