package ru.netology.taskmanagement.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    private Long id;
    @NotBlank(message = "название не может быть пустым")
    @Size(max = 200, message = "слишком длинное")
    private String title;
    private Boolean completed;
    @JsonProperty("createdDate")
    private LocalDate createdDate;


}
