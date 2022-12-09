package org.sourpy.ecomapp.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_api")
public class UserApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String apiKey;
    private String apiSecretKey;
    private String sellerId;
    @Enumerated(EnumType.STRING)
    private UserApiType userApiType;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
