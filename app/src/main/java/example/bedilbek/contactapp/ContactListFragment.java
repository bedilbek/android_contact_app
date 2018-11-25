package example.bedilbek.contactapp;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactListFragment extends ListFragment implements AdapterView.OnItemClickListener {
    public OnContactSelectedListener contactSelectedListener;

    private ArrayList<Contact> contacts;
    private static final String CONTACTS_BUNDLE_ARGUMENT = "contacts";

    public static ContactListFragment constructor(ArrayList<Contact> contacts) {
        ContactListFragment fragment = new ContactListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CONTACTS_BUNDLE_ARGUMENT, contacts);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_contact_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        contacts = (ArrayList<Contact>) getArguments().getSerializable(CONTACTS_BUNDLE_ARGUMENT);
        setListAdapter(new ContactListAdapter(getContext(), contacts));
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), contacts.get(position).toString(), Toast.LENGTH_SHORT).show();
        contactSelectedListener.onObjectSelected(contacts.get(position));
    }

    public interface OnContactSelectedListener {
        public void onObjectSelected(Contact contact);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            contactSelectedListener = (OnContactSelectedListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnContactSelectedListener");
        }
    }
}
