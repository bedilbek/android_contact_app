package example.bedilbek.contactapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactDetailsFragment extends Fragment {

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

        LinearLayout parentView = new LinearLayout(getActivity());
        parentView.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                         ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(80,80, 80,80);
        parentView.setLayoutParams(layoutParams);

        int padding = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                10, getActivity().getResources().getDisplayMetrics());

        ImageView userImageView = new ImageView(getActivity());
        userImageView.setId(R.id.userImageViewId);
        userImageView.setBackgroundResource(R.drawable.ic_launcher_foreground); // image of user
        parentView.addView(userImageView);

        TextView firstNameTextView = new TextView(getActivity());
        firstNameTextView.setId(R.id.firstNameTextViewId);
        firstNameTextView.setText(""); // we can set text using index number
        firstNameTextView.setTextSize(20);
        firstNameTextView.setPadding(padding, padding, padding, padding);
        firstNameTextView.setGravity(Gravity.CENTER);
        parentView.addView(firstNameTextView);

        TextView lastNameTextView = new TextView(getActivity());
        lastNameTextView.setId(R.id.lastNameTextViewId);
        lastNameTextView.setText("Last Name"); // we can set text using index number
        lastNameTextView.setTextSize(20);
        lastNameTextView.setPadding(padding, padding, padding, padding);
        lastNameTextView.setGravity(Gravity.CENTER);
        parentView.addView(lastNameTextView);

        TextView contactNumberTextView = new TextView(getActivity());
        contactNumberTextView.setId(R.id.contactNumberTextViewId);
        contactNumberTextView.setText("Contact Number"); // we can set text using index number
        contactNumberTextView.setTextSize(20);
        contactNumberTextView.setPadding(padding, padding, padding, padding);
        contactNumberTextView.setGravity(Gravity.CENTER);
        parentView.addView(contactNumberTextView);

        return parentView;
    }
}
