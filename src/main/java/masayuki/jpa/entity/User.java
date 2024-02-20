package masayuki.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;

    private String name;

    @OneToOne
    @PrimaryKeyJoinColumn(
            name = "id", //coloum di table user
            referencedColumnName = "id" //coloum di table cerdential
    )
    private Credential credential;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @OneToOne(mappedBy = "user")
    private Wallet wallet;

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
