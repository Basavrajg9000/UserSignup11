@RestController
@RequestMapping("/api/signup")
public class UserSignupController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> signup(@RequestBody User user) {
        // Check if user already exists (optional)
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        // Create a new user
        userService.createUser(user);
        return ResponseEntity.ok("User created successfully");
    }
}

@RestController
@RequestMapping("/api/signin")
public class UserSigninController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> signin(@RequestBody User user) {
        // Logic for user authentication using Spring Security or JWT
        // Validate credentials and generate tokens (JWT or session)
        // Return success or failure response based on authentication
        return ResponseEntity.ok("Signin successful");
    }
}

@RestController
@RequestMapping("/api/forgot-password")
public class ForgotPasswordController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> forgotPassword(@RequestBody String email) {
        // Logic for initiating password reset flow
        // Generate a reset token, associate it with the user, and send reset link via email
        return ResponseEntity.ok("Password reset initiated");
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        // Logic for resetting password using the reset token
        // Update user's password with the new password
        return ResponseEntity.ok("Password reset successful");
    }
}
