package ng.joeydalu.android.samples.viewpager.gui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import ng.joeydalu.android.samples.viewpager.R;
import ng.joeydalu.android.samples.viewpager.gui.fragment.FragmentWithFragments;

public class Activity extends AppCompatActivity {

    /** button, when clicked would open the {@link ActivityWithFragments} activity */
    private Button btnActivity;

    /** button, when clicked would open the {@link ng.joeydalu.android.samples.viewpager.gui.fragment.FragmentWithFragments} fragment */
    private Button btnFragment;

    /** says foo :D */
    private ImageButton btnLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        //find views
        btnActivity = (Button) findViewById(R.id.btnActivity);
        btnFragment = (Button) findViewById(R.id.btnFragment);
        btnLogo = (ImageButton) findViewById(R.id.btnLogo);


        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.container, FragmentWithFragments.newInstance())
                        .addToBackStack(null).commitAllowingStateLoss();
            }
        });
        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity.this, ActivityWithFragments.class);
                startActivity(intent);
            }
        });

        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity.this, "foo :D", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
