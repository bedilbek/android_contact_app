package example.bedilbek.contactapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ContactListAdapter extends ArrayAdapter {

    private final Activity context;
    private final ArrayList<Contact> contacts;

    public ContactListAdapter(@NonNull Activity context, ArrayList<Contact> contacts) {
        super(context, R.layout.contact_row, contacts);

        this.contacts = contacts;
        this.context = context;
    }

    public int getCount() {
        return contacts.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
