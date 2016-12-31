package cardapiodigital.tecsoluction.com.cardapiodigital.servicos;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

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

import cardapiodigital.tecsoluction.com.cardapiodigital.Sushi;
import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Categoria;
import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Produto;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

import static android.app.AlertDialog.Builder;

/**
 * Created by winds on 17/12/2016.
 */
public class ConsumirJsonProdutoActivity extends Activity {

    private long idcategoria;

    private String categoriaEscolhida;

    private List<Categoria> listaCategoria = new ArrayList<Categoria>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        idcategoria = (Long) getIntent().getSerializableExtra("idcategoria");
        categoriaEscolhida = (String) getIntent().getSerializableExtra("categoriaEscolhida");

        new DownloadJsonAsyncTask()
                .execute("https://murmuring-waters-97180.herokuapp.com/produto/categoria/"+idcategoria);
    }



    class DownloadJsonAsyncTask extends AsyncTask<String, Void, List<Produto>> {

      //  ProgressDialog dialog;

        //Exibe pop-up indicando que está sendo feito o download do JSON
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            dialog = ProgressDialog.show(ConsumirJsonGarconActivity.this, "Aguarde",
//                    "Fazendo download do JSON");
        }

        //Acessa o serviço do JSON e retorna a lista de pessoas
        @Override
        protected List<Produto> doInBackground(String... params) {
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
                    List<Produto> produtos = getProdutos(json);




                    for (int i = 0; i < produtos.size(); i++) {

                        Produto produto = new Produto();
                        produto.setDescricao(produtos.get(i).getDescricao());
                        produto.setNumero(produtos.get(i).getNumero());
                        produto.setId(produtos.get(i).getId());
                        produto.setCategoria(produtos.get(i).getCategoria());
                        produto.setCodebar(produtos.get(i).getCodebar());
                        produto.setPrecoVenda(produtos.get(i).getPrecoVenda());

                        listaCategoria.add(produto.getCategoria());

//                        Categoria  categoria = new Categoria();


                    }


                    Intent intent = new Intent(ConsumirJsonProdutoActivity.this, Sushi.class);
                    intent.putExtra("produtos", (Serializable) produtos);
                    intent.putExtra("categorias", (Serializable) listaCategoria);
                    intent.putExtra("categoriaEscolhida", categoriaEscolhida);

                    finish();
                    startActivity(intent);


                    return produtos;
                }
            } catch (Exception e) {
                Log.e("Erro", "Falha ao acessar Web service produtos", e);
            }
            return null;
        }


        //Depois de executada a chamada do serviço
        @Override
        protected void onPostExecute(List<Produto> result) {
            super.onPostExecute(result);
//            dialog.dismiss();
            if (result.size() > 0) {
//                ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(
//                        ConsumirJsonProdutoActivity.this,
//                        android.R.layout.simple_list_item_1, result);
//                setListAdapter(adapter);
            } else {
                Builder builder = new Builder(
                        ConsumirJsonProdutoActivity.this)
                        .setTitle("Erro")
                        .setMessage("Não foi possível acessar as informações!!")
                        .setPositiveButton("OK", null);
                builder.create().show();
            }
        }

        //Retorna uma lista de pessoas com as informações retornadas do JSON
        public List<Produto> getProdutos(String jsonString) throws JSONException {
            List<Produto> produtos = new ArrayList<Produto>();
            try {
                JSONArray produtosJson = new JSONArray(jsonString);
                JSONObject produto;

                for (int i = 0; i < produtosJson.length(); i++) {
                    produto = new JSONObject(produtosJson.getString(i));
                    Log.i("Produto ENCONTRADO: ",
                            "nome=" + produto.getString("descricao"));

                    Produto objetoProduto = new Produto();
                    objetoProduto.setId(produto.getLong("id"));
                  //  objetoProduto.setCodebar(produto.getString("codebar"));
                    objetoProduto.setCodebar(produto.getString("codebar"));
                    objetoProduto.setDescricao(produto.getString("descricao"));
                    objetoProduto.setPrecoVenda(produto.getDouble("precoVenda"));
                  //  objetoProduto.setCategoria(produto.get("categoria"));
                    produtos.add(objetoProduto);

                }

            } catch (JSONException e) {
                Log.e("Erro", "Erro no parsing do JSON objetoProduto", e);
            }
            return produtos;
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
