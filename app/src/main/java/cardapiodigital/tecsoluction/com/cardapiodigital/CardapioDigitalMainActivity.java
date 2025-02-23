package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import cardapiodigital.tecsoluction.com.cardapiodigital.servicos.GarconServico;

public class CardapioDigitalMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cardapio_digital);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ListView listCategoria = (ListView) findViewById(R.id.lst_categoria);
        //arraayadapter para lista
        ArrayList<String> listacategoriaarray = new ArrayList<String>();
        //chamando funcao para preencher a lista
        listacategoriaarray = preencherDados();
        //associando o adapter a um layout e passando por parametro a lista
        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,listacategoriaarray);
        listCategoria.setAdapter(arrayadapter);
        //botão de apbir pedido
        //  Button bt =(Button)findViewById(R.id.mesa);

        //final para poder passar por parametro no toast
        final ArrayList<String> finalListacategoriaarray = listacategoriaarray;
        listCategoria.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String categoriaEscolhida = finalListacategoriaarray.get(position).toString();

                Toast.makeText(getApplicationContext(), "Categoria:" + categoriaEscolhida, Toast.LENGTH_LONG).show();
                {


                    switch (position) {

                        case 0:

                            Intent it = new Intent(CardapioDigitalMainActivity.this, Sushi.class);
                            startActivity(it);
                            break;


                        case 1:

                            Intent it2 = new Intent(CardapioDigitalMainActivity.this, Sushi.class);
                            startActivity(it2);
                            break;


                        case 2:

                            Intent it3 = new Intent(CardapioDigitalMainActivity.this, Sushi.class);
                            startActivity(it3);
                            break;

                        case 3:
                            Intent it4 = new Intent(CardapioDigitalMainActivity.this, Sushi.class);
                            startActivity(it4);
                            break;

                        case 4:
                            Intent it5 = new Intent(CardapioDigitalMainActivity.this, Sushi.class);
                            startActivity(it5);
                            break;
                    }

                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_cardapio_digital, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_galleryy) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_managee) {


        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


    private final  ArrayList<String> preencherDados(){

        ArrayList<String> dados = new ArrayList<String>();

        GarconServico gs = new GarconServico();
        String json = gs.ObterListagemGarcon();

//       List<GarconServico> listgarconServico = new ArrayList<>();
        System.out.print("lalallal"+json);

        dados.add(json.toString());
        dados.add("Combos");
        dados.add("Sobremesas");
        dados.add("Sushi");
        dados.add("Temakis");


        return dados;
    }


}
