package com.example.demospringsecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "springsecurity";
        String encodedPassord = encoder.encode(rawPassword);
        System.out.println(encodedPassord);
//       codeJava = $2a$10$l34f9t6JbKFW/BU3WS5QR.MvYW63Omz0jHhlJGmhxJsYgZwGbtw1a
//       password1234 = $2a$10$bOkZZVyykNgcno2ob2rQ.ud/8Poa2Lrm9qjipsL76Equb4hpdG4CO
//       metallica = $2a$10$DTvhcP9gsE2DZhAeY7cghOF2gbComgUj.q03yNck375jbImq6IL4C
//       hdhd999 = $2a$10$MX6LZn.w1sT1kSTWMNDC/uzGa5yKl8Z1uEM.B.al2BJVw9Q3/dG0u
//       springsecurity = $2a$10$EHOJZ3TkIuqSQYQgbz182OtsCCf4JmOA0qRAfniLnCJ8qb48Y3kI6
    }
}
