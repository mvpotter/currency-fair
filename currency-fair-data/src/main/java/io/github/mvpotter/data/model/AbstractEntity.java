/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 21/03/15
 * Time: 00:03
 */
package io.github.mvpotter.data.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

}
