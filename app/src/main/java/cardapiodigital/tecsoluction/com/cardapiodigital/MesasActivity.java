package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Mesa;

public class MesasActivity extends AppCompatActivity {

        private int[] images_resources={R.drawable.mesaa,R.drawable.mesaa,R.drawable.mesaa,R.drawable.mesaa,R.drawable.mesaa};

    List<Mesa> mesas;

    Mesa mesa;

    List<ImageView> imgViewMesaList;

    ImageView  imgViewMesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.mesas_activity);

        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.HORIZONTAL);
        Toolbar toolbar = new Toolbar(this);
      //  setSupportActionBar(toolbar);
        layout.addView(toolbar);



        mesas = (List<Mesa>) getIntent().getSerializableExtra("mesas");

//        imgViewMesa = (ImageView)findViewById(R.id.imageViewMesa);
//        imgViewMesa.setImageResource(images_resources[1]);


//        LinearLayout layout2 = new LinearLayout(this);
//        layout2.setOrientation(LinearLayout.HORIZONTAL);
//        layout2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        for (int i = 0; i < mesas.size(); i++) {


            imgViewMesa = new ImageView(this);
            imgViewMesa.setImageResource(images_resources[i]);
            imgViewMesa.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
          //  imgViewMesa.setId((int) Long.parseLong("mesa"+i));

            layout.addView(imgViewMesa);
//            layout2.addView(imgViewMesa);


            Log.d("mesa:-",mesas.get(i).getNumero());

//            imgViewMesaList.add(imgViewMesa);

        }

//        layout.addView(layout2);


        setContentView(layout);


    }



}
