package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Produto;

/**
 * Created by winds on 15/05/2016.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    private int[] images_resources={R.drawable.mesaasair,R.drawable.mesa,R.drawable.mesaocupada,R.drawable.logoperfil};

    private Context contexo;

    private LayoutInflater layoutinflater;

    private List<Produto> listaProduto= null;



    //construtor
    public CustomSwipeAdapter(Context ctx){

        this.contexo=ctx;


    }

    public CustomSwipeAdapter(Context ctx, List<Produto> listaProd){

        this.contexo=ctx;
        this.listaProduto = listaProd;


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




        Button btAdd = (Button) itemView.findViewById(R.id.buttonAddPedido);
        Button btFechar = (Button) itemView.findViewById(R.id.buttonfecharpedido);
        Button btPromo = (Button) itemView.findViewById(R.id.buttonPromo);

        img.setImageResource(images_resources[position]);
        numero.setText(":"+ position);
        descricao.setText(":" + listaProduto.get(position).getDescricao().toString());
        preco.setText(":"+ listaProduto.get(position).getPrecoVenda());
        container.addView(itemView);


        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
        object = new Object();

    }
}
