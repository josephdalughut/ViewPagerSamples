package ng.joeydalu.android.samples.viewpager.gui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ng.joeydalu.android.samples.viewpager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumberFragment extends Fragment {

    /** number to display on this page */
    private int number = 0;

    /** {@link TextView} to display the number for this page */
    private TextView txtNumber;

    public static NumberFragment newInstance(int number){
        return new NumberFragment().setNumber(number);
    }

    public NumberFragment() {
        // Required empty public constructorreturn
    }

    public NumberFragment setNumber(int number){
        this.number = number;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_number, container, false);

        //find our textview to display the number
        TextView txtNumber = (TextView) view.findViewById(R.id.txtNumber);

        //set the text of the textview to the number
        txtNumber.setText(""+number);

        return view;
    }

}
