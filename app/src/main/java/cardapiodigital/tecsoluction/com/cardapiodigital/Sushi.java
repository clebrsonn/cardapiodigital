package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Categoria;
import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Produto;

public class Sushi extends Activity {


    ViewPager viewpager;
    CustomSwipeAdapter adapter;
    List<Produto> produtos;
    List<Categoria> categorias = new ArrayList<Categoria>();

    Categoria categoria = new Categoria();
    String  categoriaEscolhida2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sushi_activity);

        produtos  = (List<Produto>) getIntent().getSerializableExtra("produtos");
        categorias = (List<Categoria>) getIntent().getSerializableExtra("categorias");
        categoriaEscolhida2 = (String)getIntent().getSerializableExtra("categoriaEscolhida");
//        Bun bundle = new Bundle();
//        Intent intent = getIntent();
//        bundle = intent.getBundleExtra("produtos");

        viewpager = (ViewPager) findViewById(R.id.viewpagesushi);
        adapter = new CustomSwipeAdapter(this,produtos,categoriaEscolhida2);
        viewpager.setAdapter(adapter);



    }

    public void AddPedido(ViewGroup container, int position, Object object) {
//        container.removeView((LinearLayout)object);
        Produto produto = (Produto) object;


        Intent it = new Intent(container.getContext(), PedidoActivity.class);
        it.putExtra("produto",produto);
        Log.d("passou sushi add pedido",produto.toString());
        startActivity(it);

    }
}
