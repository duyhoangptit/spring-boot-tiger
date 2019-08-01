package vn.hoangptit.tiger.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.hoangptit.tiger.dto.WorkDTO;
import vn.hoangptit.tiger.model.Work;

/**
 * Create file WorkMapper
 *
 * @author duyhoangptit
 * @since 7/29/2019
 */
@Component
public class WorkMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Work convertToEntity(WorkDTO workDTO) {
        Work work = modelMapper.map(workDTO, Work.class);
        return work;
    }

    public WorkDTO convertToDto(Work work) {
        WorkDTO workDTO = modelMapper.map(work, WorkDTO.class);
        return workDTO;
    }
}
