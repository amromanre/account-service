package com.nttdata.account.models.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "accounts")
public class Account {
    @Id
    private String id;

    @NotEmpty
    private String accountNumber;

    @NotEmpty
    private String customerId;

    @NotEmpty
    private String accountType;

    //@NotEmpty
    private Double balance;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
}