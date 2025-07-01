package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private Long Id;

    @Column(nullable = false)
    private String creationDate;

    @OneToOne
    @JoinColumn(name="client", nullable=false, unique=true)
    private Client client;

    @OneToMany(mappedBy="portfolio")
    private List<Security> securities;

    protected Portfolio() {}

    public Portfolio(String creationDate, Client client) {
        this.creationDate = creationDate;
        this.client = client;
        this.securities = new ArrayList<Security>();
    }
}
