package info.androidhive.Components;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;


import java.util.ArrayList;
import java.util.List;

import info.androidhive.Adapters.PostAdapter;
import info.androidhive.R;
import info.androidhive.beans.Post;

/**
 * Created by Erene on 25/12/2017.
 */

public class frag_home extends Fragment {


    private frag_home.OnFragmentInteractionListener mListener;

    public frag_home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_home, container, false);


        final TabHost tabHost = (TabHost) view.findViewById(R.id.myTH);
        tabHost.setup();

        //Tab 1
        TabHost.TabSpec spec = tabHost.newTabSpec("All");
        spec.setContent(R.id.All);
        spec.setIndicator("All");
        tabHost.addTab(spec);

        //Tab 2
        spec = tabHost.newTabSpec("Location");
        spec.setContent(R.id.Location);
        spec.setIndicator("Location");
        tabHost.addTab(spec);

        //Tab 3
        spec = tabHost.newTabSpec("University");
        spec.setContent(R.id.University);
        spec.setIndicator("University");
        tabHost.addTab(spec);


        ListView listView_home_all = (ListView) view.findViewById(R.id.listView_home_all);
        ListView listView_home_univertity = (ListView) view.findViewById(R.id.listView_home_university);
        ListView listView_home_location = (ListView) view.findViewById(R.id.listView_home_location);

        PostAdapter listAllAdapter = new PostAdapter(view.getContext(), R.layout.item_post, testlistAllPosts());
        PostAdapter listUniversityAdapter = new PostAdapter(view.getContext(), R.layout.item_post, testlistUnivPosts());
        PostAdapter listLocationAdapter = new PostAdapter(view.getContext(), R.layout.item_post, testlistLocPosts());

        listView_home_all.setAdapter(listAllAdapter);
        listView_home_univertity.setAdapter(listUniversityAdapter);
        listView_home_location.setAdapter(listLocationAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof frag_home.OnFragmentInteractionListener) {
            mListener = (frag_home.OnFragmentInteractionListener) context;
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public List<Post> testlistAllPosts() {
        List<Post> listAllPost = new ArrayList<>();
        String text = "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression";
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass1", "01/01/2018", text));
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass2", "02/01/2018", text));
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass3", "03/01/2018", text));
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass4", "04/01/2018", text));
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass5", "05/01/2018", text));
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass6", "06/01/2018", text));
        return listAllPost;
    }

    public List<Post> testlistUnivPosts() {
        List<Post> listAllPost = new ArrayList<>();
        String text = "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression";
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass1", "01/01/2018", text));
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass2", "02/01/2018", text));
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass3", "03/01/2018", text));
        return listAllPost;
    }

    public List<Post> testlistLocPosts() {
        List<Post> listAllPost = new ArrayList<>();
        String text = "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression";
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass4", "04/01/2018", text));
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass5", "05/01/2018", text));
        listAllPost.add(new Post(R.drawable.ic_profile, "Anass6", "06/01/2018", text));
        return listAllPost;
    }
}
