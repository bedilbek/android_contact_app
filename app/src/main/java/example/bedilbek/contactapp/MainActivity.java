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
        ArrayList<Contact> contacts = initContacts();
        ContactListFragment fragment = ContactListFragment.constructor(contacts);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.menu, fragment, "hello");
        transaction.commit();
    }


    private ArrayList<Contact> initContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("123", "catwoman", "Cat", "Woman", 12312223));
        contacts.add(new Contact("124", "batman", "Bat", "Man", 52315823));
//        TODO: add new contacts as given above, try to write images that are available in drawable folder

        return contacts;
    }
}
