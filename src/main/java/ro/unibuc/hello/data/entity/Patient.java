package ro.unibuc.hello.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Patient {
    @Id
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private Date DoB;   // date of birth
    private String clinicId;

}
