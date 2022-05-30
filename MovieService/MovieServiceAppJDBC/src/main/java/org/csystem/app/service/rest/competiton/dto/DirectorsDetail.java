package org.csystem.app.service.rest.competiton.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.csystem.app.service.rest.competiton.entity.DirectorDetail;

import java.util.List;

public class DirectorsDetail {
   private List<DirectorDetail> directorDetails;

   @JsonProperty("directors")
   public List<DirectorDetail> getDirectorDetails() {
      return directorDetails;
   }


   public void setDirectorDetails(List<DirectorDetail> directorDetails) {
      this.directorDetails = directorDetails;
   }
}
