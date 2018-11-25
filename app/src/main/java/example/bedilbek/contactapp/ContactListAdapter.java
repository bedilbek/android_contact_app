package example.bedilbek.contactapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ContactListAdapter extends ArrayAdapter {

    private final ArrayList<Contact> contacts;
    private final Context context;

    public ContactListAdapter(Context context, List objects) {
        super(context, R.layout.contact_row, objects);
        contacts = (ArrayList<Contact>) objects;
        this.context = context;
    }

    @Override
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.contact_row, parent, false);
        Contact contact = contacts.get(position);
        TextView contact_name = rowView.findViewById(R.id.contact_name);
        TextView contact_number = rowView.findViewById(R.id.contact_number);
        ImageView contact_image = rowView.findViewById(R.id.contact_image);
        contact_number.setText(String.valueOf(contact.getContact_number()));
        String name = contact.getFirstName() + contact.getLastName();
        contact_name.setText(name);
        contact_image.setImageResource(context.getResources().getIdentifier(contact.getImage(), "drawable", context.getPackageName()));

        return rowView;
    }
}
