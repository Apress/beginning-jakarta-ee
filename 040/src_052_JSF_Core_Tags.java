import javax.validation.constraints.NotBlank;
...
public class TheClass {
    @NotBlank(message = 
        "Last name must not be empty")
    private String lastName;
    ...
}
