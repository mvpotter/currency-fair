/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 21/03/15
 * Time: 00:03
 */
package io.github.mvpotter.data.model;

import javax.persistence.*;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

}
