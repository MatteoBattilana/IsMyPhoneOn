package ismyphoneon.battilanamatteo.com.ismyphoneon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView txt_yes,txt_req;
    RelativeLayout mRelativeLayout;
    Typeface roboto_Thin,roboto_LightItalic;
    Animation anim;
    int tap_count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.content_main);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.view);
        txt_yes = (TextView) findViewById(R.id.txt_yes);
        txt_req = (TextView) findViewById(R.id.txt_req);
        roboto_Thin = Typeface.createFromAsset(getResources().getAssets(), "Roboto-Thin.ttf");
        roboto_LightItalic = Typeface.createFromAsset(getResources().getAssets(), "Roboto-LightItalic.ttf");
        txt_yes.setTypeface(roboto_Thin);
        txt_req.setTypeface(roboto_LightItalic);
        anim = AnimationUtils.loadAnimation(this, R.anim.fadein);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_yes.startAnimation(anim);
            }
        }, 100);

        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tap_count > 1) {
                    //Start Activity
                    Intent myIntent = new Intent(MainActivity.this, InfoActivity.class);
                    startActivity(myIntent);
                    tap_count = 0;
                } else
                    tap_count++;
            }
        });
    }
}
