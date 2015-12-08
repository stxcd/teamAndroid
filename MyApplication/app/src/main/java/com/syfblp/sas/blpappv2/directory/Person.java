package com.syfblp.sas.blpappv2.directory;

import java.io.Serializable;

public class Person implements Comparable<Person>,Serializable {


   //creating strings for LV - Joanne
    public String persId;
    public String firstName;
    public String lastName;
    public String location;
    public String function;
    public String role;
    public String al;
    public String phone;
    public String email;


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String university;

    public int compareTo(Person other) {
        return lastName.compareTo(other.lastName);
    }

    public String getPersId() {
        return persId;
    }

    public void setPersId(String persId) {
        this.persId = persId;
    }

    public String getFirstName() {return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAl() {
        return al;
    }

    public void setAl(String al) {
        this.al = al;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_person);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//    }

   public Person(String persId, String firstName, String lastName, String location, String function, String role, String al, String email, String phone, String university) {
        this.persId = persId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.function = function;
        this.role = role;
        this.al = al;
        this.email = email;
        this.phone = phone;
       this.university=university;
    }

//    public static ArrayList<Person> getPersons() {
//        ArrayList<Person> people = new ArrayList<Person>();
//        people.add(new Person("01", "Ramon", "Cadeaux", "Stamford", "IT", "PMO", "Jackie Molina", "ramon.cadeaux@synchronyfinancial.com", "2031234567", university));
//        people.add(new Person("02", "Joanne", "Swanson", "Stamford", "IT", "Mobile Developer", "Dan Murphy", "joanne.swanson@synchronyfinancial.com", "2036449295", university));
//        people.add(new Person("03", "Tyler", "Thisse", "Alpharetta", "Risk", "Risk One", "John Doe", "tyler.thisse@syncfin.com", "1231231111", university));
//        people.add(new Person("04", "Sofia", "Grossman", "Kettering", "Sales", "Sales One", "John Doe", "sofia.grossman@syncfin.com", "1112223333", university));
//        people.add(new Person("01", "Ramon", "Lilly", "Stamford", "IT", "PMO", "Jackie Molina", "ramon.cadeaux@synchronyfinancial.com", "2031234567", university));
//        people.add(new Person("02", "Joanne", "Ronaldo", "Stamford", "IT", "Mobile Developer", "Dan Murphy", "joanne.swanson@synchronyfinancial.com", "2036449295", university));
//        people.add(new Person("03", "Tyler", "Whick", "Alpharetta", "Risk", "Risk One", "John Doe", "tyler.thisse@syncfin.com", "1231231111", university));
//        people.add(new Person("04", "Sofia", "Hudson", "Kettering", "Sales", "Sales One", "John Doe", "sofia.grossman@syncfin.com", "1112223333", university));
//        people.add(new Person("01", "Ramon", "Smith", "Stamford", "IT", "PMO", "Jackie Molina", "ramon.cadeaux@synchronyfinancial.com", "2031234567", university));
//        people.add(new Person("02", "Joanne", "Lechman", "Stamford", "IT", "Mobile Developer", "Dan Murphy", "joanne.swanson@synchronyfinancial.com", "2036449295", university));
//        people.add(new Person("03", "Tyler", "Simmons", "Alpharetta", "Risk", "Risk One", "John Doe", "tyler.thisse@syncfin.com", "1231231111", university));
//        people.add(new Person("04", "Sofia", "O'Neill", "Kettering", "Sales", "Sales One", "John Doe", "sofia.grossman@syncfin.com", "1112223333", university));
//        people.add(new Person("01", "Ramon", "McNally", "Stamford", "IT", "PMO", "Jackie Molina", "ramon.cadeaux@synchronyfinancial.com", "2031234567", university));
//        people.add(new Person("02", "Joanne", "Mulcair", "Stamford", "IT", "Mobile Developer", "Dan Murphy", "joanne.swanson@synchronyfinancial.com", "2036449295", university));
//        people.add(new Person("03", "Tyler", "Keane", "Alpharetta", "Risk", "Risk One", "John Doe", "tyler.thisse@syncfin.com", "1231231111", university));
//        people.add(new Person("04", "Sofia", "Rodriguez", "Kettering", "Sales", "Sales One", "John Doe", "sofia.grossman@syncfin.com", "1112223333", university));
//        people.add(new Person("01", "Ramon", "Cadeaux", "Stamford", "IT", "PMO", "Jackie Molina", "ramon.cadeaux@synchronyfinancial.com", "2031234567", university));
//        people.add(new Person("02", "Joanne", "Swanson", "Stamford", "IT", "Mobile Developer", "Dan Murphy", "joanne.swanson@synchronyfinancial.com", "2036449295", university));
//        people.add(new Person("03", "Tyler", "Thisse", "Alpharetta", "Risk", "Risk One", "John Doe", "tyler.thisse@syncfin.com", "1231231111", university));
//        people.add(new Person("04", "Sofia", "Grossman", "Kettering", "Sales", "Sales One", "John Doe", "sofia.grossman@syncfin.com", "1112223333", university));
//        people.add(new Person("03", "Tyler", "Jackson", "Alpharetta", "Risk", "Risk One", "John Doe", "tyler.thisse@syncfin.com", "1231231111", university));
//        people.add(new Person("04", "Sofia", "Gaudio", "Kettering", "Sales", "Sales One", "John Doe", "sofia.grossman@syncfin.com", "1112223333", university));
//        people.add(new Person("01", "Ramon", "Rankin", "Stamford", "IT", "PMO", "Jackie Molina", "ramon.cadeaux@synchronyfinancial.com", "2031234567", university));
//        people.add(new Person("02", "Joanne", "Maradona", "Stamford", "IT", "Mobile Developer", "Dan Murphy", "joanne.swanson@synchronyfinancial.com", "2036449295", university));
//        people.add(new Person("03", "Tyler", "O'Connel", "Alpharetta", "Risk", "Risk One", "John Doe", "tyler.thisse@syncfin.com", "1231231111", university));
//        people.add(new Person("04", "Sofia", "Herrera", "Kettering", "Sales", "Sales One", "John Doe", "sofia.grossman@syncfin.com", "1112223333", university));
//        people.add(new Person("01", "Ramon", "Martinez", "Stamford", "IT", "PMO", "Jackie Molina", "ramon.cadeaux@synchronyfinancial.com", "2031234567", university));
//        people.add(new Person("02", "Joanne", "Kinvara", "Stamford", "IT", "Mobile Developer", "Dan Murphy", "joanne.swanson@synchronyfinancial.com", "2036449295", university));
//        people.add(new Person("03", "Tyler", "Whitlock", "Alpharetta", "Risk", "Risk One", "John Doe", "tyler.thisse@syncfin.com", "1231231111", university));
//        people.add(new Person("04", "Sofia", "Pena", "Kettering", "Sales", "Sales One", "John Doe", "sofia.grossman@syncfin.com", "1112223333", university));
//
//        Collections.sort(people);
//
//        return people;
//    }

    /*@Override
    public int compareTo(Person prsn) {
        return this.getLastName().compareTo(prsn.getLastName());
    } */


/*
    // Constructor to convert JSON object into a Java class instance
    public Person(JSONObject object){
        try {



            this.name = object.getString("name");
            this.location = object.getString("location");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // Factory method to convert an array of JSON objects into a list of objects
    // User.fromJson(jsonArray);
    public static ArrayList<Person> fromJson(JSONArray jsonObjects) {
        ArrayList<Person> people = new ArrayList<Person>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                people.add(new Person(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return people;
    }
*/
}
