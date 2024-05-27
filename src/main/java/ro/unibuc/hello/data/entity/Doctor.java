package ro.unibuc.hello.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Doctor {
    @Id
    private String id;
    private String name;
    private String specialization;
    private String phoneNumber;
    private String email;
    private String clinicId;

}
