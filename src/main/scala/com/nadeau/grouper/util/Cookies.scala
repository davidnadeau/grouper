package com.nadeau.grouper.util

import scala.collection.mutable
import scala.util.Random

object Cookies {
  val cookies = mutable.Map[String, String]()
  def findOrCreate(key: String): String = cookies.getOrElse(key, {
    val token = Random.alphanumeric.take(12).mkString
    cookies.put(key, token)
    token
  })
}
