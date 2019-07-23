package com.javagda25.tasks;


import lombok.*;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Long id;
    private String name;
    private LocalDateTime creationTime;
    private boolean done;
    private String creator;
}
