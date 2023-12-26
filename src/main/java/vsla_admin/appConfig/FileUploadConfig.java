package vsla_admin.appConfig;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class FileUploadConfig {
    @Bean
    public Cloudinary cloudinaryConfig() {
        try {
            Map<String, String> config = new HashMap<>();
            config.put("cloud_name", "do394twgw");
            config.put("api_key", "563676698242191");
            config.put("api_secret", "fYRKyRcysOZmtWP06cgXRu_Fpq0");
            return new Cloudinary(config);
        } catch (Exception ex) {
            throw new IllegalStateException("Error creating Cloudinary bean.", ex);
        }
    }
}
