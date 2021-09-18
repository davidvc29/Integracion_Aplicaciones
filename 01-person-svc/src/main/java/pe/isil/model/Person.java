package pe.isil.model;

import lombok.*;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String  name;
    private String lastName;
    private Integer age;

}
