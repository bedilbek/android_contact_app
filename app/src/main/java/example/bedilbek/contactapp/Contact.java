package example.bedilbek.contactapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Contact implements Serializable, Parcelable{
    private String id;
    private String image;
    private String firstName;
    private String lastName;
    private int contact_number;

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact_number=" + contact_number +
                '}';
    }

    protected Contact(Parcel in) {
        id = in.readString();
        image = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        contact_number = in.readInt();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getContact_number() {
        return contact_number;
    }

    public Contact(String id, String image, String firstName, String lastName, int contact_number) {
        this.id = id;
        this.image = image;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact_number = contact_number;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(image);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeInt(contact_number);
    }
}
