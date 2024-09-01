package de.ait.user_service.entity;

import lombok.*;

@AllArgsConstructor
//@NoArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode (of = {"id","email"})
@Builder
@Setter
public class User {
    @Setter
    private Long id;
    private String name;
    private String email;
    private String password;

}
