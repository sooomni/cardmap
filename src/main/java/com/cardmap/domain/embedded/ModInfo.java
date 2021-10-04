package com.cardmap.domain.embedded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModInfo {

    private String modId;
    private String modIp;
    private LocalDateTime modDate;

    public void updateInfo(String modId, String modIp, LocalDateTime modDate)  {

        this.modId = modId;
        this.modIp = modIp;
        this.modDate = modDate;
    }
}
