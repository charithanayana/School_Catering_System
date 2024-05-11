package com.cn.catering.dto;

import com.cn.catering.model.Guardian;
import com.cn.catering.model.Menu;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuFeedbackDto {

    private String feedback;
    private int guardianId;
    private int menuId;

}
