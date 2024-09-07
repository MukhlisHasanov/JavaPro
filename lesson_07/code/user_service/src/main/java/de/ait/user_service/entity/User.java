package de.ait.user_service.entity;

import lombok.*;


@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode (of={"id","email"})
//@EqualsAndHashCode (exclude={"id","email"})
@Builder
public class User {
    @Setter
    private Long id;
    final private String name;
    final private String email;
    final private String password;
}
