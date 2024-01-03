package vsla_admin.awareness.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

@Data   
public class AwarenessReq {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Image is required")
    private MultipartFile image;

    @NotBlank(message = "Video Url is required")
    private String videoUrl;
    List<GroupDto> groups;
    
}