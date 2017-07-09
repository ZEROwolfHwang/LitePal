package wolf.zero.litepal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NextRetrofitActivity extends AppCompatActivity {

    private TextChangeLisenner mLisenner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_retrofit);
       /* Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        Log.i(RetrofitDemoActivity.TAG, "onCreate: "+text);*/
        final TextView textView = (TextView) findViewById(R.id.text_next);

        mLisenner.textChange(textView);
    }

    public interface TextChangeLisenner {
        void textChange(TextView textView );
    }

    public void setTextChangeLisenner(TextChangeLisenner lisenner) {
        mLisenner = lisenner;
    }

}
