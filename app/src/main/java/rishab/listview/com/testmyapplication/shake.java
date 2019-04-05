package rishab.listview.com.testmyapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class shake extends AppCompatActivity {

    private Button shakesve,shakeback;
    private SeekBar shakeseekabar;
    private TextView shaketextView;
    private int noofshake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        shaketextView=findViewById(R.id.shaketext);
        shakeseekabar=findViewById(R.id.seekbarshake);
        shakesve=findViewById(R.id.shakesave);
        shakeback=findViewById(R.id.shakeback);
        shakeseekabar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress=progress+50;
                noofshake=progress;
                int max=shakeseekabar.getMax()+50;
                shaketextView.setText(+progress+"/"+max);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        shakeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onbackse();
            }
        });
        shakesve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuActivity m = new MenuActivity();
                m.setDatanoofshakes(noofshake);
                finish();
                Intent intent=new  Intent(shake.this,MenuActivity.class);
                startActivity(intent);
            }
        });

    }
    void onbackse(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);


        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                MenuActivity m = new MenuActivity();
                m.setDatanoofshakes(noofshake);
                Intent intent=new  Intent(shake.this,MenuActivity.class);
                startActivity(intent);

            }
        });

        alertDialog.setNegativeButton("No",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Intent intent=new  Intent(shake.this,shake.class);
                startActivity(intent);
            }
        });

        alertDialog.setMessage("Do you want save changes ?");
        alertDialog.setTitle("Save");
        alertDialog.show();
    }
}
