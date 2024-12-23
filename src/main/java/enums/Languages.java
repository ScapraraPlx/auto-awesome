package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Languages {
    US_EN("US (EN)"),
    US_SP("US (SP)");

    private String name;
}
