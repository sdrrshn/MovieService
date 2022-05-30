package org.csystem.app.service.rest.competiton.maper;

import org.csystem.app.service.rest.competiton.dto.DirectorsDetail;
import org.csystem.app.service.rest.competiton.entity.DirectorDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "DirectoryImpl",componentModel = "spring")
public interface IDirectorMapper {

    DirectorDetail toDirectorDetailDto(DirectorDetail directorDetail);


       default DirectorsDetail toDirectorsDetail(List<DirectorDetail> directorDetail){
       var result=new DirectorsDetail();
       result.setDirectorDetails(directorDetail);
       return result;


   }
}
