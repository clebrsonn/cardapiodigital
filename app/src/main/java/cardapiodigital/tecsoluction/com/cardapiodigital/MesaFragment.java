package cardapiodigital.tecsoluction.com.cardapiodigital;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Item;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link MesaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MesaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MesaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//    private PlusOneButton mPlusOneButton;

    private OnFragmentInteractionListener mListener;

    List<Item> itens;

    MesaFragment mesafra;

    public MesaFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Fragment newInstance() {
        Fragment fragment = new Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mesa, container, false);

        //Find the +1 button
//        mPlusOneButton = (PlusOneButton) view.findViewById(R.id.plus_one_button);

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


        final ListView lstviewfragmentomesa = (ListView)view.findViewById(R.id.lstitensmesa);


        final List<Item> listaitemarray;
        //chamando funcao para preencher a lista
        listaitemarray = preencherDados();

        //associando o adapter a um layout e passando por parametro a lista
        ArrayAdapter<Item> arrayadapter = new ArrayAdapter<Item>(container.getContext(),android.R.layout.simple_list_item_1,listaitemarray);
        lstviewfragmentomesa.setAdapter(arrayadapter);
        // botão de apbir pedido
//          Button bt =(Button)findViewById(R.id.mesa);

        //  final para poder passar por parametro no toast
        final List<Item> finalListaitemarray = listaitemarray;

        lstviewfragmentomesa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String row_choose = finalListaitemarray.get(i).toString();

                Toast.makeText(view.getContext(), "Mesa Fragment:" + row_choose, Toast.LENGTH_LONG).show();


            }
        }) ;


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
//        mPlusOneButton.initialize(PLUS_ONE_URL, PLUS_ONE_REQUEST_CODE);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private final List<Item> preencherDados(){

        Item i1 = new Item();
        i1.setDescricao("descr");
        i1.setQtd(1);

        Item i2 = new Item();
        i2.setDescricao("descr");
        i2.setQtd(1);
//        g2.setSenhagarcon("14gfdd52");

//
        //      categorias = (List<Categoria>) getIntent().getSerializableExtra("categorias");

//        List<Garcon> lista = new ArrayList<>();
////
////        lista.add(g2);
        itens.add(i1);
        itens.add(i2);


        return itens;
    }
}
