package com.joalvarez.backshop.data.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.joalvarez.baseframework.data.dto.BaseDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductCategoryDTO implements BaseDTO {

}
