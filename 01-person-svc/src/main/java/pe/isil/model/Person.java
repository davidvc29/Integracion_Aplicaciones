package pe.isil.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Person {
    private String  name;
    private String lastName;
    private Integer age;
}
