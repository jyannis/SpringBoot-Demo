package undestiny.springbootshiro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import undestiny.springbootshiro.entity.User;

@Data //@Setter+@Getter+@EqualsAndHashCode+@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String username;
    private String description;

    public UserDTO(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.description = user.getDescription();
    }

}
