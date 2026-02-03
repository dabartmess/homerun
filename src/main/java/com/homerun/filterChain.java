@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/admin/**", "/api/admin/**").hasRole("ADMIN")
            .requestMatchers("/rider-entry", "/api/trips/**").permitAll()
            .anyRequest().authenticated()
        )
        .formLogin(withDefaults());
    return http.build();
}
