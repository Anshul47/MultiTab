package anshulapps.in.multitabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by anshulreejonia on 26/02/17.
 */

public class MainFragement extends Fragment {

    String name;


    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mainfragement, container, false);
        TextView myLayout = (TextView) rootView.findViewById(R.id.textView);
        if (getArguments() != null) {
            String sentString = getArguments().getString("mii");
            int pos = getArguments().getInt("pos", 0);
            myLayout.setText(sentString+" "+pos);
        }
        return rootView;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            // load data here
        }else{
            // fragment is no longer visible
        }
    }
}
