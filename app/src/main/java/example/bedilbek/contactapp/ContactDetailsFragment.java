package example.bedilbek.contactapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetailsFragment extends Fragment {
    ImageView userImageView;
    TextView firstNameTextView;
    TextView lastNameTextView;
    TextView contactNumberTextView;

    public static ContactDetailsFragment newInstance(int index) {
        ContactDetailsFragment f = new ContactDetailsFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        init();
        // user information should be putted here
        userImageView.setBackgroundResource(R.drawable.ic_launcher_foreground);
        firstNameTextView.setText("");
        lastNameTextView.setText("");
        contactNumberTextView.setText("");
        return inflater.inflate(R.layout.contact_detail_fragment, container, false);

    }

    public void init() {
        userImageView = getView().findViewById(R.id.userImageViewId);
        firstNameTextView = getView().findViewById(R.id.firstNameTextViewId);
        lastNameTextView = getView().findViewById(R.id.lastNameTextViewId);
        contactNumberTextView = getView().findViewById(R.id.contactNumberTextViewId);
    }
}