package com.example.shahar.advancedmobile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "input";

    // TODO: Rename and change types of parameters
    private String type;

    public SomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param type Parameter 1.
     * @return A new instance of fragment SomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SomeFragment newInstance(String type) {
        SomeFragment fragment = new SomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, type);
        // The arguments supplied here will be retained across fragment destroy and creation
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        if(this.type.equals("text")){
            view = inflater.inflate(R.layout.text_frag, container, false);
        } else {
            view = inflater.inflate(R.layout.input_frag, container, false);
            final EditText editText = (EditText) view.findViewById(R.id.editText);
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                    EventBus.getDefault().post(new MyFragmentEvent(MyFragmentEvent.SEND_TEXT,v.getText().toString()));

                    return false;
                }
            });
        }
        // Inflate the layout for this fragment


        return view;
    }


}
