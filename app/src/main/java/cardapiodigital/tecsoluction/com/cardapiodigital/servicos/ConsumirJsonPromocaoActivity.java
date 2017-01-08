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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.PromocaoActivity;
import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Promocao;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

import static android.app.AlertDialog.Builder;

/**
 * Created by winds on 17/12/2016.
 */
public class ConsumirJsonPromocaoActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new DownloadJsonAsyncTask()
                .execute("https://murmuring-waters-97180.herokuapp.com/promocao");
    }


    class DownloadJsonAsyncTask extends AsyncTask<String, Void, List<Promocao>> {
//        ProgressDialog dialog;

        //Exibe pop-up indicando que está sendo feito o download do JSON
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            dialog = ProgressDialog.show(ConsumirJsonGarconActivity.this, "Aguarde",
//                    "Fazendo download do JSON");
        }

        //Acessa o serviço do JSON e retorna a lista de pessoas
        @Override
        protected List<Promocao> doInBackground(String... params) {
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
                    List<Promocao> promo = getPromocao(json);

                    Intent intent = new Intent(ConsumirJsonPromocaoActivity.this, PromocaoActivity.class);
                    intent.putParcelableArrayListExtra("promo", (ArrayList<? extends Parcelable>) promo);
                    startActivity(intent);
                    finish();


                    return promo;
                }
            } catch (Exception e) {
                Log.e("Erro", "Falha ao acessar Web service promocao", e);
            }
            return null;
        }


        //Depois de executada a chamada do serviço
        @Override
        protected void onPostExecute(List<Promocao> result) {
            super.onPostExecute(result);
//            dialog.dismiss();
            if (result.size() > 0) {
//                ArrayAdapter<Garcon> adapter = new ArrayAdapter<Garcon>(
//                        ConsumirJsonPromocaoActivity.this,
//                        android.R.layout.simple_list_item_1, result);
//                setListAdapter(adapter);
            } else {
                Builder builder = new Builder(
                        ConsumirJsonPromocaoActivity.this)
                        .setTitle("Erro")
                        .setMessage("Não foi possível acessar as informações Promocao!!")
                        .setPositiveButton("OK", null);
                builder.create().show();
            }
        }

        //Retorna uma lista de pessoas com as informações retornadas do JSON
        public List<Promocao> getPromocao(String jsonString) throws JSONException {
            List<Promocao> promocoes = new ArrayList<Promocao>();

            try {
                JSONArray promocaoJson = new JSONArray(jsonString);
                JSONObject promocao;

                for (int i = 0; i < promocaoJson.length(); i++) {
                    promocao = new JSONObject(promocaoJson.getString(i));
                    Log.i("PROMOÇÃO ENCONTRADA: ",
                            "nome=" + promocao.getString("nome"));

                    Promocao objetoPromocao = new Promocao();
                    objetoPromocao.setId(promocao.getLong("id"));
                    objetoPromocao.setNome(promocao.getString("nome"));
                    objetoPromocao.setNumero(promocao.getString("numero"));
                    objetoPromocao.setDatainicio(Date.valueOf(promocao.getString("datainicio")));
                    objetoPromocao.setDatafim(Date.valueOf(promocao.getString("datafim")));

                    promocoes.add(objetoPromocao);

                }

            } catch (JSONException e) {
                Log.e("Erro", "Erro no parsing do JSON promocoes", e);
            }
            return promocoes;
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
