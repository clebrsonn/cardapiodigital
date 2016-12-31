package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Promocao;

/**
 * Created by winds on 15/05/2016.
 */
public class CustomSwipeAdapterPromocao extends PagerAdapter {

    private int[] images_resources={R.drawable.promocao,R.drawable.promocaoo};

    private Context contexo;

    private LayoutInflater layoutinflater;

    private List<Promocao> listaPromocao= null;



    //construtor
    public CustomSwipeAdapterPromocao(Context ctx){

        this.contexo=ctx;


    }

    public CustomSwipeAdapterPromocao(Context ctx, List<Promocao> listaPromo){

        this.contexo=ctx;
        this.listaPromocao = listaPromo;


    }


    @Override
    public int getCount() {
        return listaPromocao.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutinflater = (LayoutInflater)contexo.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView =layoutinflater.inflate(R.layout.swipe_layout_promocao,container,false);

        TextView numero =(TextView)itemView.findViewById(R.id.txtpromocaonumero);
        ImageView img = (ImageView)itemView.findViewById(R.id.imageviewpromocao);
        TextView nome =(TextView)itemView.findViewById(R.id.txtpromocaonome);
        TextView datainicio =(TextView)itemView.findViewById(R.id.txtpromocaodatainicio);
        TextView datafim =(TextView)itemView.findViewById(R.id.txtpromocaodatafim);




//        Button btAdd = (Button) itemView.findViewById(R.id.buttonAddPedido);
//        btAdd.setOnClickListener(new View.OnClickListener() {
//
//
//            @Override
//            public void onClick(View view) {
//
//                Intent it = new Intent(view.getContext(), PedidoActivity.class);
////        it.putExtra("idcategoria",10L);
//                contexo.startActivity(it);
//
//            }
//        });

//        Button btFechar = (Button) itemView.findViewById(R.id.buttonfecharpedido);
//        Button btPromo = (Button) itemView.findViewById(R.id.buttonPromo);
//
//        img.setImageResource(images_resources[position]);
//        numero.setText(":"+ position);
//        descricao.setText(":" + listaProduto.get(position).getDescricao().toString());
//        preco.setText(":"+ listaProduto.get(position).getPrecoVenda());
//        container.addView(itemView);


        img.setImageResource(images_resources[position]);
        numero.setText("Numero:"+ listaPromocao.get(position).getNumero());
        nome.setText("Promoção:" + listaPromocao.get(position).getNome());
        datainicio.setText("Data Inicio:"+ listaPromocao.get(position).getDatainicio());
        datafim.setText("Data Fim:"+ listaPromocao.get(position).getDatafim());

        container.addView(itemView);


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
