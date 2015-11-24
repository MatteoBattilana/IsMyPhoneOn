package ismyphoneon.battilanamatteo.com.ismyphoneon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends Activity {
    TextView txt_title;
    Typeface roboto_LightItalic, fontawesome;
    Animation anim;
    Button btn_git;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.info_activity);
        txt_title=(TextView)findViewById(R.id.txt_title);
        btn_git=(Button)findViewById(R.id.btn_git);
        roboto_LightItalic = Typeface.createFromAsset(getResources().getAssets(), "Roboto-LightItalic.ttf");
        fontawesome = Typeface.createFromAsset(getResources().getAssets(), "fontawesome-webfont.ttf");
        txt_title.setTypeface(roboto_LightItalic);
        btn_git.setTypeface(fontawesome);
        anim = AnimationUtils.loadAnimation(this, R.anim.fadein);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btn_git.startAnimation(anim);
            }
        }, 100);

        btn_git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/matbat96/IsMyPhoneOn"));
                startActivity(browserIntent);
            }
        });



    }


}
