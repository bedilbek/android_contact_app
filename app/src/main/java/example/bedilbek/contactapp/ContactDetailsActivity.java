package example.bedilbek.contactapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ContactDetailsActivity extends AppCompatActivity {
    FragmentManager manager;
    Contact contact;
    LinearLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
        }
        setContentView(R.layout.activity_contact_details);
        init();
        manager = getSupportFragmentManager();
        contact = getIntent().getParcelableExtra("contact");
        ContactDetailsFragment fragment = ContactDetailsFragment.constructor(contact);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.parent, fragment);
        transaction.commit();
    }

    private void init() {
        parent = findViewById(R.id.parent);
    }
}
