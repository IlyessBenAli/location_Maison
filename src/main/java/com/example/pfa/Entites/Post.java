package com.example.pfa.Entites;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table( name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Getter

@Setter
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column

    private String title;
    @Column

    private String description;
    @Column

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePub;
    @Column(length = 500000) // Adjust the length value as per your requirement
    private String image;

    @Column

    private int likes;
    @Column

    private boolean liked;
     @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

     @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();




}
