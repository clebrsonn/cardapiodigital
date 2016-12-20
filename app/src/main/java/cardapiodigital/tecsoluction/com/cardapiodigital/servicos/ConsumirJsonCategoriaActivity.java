package cardapiodigital.tecsoluction.com.cardapiodigital.servicos;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.CardapioDigitalMainActivity;
import cardapiodigital.tecsoluction.com.cardapiodigital.R;
import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Categoria;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

import static android.app.AlertDialog.Builder;

/**
 * Created by winds on 17/12/2016.
 */
public class ConsumirJsonCategoriaActivity extends Activity  {

    ListView lstViewCat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        new DownloadJsonAsyncTask()
                .execute("https://murmuring-waters-97180.herokuapp.com/categoria");

        setContentView(R.layout.activity_splash_json_categoria);


    }




    class DownloadJsonAsyncTask extends AsyncTask<String, Void, List<Categoria>> {
        ProgressDialog dialog;

        //Exibe pop-up indicando que está sendo feito o download do JSON
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(ConsumirJsonCategoriaActivity.this, "Aguarde",
                    "Fazendo download do JSON");
        }

        //Acessa o serviço do JSON e retorna a lista de pessoas
        @Override
        protected List<Categoria> doInBackground(String... params) {
            String urlString = params[0];
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(urlString);

            try {
                HttpResponse response = httpclient.execute(httpget);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream instream = entity.getContent();
                    String json = getStringFromInputStream(instream);
                    instream.close();
                    List<Categoria> categorias = getCategoria(json);

                    Intent intent = new Intent(ConsumirJsonCategoriaActivity.this, CardapioDigitalMainActivity.class);
                    intent.putExtra("categorias", (Serializable) categorias);
                    finish();
                    startActivity(intent);


                    return categorias;
                }
            } catch (Exception e) {
                Log.e("Erro", "Falha ao acessar Web service", e);
            }
            return null;
        }


        //Depois de executada a chamada do serviço
        @Override
        protected void onPostExecute(List<Categoria> result) {
            super.onPostExecute(result);
            dialog.dismiss();
            if (result.size() > 0) {


            } else {
                Builder builder = new Builder(
                        ConsumirJsonCategoriaActivity.this)
                        .setTitle("Erro CATEGORIA")
                        .setMessage("Não foi possível acessar as informações!! CATEGORIA")
                        .setPositiveButton("OK", null);
                builder.create().show();
            }
        }

        //Retorna uma lista de pessoas com as informações retornadas do JSON
        public List<Categoria> getCategoria(String jsonString) throws JSONException {

            List<Categoria> categorias = new ArrayList<Categoria>();


            try {
                JSONArray categoriasJson = new JSONArray(jsonString);
                JSONObject categoria;

                for (int i = 0; i < categoriasJson.length(); i++) {
                    categoria = new JSONObject(categoriasJson.getString(i));
                    Log.i("CATEGORIA ENCONTRADA: ",
                            "nome=" + categoria.getString("nome"));

//                    if(categoria.getString("nome")== ""){
//
//
//                        Categoria objetoCategorianull= new Categoria();
//                        objetoCategorianull.setNome("nome null");
//                        categorias.add(objetoCategorianull);
//
//                    }

                    Categoria objetoCategoria= new Categoria();
                    objetoCategoria.setNome(categoria.getString("nome"));
                    //(categoria.getString("nome"));
                  //  objetoCategoria.setProdutos(categoria.getString("produto")))
                    //(categoria.getString("senha"));
                    categorias.add(objetoCategoria);

                }

            } catch (JSONException e) {
                Log.e("Erro", "Erro no parsing do JSON CATEGORIA", e);
            }
            return categorias;
        }


        //Converte objeto InputStream para String
        private String getStringFromInputStream(InputStream is) {

            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();

            String line;
            try {

                br = new BufferedReader(new InputStreamReader(is));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return sb.toString();

        }

    }




}
