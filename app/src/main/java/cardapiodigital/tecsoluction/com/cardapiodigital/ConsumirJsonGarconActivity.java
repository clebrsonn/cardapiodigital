package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Garcon;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

import static android.app.AlertDialog.Builder;

/**
 * Created by winds on 17/12/2016.
 */
public class ConsumirJsonGarconActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new DownloadJsonAsyncTask()
                .execute("https://murmuring-waters-97180.herokuapp.com/garcon");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Garcon garcon = (Garcon) l.getAdapter().getItem(position);

        Intent intent = new Intent(ConsumirJsonGarconActivity.this, CardapioDigitalMainActivity.class);
        intent.putExtra("garcon", garcon);
        startActivity(intent);



    }

    class DownloadJsonAsyncTask extends AsyncTask<String, Void, List<Garcon>> {
        ProgressDialog dialog;

        //Exibe pop-up indicando que está sendo feito o download do JSON
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(ConsumirJsonGarconActivity.this, "Aguarde",
                    "Fazendo download do JSON");
        }

        //Acessa o serviço do JSON e retorna a lista de pessoas
        @Override
        protected List<Garcon> doInBackground(String... params) {
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
                    List<Garcon> garcons = getGarcons(json);




                    return garcons;
                }
            } catch (Exception e) {
                Log.e("Erro", "Falha ao acessar Web service", e);
            }
            return null;
        }


        //Depois de executada a chamada do serviço
        @Override
        protected void onPostExecute(List<Garcon> result) {
            super.onPostExecute(result);
            dialog.dismiss();
            if (result.size() > 0) {
                ArrayAdapter<Garcon> adapter = new ArrayAdapter<Garcon>(
                        ConsumirJsonGarconActivity.this,
                        android.R.layout.simple_list_item_1, result);
                setListAdapter(adapter);
            } else {
                Builder builder = new Builder(
                        ConsumirJsonGarconActivity.this)
                        .setTitle("Erro")
                        .setMessage("Não foi possível acessar as informações!!")
                        .setPositiveButton("OK", null);
                builder.create().show();
            }
        }

        //Retorna uma lista de pessoas com as informações retornadas do JSON
        public List<Garcon> getGarcons(String jsonString) throws JSONException {
            List<Garcon> garcons = new ArrayList<Garcon>();
            try {
                JSONArray garconsJson = new JSONArray(jsonString);
                JSONObject garcon;

                for (int i = 0; i < garconsJson.length(); i++) {
                    garcon = new JSONObject(garconsJson.getString(i));
                    Log.i("GARCON ENCONTRADO: ",
                            "nome=" + garcon.getString("nome"));

                    Garcon objetoGarcon = new Garcon();
                    objetoGarcon.setNomegarcon(garcon.getString("nome"));
                    objetoGarcon.setSenhagarcon(garcon.getString("senha"));
                    garcons.add(objetoGarcon);

                }

            } catch (JSONException e) {
                Log.e("Erro", "Erro no parsing do JSON", e);
            }
            return garcons;
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
