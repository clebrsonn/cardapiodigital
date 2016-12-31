package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Promocao;

public class PromocaoActivity extends Activity {


    ViewPager viewpager;
    CustomSwipeAdapterPromocao adapter;
    List<Promocao> promocoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promocao_activity);

        promocoes  = (List<Promocao>) getIntent().getSerializableExtra("promo");


        viewpager = (ViewPager) findViewById(R.id.viewpagepromocao);
        adapter = new CustomSwipeAdapterPromocao(this,promocoes);
        viewpager.setAdapter(adapter);



    }

//    public void AddPedido(ViewGroup container, int position, Object object) {
////        container.removeView((LinearLayout)object);
//        Produto produto = (Produto) object;
//
//
//        Intent it = new Intent(container.getContext(), PedidoActivity.class);
//        it.putExtra("produto",produto);
//        Log.d("passou sushi add pedido",produto.toString());
//        startActivity(it);
//
//    }
}
