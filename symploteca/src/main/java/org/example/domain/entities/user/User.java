package org.example.domain.entities.user;

public abstract class User {
    private String institutionalId;
    private Integer numberOfBooksCheckedOut;
    private String name;
    private String email;
    private String phone;

    public abstract int getLimitOfBooksToCheckOut();
    public abstract int getCheckoutTimeLimitInDays();

    public User() {
        numberOfBooksCheckedOut = 0;
    }

    public User(String name, String email, String phone) {
        //chamada ao construtor de baixo
        this(null, 0, name, email, phone);
    }

    public User(String institutionalId, Integer numberOfBooksCheckedOut, String name, String email, String phone) {
        this.institutionalId = institutionalId;
        this.numberOfBooksCheckedOut = numberOfBooksCheckedOut;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    //empresta um livro
    public void increaseNumberOfBooksCheckedOut(){
        if(!isAbleToCheckOut()) {
            throw new IlegalNumberOfCheckedOutItensException("User " + name + " exceeded  the limit of books checked out: " + getLimitOfBooksToCheckOut());
        }
            numberOfBooksCheckedOut++;

    }

    //verifica se o número de livros emprestados é menor do que o limite de empréstimo
    private boolean isAbleToCheckOut() {
        return numberOfBooksCheckedOut < getLimitOfBooksToCheckOut();
    }

    public void decreaseNumberOfBooksCheckedOut(){
        if(numberOfBooksCheckedOut == 0){
            throw new IlegalNumberOfCheckedOutItensException("The number of books checked can not be negative");
        }

        numberOfBooksCheckedOut--;
    }

    public String getInstitutionalId() {
        return institutionalId;
    }

    public void setInstitutionalId(String institutionalId) {
        this.institutionalId = institutionalId;
    }

    public Integer getNumberOfBooksCheckedOut() {
        return numberOfBooksCheckedOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "institutionalId='" + institutionalId + '\'' +
                ", numberOfBooksCheckedOut=" + numberOfBooksCheckedOut +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
