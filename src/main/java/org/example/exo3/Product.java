package org.example.exo3;

public class Product {

    private String id;
    private String name;

    public Product(String id ) {
        this.id=id;
        this.name=name;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

}
