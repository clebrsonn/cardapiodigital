package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Mesa;

public class MesasActivity extends AppCompatActivity {

        private int[] images_resources={R.drawable.mesaa,R.drawable.mesaa,R.drawable.mesaa,R.drawable.mesaa,R.drawable.mesaa};

    List<Mesa> mesas;

    Mesa mesa;

    List<ImageView>   imgViewMesaList = new ArrayList<ImageView>();

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

            mesa = new Mesa();

            imgViewMesa = new ImageView(this);
            imgViewMesa.setImageResource(images_resources[i]);
            imgViewMesa.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
          //  imgViewMesa.setId((int) Long.parseLong("mesa"+i));
            imgViewMesaList.add(imgViewMesa);
            layout.addView(imgViewMesa);
//            layout2.addView(imgViewMesa);


            Log.d("mesa:-",mesas.get(i).getNumero());

            mesa.setId(mesas.get(i).getId());
            mesa.setNumero(mesas.get(i).getNumero());
            mesa.setStatus(mesas.get(i).getStatus());


            final int finalI = i;
            imgViewMesa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getBaseContext(),"Mesa:"+ mesas.get(finalI).getNumero(),Toast.LENGTH_SHORT).show();



                }
            });

        }

//        layout.addView(layout2);


        setContentView(layout);


    }



}
