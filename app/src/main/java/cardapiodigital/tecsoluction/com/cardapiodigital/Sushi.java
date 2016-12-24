package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Produto;

public class Sushi extends Activity {


    ViewPager viewpager;
    CustomSwipeAdapter adapter;
    List<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sushi_activity);

        produtos  = (List<Produto>) getIntent().getSerializableExtra("produtos");

//        Bundle bundle = new Bundle();
//        Intent intent = getIntent();
//        bundle = intent.getBundleExtra("produtos");

        viewpager = (ViewPager) findViewById(R.id.viewpagesushi);
        adapter = new CustomSwipeAdapter(this,produtos);
        viewpager.setAdapter(adapter);



    }
}
