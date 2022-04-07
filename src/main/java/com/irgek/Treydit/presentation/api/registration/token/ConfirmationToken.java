package com.irgek.Treydit.presentation.api.registration.token;

import com.irgek.Treydit.domain.Treyder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken extends AbstractPersistable<Long> {

    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiredAt;

    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
        nullable = false,
        name="treyder_id"
    )
    private Treyder treyder;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt,Treyder treyder){
            this.token = token;
            this.createdAt = createdAt;
            this.expiredAt = expiredAt;
            this.treyder = treyder;
    }

}
