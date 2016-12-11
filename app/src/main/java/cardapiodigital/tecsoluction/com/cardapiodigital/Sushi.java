package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class Sushi extends Activity {


    ViewPager viewpager;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sushi_activity);

        viewpager = (ViewPager) findViewById(R.id.viewpagesushi);
        adapter = new CustomSwipeAdapter(this);
        viewpager.setAdapter(adapter);



    }
}
