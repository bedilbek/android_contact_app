package example.bedilbek.contactapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Contact contact = new Contact("asdsa", "catwoman.png", "sadsad", "asdsad", 12312223);
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(contact);
        ContactListFragment fragment = ContactListFragment.constructor(contacts);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(fragment, "hello");
        transaction.commit();

    }
}
