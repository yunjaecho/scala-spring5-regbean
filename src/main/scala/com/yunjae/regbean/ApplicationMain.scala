package com.yunjae.regbean

import com.yunjae.regbean.service.CustomService
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.boot.SpringApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.GenericApplicationContext
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.{RouterFunction, ServerRequest, ServerResponse}
import org.springframework.web.reactive.function.server.RouterFunctions.route
import reactor.core.publisher.Mono

object ApplicationMain {

  def main(args: Array[String]): Unit = {
    new SpringApplicationBuilder()
      .sources(classOf[BootConfiguration])
      .initializers((ctx: GenericApplicationContext) => {

        ctx.registerBean(classOf[CustomService])

        ctx.registerBean(classOf[RouterFunction[ServerResponse]], () => {
          route(GET("/hi"), (req: ServerRequest) => ServerResponse.ok().body(Mono.just("Hello world!"), classOf[String]))
        })

      }).run()

    //SpringApplication.run(classOf[BootConfiguration])
  }
}