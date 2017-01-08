package cardapiodigital.tecsoluction.com.cardapiodigital.servicos;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.MesasActivity;
import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Mesa;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

import static android.app.AlertDialog.Builder;

/**
 * Created by winds on 17/12/2016.
 */
public class ConsumirJsonMesaActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new DownloadJsonAsyncTask()
                .execute("https://murmuring-waters-97180.herokuapp.com/mesa");
    }



    class DownloadJsonAsyncTask extends AsyncTask<String, Void, List<Mesa>> {
       // ProgressDialog dialog;

        //Exibe pop-up indicando que está sendo feito o download do JSON
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            dialog = ProgressDialog.show(ConsumirJsonGarconActivity.this, "Aguarde",
//                    "Fazendo download do JSON");
        }

        //Acessa o serviço do JSON e retorna a lista de pessoas
        @Override
        protected List<Mesa> doInBackground(String... params) {
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
                    List<Mesa> mesas = getMesas(json);

                    Intent intent = new Intent(ConsumirJsonMesaActivity.this, MesasActivity.class);
                    intent.putParcelableArrayListExtra("mesas", (ArrayList<? extends Parcelable>) mesas);
                    finish();
                    startActivity(intent);


                    return mesas;
                }
            } catch (Exception e) {
                Log.e("Erro", "Falha ao acessar Web service Mesa", e);
            }
            return null;
        }


        //Depois de executada a chamada do serviço
        @Override
        protected void onPostExecute(List<Mesa> result) {
            super.onPostExecute(result);
//            dialog.dismiss();
            if (result.size() > 0) {
//                ArrayAdapter<Mesa> adapter = new ArrayAdapter<Mesa>(
//                        ConsumirJsonMesaActivity.this,
//                        android.R.layout.simple_list_item_1, result);
//                setListAdapter(adapter);
            } else {
                Builder builder = new Builder(
                        ConsumirJsonMesaActivity.this)
                        .setTitle("Erro")
                        .setMessage("Não foi possível acessar as informações Mesa!!")
                        .setPositiveButton("OK", null);
                        builder.create().show();
            }
        }

        //Retorna uma lista de pessoas com as informações retornadas do JSON
        public List<Mesa> getMesas(String jsonString) throws JSONException {
            List<Mesa> mesas = new ArrayList<Mesa>();
            try {
                JSONArray mesasJson = new JSONArray(jsonString);
                JSONObject mesa;

                for (int i = 0; i < mesasJson.length(); i++) {
                    mesa = new JSONObject(mesasJson.getString(i));
                    Log.i("mesa ENCONTRADO: ",
                            "nome=" + mesa.getString("numero"));

                    Mesa objetoMesa = new Mesa();
                    objetoMesa.setId(mesa.getLong("id"));
                    objetoMesa.setNumero(mesa.getString("numero"));
                    objetoMesa.setStatus(mesa.getString("status"));

                    mesas.add(objetoMesa);

                }

            } catch (JSONException e) {
                Log.e("Erro", "Erro no parsing do JSON Mesa", e);
            }
            return mesas;
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
