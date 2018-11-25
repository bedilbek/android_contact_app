package example.bedilbek.contactapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactDetailsFragment extends Fragment {
    ImageView userImageView;
    TextView firstNameTextView;
    TextView lastNameTextView;
    TextView contactNumberTextView;
    Contact contact;
    private static String CONTACT_BUNDLE_ARGUMENT = "contact";

    public ContactDetailsFragment() {
    }

    public static ContactDetailsFragment constructor(Contact contact) {
        ContactDetailsFragment fragment = new ContactDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CONTACT_BUNDLE_ARGUMENT, contact);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        init();
        // user information should be putted here
        return inflater.inflate(R.layout.contact_detail_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        contact = (Contact) getArguments().getSerializable(CONTACT_BUNDLE_ARGUMENT);
        userImageView.setImageResource(getContext().getResources().getIdentifier(contact.getImage(), "drawable", getContext().getPackageName()));
        firstNameTextView.setText(contact.getFirstName());
        lastNameTextView.setText(contact.getLastName());
        contactNumberTextView.setText(String.valueOf(contact.getContact_number()));
    }

    public void init() {
        userImageView = getView().findViewById(R.id.userImageViewId);
        firstNameTextView = getView().findViewById(R.id.firstNameTextViewId);
        lastNameTextView = getView().findViewById(R.id.lastNameTextViewId);
        contactNumberTextView = getView().findViewById(R.id.contactNumberTextViewId);
    }
}