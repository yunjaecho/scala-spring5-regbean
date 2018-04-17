package com.yunjae.regbean

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.reactive.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.web.reactive.function.server.{RouterFunction, ServerRequest, ServerResponse}
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunctions.route
import reactor.core.publisher.{Flux, Mono}


@SpringBootApplication
class BootConfiguration {

//  @Bean
//  def routes():RouterFunction[ServerResponse] = {
//    route(GET("/hi"), (req: ServerRequest) => ServerResponse.ok().body(Mono.just("Hello world!"), classOf[String]))
//  }

  @Bean
  def securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain = {
    http
      .authorizeExchange()
      .matchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
      .pathMatchers("/my/hello.html").permitAll()
      .pathMatchers("/foo", "/bar")
      .authenticated().and()
      .formLogin()

    http.build()
  }
}
