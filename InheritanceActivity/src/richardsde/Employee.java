package richardsde;

import richardsde.Person;

public class Employee extends Person {
    private int id = 0;

    public Employee(String name, int id){
        super(name);
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("id: " + id);
    }


}
