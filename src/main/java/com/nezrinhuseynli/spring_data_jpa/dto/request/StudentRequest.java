package com.nezrinhuseynli.spring_data_jpa.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    @NotEmpty(message = "Ad bos ola bilmez!")
    @Size(min = 3, max = 20, message = "Daxil edilen deyer 3-20 arasi simvol ola biler.")
    private String firstName;

    @NotEmpty(message = "Soyad bos ola bilmez!")
    @Size(max = 20, message = "Daxil edilen deyer en cox 20 simvol ola biler.")
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthOfDate;


}
