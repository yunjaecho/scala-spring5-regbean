package com.yunjae.regbean.contrroller

import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
class SampleController {

  @GetMapping(Array("/foo"))
  def getFoo(): String =  "foo"

  @GetMapping(Array("/bar"))
  def getBar(): String =  "bar"
}
