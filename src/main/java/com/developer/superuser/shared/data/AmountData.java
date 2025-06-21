package com.developer.superuser.shared.data;

import com.developer.superuser.shared.enumeration.Currency;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, setterPrefix = "set")
@EqualsAndHashCode
@ToString(callSuper = true)
public class AmountData {
    private BigDecimal value;
    private Currency currency;
}