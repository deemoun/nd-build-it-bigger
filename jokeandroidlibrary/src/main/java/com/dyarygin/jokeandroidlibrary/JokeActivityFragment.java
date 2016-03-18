package com.dyarygin.jokeandroidlibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmitry.JokeTeller;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView jokeTextView = (TextView)view.findViewById(R.id.displayTextView);
        JokeTeller jt = new JokeTeller();
        jokeTextView.setText(jt.tellJokes());
        return view;
    }
}
