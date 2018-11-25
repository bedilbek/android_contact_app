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
        contacts.add(new Contact("123", "catwoman", "Selina", "Kyle", 12312223));
        contacts.add(new Contact("124", "batman", "Bruce", "Wayne", 52315823));
        contacts.add(new Contact("125", "cyborg", "Victor", "Stone", 52367823));
        contacts.add(new Contact("126", "flash", "Bart", "Allen", 45367113));
        contacts.add(new Contact("127", "greenarrow", "Oliver", "Queen", 92672223));
        contacts.add(new Contact("128", "hawkgirl", "Kendra", "Sanders", 52315823));
        contacts.add(new Contact("129", "isis", "Andrea", "Thomas", 82377823));
        contacts.add(new Contact("130", "spiderman", "Peter", "Parker", 44367190));
        contacts.add(new Contact("131", "superman", "Clark", "Kent", 72318823));
        contacts.add(new Contact("132", "zatannawoman", "Zatanna", "Unknown", 34377823));
        contacts.add(new Contact("133", "wonderwoman", "Diana", "Princess", 46368790));
        return contacts;
    }
}
