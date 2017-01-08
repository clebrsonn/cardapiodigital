package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Mesa;

public class MesasActivity extends AppCompatActivity implements MesaFragment.OnFragmentInteractionListener,NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {


    List<Mesa> mesas = null;

    Mesa mesa;

//    MesaFragment mesafragmento = new MesaFragment();
//
    Fragment fragmentomesa = null;
//
//    public Fragment getFragmentomesa() {
//        return fragmentomesa;
//    }
//
    public android.support.v4.app.FragmentTransaction fragTransact;

     ScrollView sv = null;

      HorizontalScrollView hsv = null;

    GridLayout gl = null;

    ImageView imgmesa;

    TextView tx = null;

    MesaFragment fragment=null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mesas_activity);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbarsetSupportActionBar(toolbar);

        mesas = getIntent().getParcelableArrayListExtra("mesas");

        mesa = getIntent().getParcelableExtra("mesa");

        sv = (ScrollView)findViewById(R.id.sv);

        hsv = (HorizontalScrollView)findViewById(R.id.hsv);

        gl = (GridLayout)findViewById(R.id.gl);

        imgmesa = (ImageView) findViewById(R.id.imgmesa);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        fragTransact = fm.beginTransaction();


//
         fragment = MesaFragment.newInstance(mesa);
//
//
        fragTransact.replace(R.id.lay,fragment);
        fragTransact.hide(fragment);
        fragTransact.commit();

        tx = (TextView) findViewById(R.id.txttestefragment);

//        fragTransact = getFragmentManager().beginTransaction();

//        imgViewMesa2 = (ImageView) findViewById(R.id.imageViewMesa);
//        imgViewMesa3 = (ImageView) findViewById(R.id.imageViewMesaa);

//        imgViewMesa3 = (ImageView) findViewById(R.id.imageViewMesaa);
//        Fragment fr = new Fragment();
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.add(R.id.fragmesas, fr);
//        fragmentTransaction.show(fr);
//        fragmentTransaction.commit();


//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.lay, new MesaFragment(),"TAG")
//                .commit();


//        layoutLinear = (LinearLayout)findViewById(R.id.content_mesas);


//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


//        final ScrollView sv = new ScrollView(this);
//        sv.setHorizontalScrollBarEnabled(true);
//        sv.fullScroll(ScrollView.TEXT_DIRECTION_FIRST_STRONG_RTL);
//        sv.arrowScroll(2);

//        sv.setOverScrollMode( );
//        LinearLayout.LayoutParams lpsv = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        sv.setLayoutParams(lpsv);


//        sv.setScrollBarSize(View.SCROLLBARS_INSIDE_OVERLAY);

//        final HorizontalScrollView hsv = new HorizontalScrollView(this);

//        hsv.setLayoutParams(lpsv);
//
//        sv.addView(hsv);


//        final GridLayout gl = new GridLayout(this);

//            hsv.addView(gl);


        for (int i = 0; i < mesas.size(); i++) {



            for (int j = 0; j < mesas.size(); j++) {

//                    while((mesas.size() == j) && (i >= 2 ) ) {
//
//                        i=0;
//                        j=mesas.size();
//
//                    }
                GridLayout.Spec linha = GridLayout.spec(0, 2, 2);
                GridLayout.Spec coluna = GridLayout.spec(j);
                GridLayout.LayoutParams lp = new GridLayout.LayoutParams(linha, coluna);
                lp.setGravity(Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK);
//
//                int soma = (gl.getRowCount() + (mesas.size())/2);
//
//                Log.d("j", String.valueOf(j));
//
//                Log.d("i", String.valueOf(i));


//                Log.d("SOMA", String.valueOf(soma));

                final String status = mesas.get(j).getStatus().toString();

                ImageView imgv = new ImageView(this);

                if (Objects.equals(status, ",Disponivel")) {
//                layoutLinear.removeAllViews();

                    imgv.setImageResource(R.drawable.mesa_on);
//                layoutLinear2.addView(imgViewMesa2);
                    gl.addView(imgv,lp);

                    Log.d("Staus:-", mesas.get(j).getStatus());

//                layoutLinear.removeViews(View.);


                }//disponivel

                if (Objects.equals(status, ",Indisponivel")) {
//                layoutLinear.removeAllViews();

//                layoutLinear.removeView(imgViewMesa2);

                    imgv.setImageResource(R.drawable.mesa_of);
                    gl.addView(imgv,lp);
//                layoutLinear.addView(layoutLinear3);
                    Log.d("status:-", mesas.get(j).getStatus());

//                layoutLinear.removeAllViews();


                } //indisponivel

           final Mesa mesa = new Mesa();


                Log.d("mesa:-", mesas.get(j).getNumero());

                mesa.setId(mesas.get(j).getId());
                mesa.setNumero(mesas.get(j).getNumero());
                mesa.setStatus(mesas.get(j).getStatus());

//            final int finalI = i;
                final int finalI = j;

                imgv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(getBaseContext(), "Mesa:" + mesas.get(finalI).getNumero(), Toast.LENGTH_SHORT).show();



                        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

//                        MesaFragment fragment = MesaFragment.newInstance(mesa);

                        fragTransact = fm.beginTransaction();


                        if(fragment.isVisible()){

                            Log.d("fragment is visible", String.valueOf(fragment.isVisible()));
                            fragTransact.replace(R.id.lay,fragment);
                            fragTransact.hide(fragment);
                            fragTransact.commit();

                        }if(fragment.isHidden()){

                            Log.d("fragment is hidden", String.valueOf(fragment.isHidden()));
                            fragTransact.replace(R.id.lay,fragment);
                            fragTransact.show(fragment);
                            fragTransact.commit();


                        }

//        fragmentomesa = (Fragment) getFragmentManager().findFragmentById(R.id.fragmesa);







//                        FragmentTransaction fragTransact2 = getFragmentManager().beginTransaction();
//
//
//                        fragTransact2.replace(R.id.content_mesas,fragmentomesa);
//
//                            fragTransact2.commit();
//

//                        fragTransact = getFragmentManager().beginTransaction();
//
//                        if(fragmentomesa.isVisible()){
//
//                            fragTransact.hide(fragmentomesa);
//                        }else{
//
//                            fragTransact.show(fragmentomesa);
//                        }
//
//                        fragTransact.commit();



                    }


                });


            }//j



        }//i

//        fragTransact.commit();


//        layoutLinear.addView(sv);
//        setContentView(sv);

//        fragTransact.commit();

    } //oncreate


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }


    @Override
    public void onClick(View view) {
        Log.d("antesFragment", "antes");

       FragmentTransaction fragTransact2 = getFragmentManager().beginTransaction();

        switch (view.getId()) {

            case R.id.imgmesa:
//                Log.d("windson dentu Fragment", "wind  fab frag0");
//                Toast.makeText(view.getContext(),
//                        "Mesa Disponivel!", Toast.LENGTH_SHORT).show();
//
//                if(fragmentomesa.isVisible()){
//
//                    fragTransact2.hide(fragmentomesa);
//                }else{
//
//                    fragTransact2.show(fragmentomesa);
//                }
//
//                fragTransact2.commit();

                break;


            case R.drawable.mesa_of:
//                Log.d("windson  generofrag", "wind dentu generofrag");
                Toast.makeText(view.getContext(),
                        "Mesa Indisponivel!", Toast.LENGTH_SHORT).show();
                break;

//            case R.id.toggleGeneroWom:
//                Log.d("windson dentugenerofrag", "wind generofragf");
//                Toast.makeText(this.getContext(),
//                        "Button is generofrag!", Toast.LENGTH_LONG).show();
//                break;
//
//            case R.id.toggleOrienracaoSex:
//                Log.d("windson  orientafrag", "wind  orientafrag");
//                Toast.makeText(this.getContext(),
//                        "Button is orientafrag!", Toast.LENGTH_LONG).show();
//                break;
//
//            case R.id.toggleTrans:
//                Log.d("windson transfrag", "wind transfrag");
//                Toast.makeText(this.getContext(),
//                        "Button is transfrag!", Toast.LENGTH_LONG).show();
//                break;

//                case R.id.fab2:
//                    Log.d("windson dentu trans", "wind dentu4");
//
//                    if (fragpesquisa.isVisible()) {
//                        FragmentTransaction ft2 = getFragmentManager().beginTransaction();
//
//                        ft2.hide(fragpesquisa);
//                    }
//
//                    break;
//
            default:
                Log.d("Fragmentdefault", "Fragmentdefault");
                Toast.makeText(view.getContext(),
                        "Mesa default!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
