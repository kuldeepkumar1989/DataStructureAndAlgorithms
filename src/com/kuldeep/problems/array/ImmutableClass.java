package com.kuldeep.problems.array;

public class ImmutableClass {

    public static void main(String args[]){
        Address a1 = new Address();
        a1.setCity("city");
        StringBuilder sb = new StringBuilder();
        sb.append("street1");
        a1.setStreet1(sb);

        StringBuilder sb1 = new StringBuilder();
        sb1.append("street2");
        a1.setStreet2(sb1);

        Person p1 = new Person(a1, "kuldeep");

        System.out.println(p1.hashCode());
        System.out.println(p1.getAddress().getStreet2());

        System.out.println("Update ==============");

        StringBuilder sb11 = new StringBuilder();
        sb11.append("street2Updated");
        p1.getAddress().getStreet2().append("app");
        System.out.println(p1.hashCode());

        System.out.println(p1.getAddress().getStreet2());

    }

}

final class Person{
    private Address address;
    private String name;

    Person(Address ad, String name){
        Address address1 = new Address();
        address1.setStreet2(ad.getStreet2());
        address1.setStreet1(ad.getStreet1());
        address1.setCity(ad.getCity());
        this.address = address1;
        this.name = name;
    }

    public Address getAddress() {
        Address address1 = new Address();
        address1.setStreet2(address.getStreet2());
        address1.setStreet1(address.getStreet1());
        address1.setCity(address.getCity());
        return address1;
    }

    public String getName() {
        return name;
    }
}

class Address {
    private StringBuilder street1;
    private StringBuilder street2;

    private String city;

    public StringBuilder getStreet1() {
        return street1;
    }

    public void setStreet1(StringBuilder street1) {
        this.street1 = street1;
    }

    public StringBuilder getStreet2() {
        return street2;
    }

    public void setStreet2(StringBuilder street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
