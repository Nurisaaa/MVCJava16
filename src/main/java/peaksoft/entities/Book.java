package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(generator = "book_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "book_gen", sequenceName = "book_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String author;
    @ManyToOne
    private User user;
}
