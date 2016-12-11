package cardapiodigital.tecsoluction.com.cardapiodigital.servicos;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;

/**
 * Created by winds on 03/12/2016.
 */

public class GarconServico {



    private String ENDPOINT = "https://murmuring-waters-97180.herokuapp.com/Garcon/";

    private long id;

    private String nome;

    private String senha;




    public GarconServico(){

    }



    public String getENDPOINT() {
        return ENDPOINT;
    }

    public void setENDPOINT(String ENDPOINT) {
        this.ENDPOINT = ENDPOINT;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public String ObterListagemGarcon(){

        String retorno="";

        HttpParams httpParameters= new BasicHttpParams();
        int timeoutConnection=10000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
        int timeoutSocket=10000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        // Define variável para receber o fluxo de dados proveniente do consumo do webService REST.
        InputStream inputStream=null;

        // Consome o serviço REST, através de uma simples requisição http.
        try
        {
            // Cria cliente http.
            HttpClient httpclient=new DefaultHttpClient(httpParameters);

            // Cria o GET e define a URL
            HttpGet httpget=new HttpGet(ENDPOINT);

            // Define o tipo de dados para a correta execução do http GET
            httpget.setHeader("Content-Type", "application/json");
            httpget.setHeader("Accept", "application/json");

            // Envia o pedido de consumo da URL através de um GET.
            HttpResponse httpResponse=httpclient.execute(httpget);

            // Recebe a resposta no inputStream.
            inputStream=httpResponse.getEntity().getContent();

            // Define variável para receber o resultado convertido em String.
            String resultado="";

            try
            {

                // Converte os dados recebidos no fluxo para String.
                resultado=convertInputStreamToString(inputStream);

                // Verifica se a requisição foi processada corretamente (código http 200).
                // Este serviço envia http status code 200 se foi possível processar a requisição corretamente e há registros.
                // Caso contrário, será enviado um http status code de erro, junto com uma mensagem descritiva no corpo do JSON.
                if (httpResponse.getStatusLine().getStatusCode() == 200)
                {

                    // Constrói o retorno do método.
                    retorno = resultado;

                }
                else
                {
                    // Não foi possivel processar a requisição por alguma razão.
                    // Extrai a mensagem de erro enviada.
                    try
                    {
                        JSONObject jObj=new JSONObject(resultado);
                        JSONArray dados=null;

                        try
                        {
                            dados=jObj.getJSONArray("NOME");
                            String msg=dados.get(0).toString().replace("[", "");
                            msg=msg.replace("]", "");
                            msg=msg.replace("\"", "");

                            Log.i("consumidorRest1", "Ocorreu um erro ao consumir o serviço: " + msg);

                        }
                        catch (Exception e)
                        {
                            Log.i("consumidorREST", "Erro 1:" + e.getMessage() + " " + e.getLocalizedMessage());
                        }
                    }
                    catch (Exception f)
                    {
                        Log.i("consumidorREST", "Erro 2:" + f.getMessage() + " " + f.getLocalizedMessage());
                    }

                }
            }
            catch (Exception g)
            {
                Log.i("consumidorREST", "Erro 3:" + g.getMessage() + " " + g.getLocalizedMessage());
            }
        }
        catch (Exception h)
        {
            Log.i("consumidorREST4", "Erro 4:" + h.getMessage() + " " + h.getLocalizedMessage());
        }

        return retorno;

    }

    // Converte a inputString obtida no consumo, para String
    private static String convertInputStreamToString(InputStream inputStream) throws IOException
    {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1"));

        int c;
        StringBuilder response=new StringBuilder();

        // Lê do buffer pegando caracter a caracter. Como particularmente este
        // fluxo consumido não possui fim de linha
        // com newline (\n), o método readLine() não funciona.
        while ((c=bufferedReader.read()) != -1)
        {
            response.append((char) c);
        }
        String result=response.toString();
        inputStream.close();

        return result;

    }


    public ArrayList<GarconServico> extrairSenhasDeGarcon (String jsonString)
    {

        ArrayList<GarconServico> senhasgarcons = new ArrayList<>();

        // Declara a variável de retorno, que conterá as posições de ônibus.
        ArrayList<GarconServico> listasenhas = new ArrayList<>();

        // Declara o DTO que comporá os itens da lista.
        GarconServico garconservico;

        // Transforma a String em JSONObject.
        JSONObject jObj;

        try
        {
            jObj= new JSONObject(jsonString);

            // Extrai do JSONObject os arrays de COLUNAS e POSIÇÕES.
            JSONArray idgarcon = jObj.getJSONArray("id");
            JSONArray nomegarcon=jObj.getJSONArray("nome");
            JSONArray senhagarcon=jObj.getJSONArray("senha");

            // Define a variável que guardará uma posição individual de ônibus.
            JSONArray idgarconatual = null;
            JSONArray senhagarconatual = null;
            JSONArray nomegarconatual = null;



            // Itera sobre a String JSON, para extração individual dos dados.
            for (int i=0; i < listasenhas.size(); i++)
            {
                try

                {
                    // Extrai uma posição de ônibus individual.

                    idgarconatual = idgarcon.getJSONArray(i);
                    nomegarconatual = nomegarcon.getJSONArray(i);
                    senhagarconatual= senhagarcon.getJSONArray(i);


                    // Instancia o objeto para compor a lista.
                    garconservico = new GarconServico();

                    // Faz o parse de cada campo, transferindo para o DTO que comporá a lista.
//                    dateString = (String) posicaoOnibus.getString(0);
//                    formatter=new SimpleDateFormat("MM-dd-yyyy HH:mm:ss", Locale.US);
                    garconservico.setId(idgarconatual.getLong(0));
                    garconservico.setNome(nomegarconatual.getString(1));
                    garconservico.setSenha(senhagarconatual.getString(2));

//                    posicaoOnibusDTO.setLatitude(Double.valueOf(posicaoOnibus.getString(3)));
//                    posicaoOnibusDTO.setLongitude(Double.valueOf(posicaoOnibus.getString(4)));
//                    posicaoOnibusDTO.setVelocidade(Double.parseDouble(posicaoOnibus.getString(5)));
//                    direcao=((posicaoOnibus.getString(6)).length() == 0) ? "-1" : posicaoOnibus.getString(6);
//                    direcao=direcao.replace(".0", "");
//                    posicaoOnibusDTO.setDirecao(Integer.parseInt(direcao));

                    // Acrescenta o DTO à lista.
                    senhasgarcons.add(garconservico);

                }
                catch (Exception e)
                {
                    Log.i("consumidorREST", "Erro 5:" + e.getMessage());
                }
            }
        }
        catch (JSONException f)
        {
            Log.i("consumidorREST", "Erro 6:" + f.getMessage());
        }

        // Retorna a lista de posições de ônibus.
        return listasenhas;
    }
}
