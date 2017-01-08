package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Categoria;
import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Produto;

/**
 * Created by winds on 15/05/2016.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    private int[] images_resources_combos={R.drawable.barca,R.drawable.barca,R.drawable.barca,R.drawable.barca};
    private int[] images_resources_bebidas={R.drawable.coca,R.drawable.refrigerante,R.drawable.coca,R.drawable.refrigerante};
//    private int[] images_resources_sushi={R.drawable.refrigerante,R.drawable.barca,R.drawable.coca,R.drawable.sushi_back_g};
    private int[] images_resources_sobremesa={R.drawable.barca,R.drawable.barca,R.drawable.coca,R.drawable.sushi_back_g};
    private int[] images_resources_sushi={R.drawable.coca,R.drawable.barca,R.drawable.coca,R.drawable.sushi_back_g};
    private int[] images_resources_temaki={R.drawable.sushi_back_g,R.drawable.barca,R.drawable.coca,R.drawable.sushi_back_g};

    private Context contexo;

    private LayoutInflater layoutinflater;

    private List<Produto> listaProduto= null;

    private List<Categoria> categorias;

    private Categoria categoria =  new Categoria();

//    private  String categoriaEscolhida="";

    //construtor
    public CustomSwipeAdapter(Context ctx){

        this.contexo=ctx;


    }

//    public String getCategoriaEscolhida() {
//        return categoriaEscolhida;
//    }

    public CustomSwipeAdapter(Context ctx, List<Produto> listaProd,Categoria categoria){

        this.contexo=ctx;
        this.listaProduto = listaProd;
        this.categoria = categoria;



    }


    @Override
    public int getCount() {
        return listaProduto.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutinflater = (LayoutInflater)contexo.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView =layoutinflater.inflate(R.layout.swipe_layout,container,false);

        TextView numero =(TextView)itemView.findViewById(R.id.txtnumeropagina);
        ImageView img = (ImageView)itemView.findViewById(R.id.imageviewproduto);
        TextView descricao =(TextView)itemView.findViewById(R.id.txtprodutodescricao);
        TextView preco =(TextView)itemView.findViewById(R.id.txtprodutopreco);

//        img.setImageResource("images_resources_"+categoriaEscolhida.toLowerCase()[position]);


//        Toast.makeText(container.getContext(),categoriaEscolhida+"",Toast.LENGTH_SHORT).show();

        if ((categoria.getNome() == null)||(categoria.getNome()=="")){
            img.setImageResource(images_resources_bebidas[position]);

            Log.d("categoria nulla", "categoria nulla");


        }else {

            if (categoria.getNome().equals("COMBOS") ){
                img.setImageResource(images_resources_combos[position]);
                Log.d("combo", "combo passou");

            }

            if (categoria.getNome().equals("BEBIDAS")) {
                img.setImageResource(images_resources_bebidas[position]);
                Log.d("bebidas", " bebidas");
            }

            if (categoria.getNome().equals("SOBREMESAS")) {
                img.setImageResource(images_resources_sobremesa[position]);
                Log.d("SOBREMESAS", " SOBREMESAS");
            }

            if (categoria.getNome().equals("SUSHI")) {
                img.setImageResource(images_resources_sushi[position]);
                Log.d("SUSHI", "SUSHI");
            }

            if (categoria.getNome().equals("TEMAKIS")) {
                img.setImageResource(images_resources_temaki[position]);
                Log.d("TEMAKIS", "TEMAKIS");
            }

            if (categoria.getNome().equals("petisco")) {
                img.setImageResource(images_resources_temaki[position]);
                Log.d("PETISCO", "PETISCO");
            }



            Log.d("else", "else");
        }

        Log.d("depois", "depois");


        numero.setText(":"+ position);
        descricao.setText(":" + listaProduto.get(position).getDescricao().toString());
        preco.setText(":"+ listaProduto.get(position).getPrecoVenda());
        container.addView(itemView);


        Button btAdd = (Button) itemView.findViewById(R.id.buttonAddPedido);
        btAdd.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent it = new Intent(view.getContext(), PedidoActivity.class);
//        it.putExtra("idcategoria",10L);
                contexo.startActivity(it);

            }
        });

        Button btFechar = (Button) itemView.findViewById(R.id.buttonfecharpedido);
        Button btPromo = (Button) itemView.findViewById(R.id.buttonPromo);



//      img.setImageResource(images_resources_bebidas[position]);



        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
        object = new Object();

    }

//    public void AddPedido(ViewGroup container, int position, Object object) {
//        container.removeView((LinearLayout)object);
//        object = new Object();
//
//
//        Intent it = new Intent(container.getContext(), PedidoActivity.class);
////        it.putExtra("idcategoria",10L);
//        contexo.startActivity(it);
//        Log.d("passou sushiswper",object.toString());
//
//    }
}
