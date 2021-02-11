package org.cesi.fablab.api.dto;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.SiteEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiteDTO {
    private long id;
    @NotNull
    private String name;
    private String description;
    // private List<HolidayDTO> holidaysList = new ArrayList<HolidayDTO>();

    public SiteDTO(final SiteEntity siteEntity) {
        super();
        this.id = siteEntity.getId();
        this.name = siteEntity.getName();
        this.description = siteEntity.getDescription();
        // this.holidaysList = siteEntity.getHolidaysList();
    }

}
